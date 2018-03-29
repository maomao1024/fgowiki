package com.github.fgowiki.utils;

import com.alibaba.fastjson.JSON;
import com.github.fgowiki.api.entity.FgoUser;
import com.github.fgowiki.api.entity.SysConfig;
import com.github.fgowiki.api.service.ConfigService;
import com.github.fgowiki.exception.CheckedException;
import com.github.fgowiki.exception.UnloginException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author jiang
 * @create 2018-03-26 19:22
 **/
public abstract class TokenUtils {

    private static final String TOKEN_EXPIRATION = "token_expiration";
    private static final String TOKEN_SECRET_KEY = "token_secret_key";
    private static final String TOKEN_REFRESH_TIME = "token_refresh_time";

    private static ConfigService configService;

    static {
        configService = SpringContextUtils.getBean(ConfigService.class);
    }

    public static String generateToken(FgoUser user) {
        if (user == null) {
            throw new UnloginException("请重新登录");
        }
        String expiration = configService.getSysConfig(TOKEN_EXPIRATION);
        String secretKey = configService.getSysConfig(TOKEN_SECRET_KEY);
        return Jwts
                .builder()
                .setSubject("user")
                .claim("user", JSON.toJSONString(user))
                .setIssuedAt(new Date())
                .setIssuer("fgowiki")
                .setExpiration(new Date(System.currentTimeMillis() + Long.valueOf(expiration) * 1000))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    private static String refreshToken(Claims claims){
        String expiration = configService.getSysConfig(TOKEN_EXPIRATION);
        String secretKey = configService.getSysConfig(TOKEN_SECRET_KEY);
        return Jwts
                .builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setIssuer("fgowiki")
                .setExpiration(new Date(System.currentTimeMillis() + Long.valueOf(expiration) * 1000))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public static Claims parse(String token) {
        String secretKey = configService.getSysConfig(TOKEN_SECRET_KEY);
        try {
            Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
            long refresh = System.currentTimeMillis() - claims.getExpiration().getTime();
            if (refresh >= 0 && refresh <= Long.valueOf(configService.getSysConfig(TOKEN_REFRESH_TIME)) * 1000) {
                //token超时但没有超过系统预设的时间 刷新token
                token = refreshToken(claims);
                claims = parse(token);
                ResponseUtils.setHeader("Authorization", "RefreshToken " + token);
            }
            return claims;
        } catch (Exception e) {
            throw new CheckedException("无效的token");
        }
    }
}
