package com.github.fgowiki.utils;

import com.github.fgowiki.api.entity.FgoUser;
import com.github.fgowiki.api.entity.SysConfig;
import com.github.fgowiki.api.service.ConfigService;
import com.github.fgowiki.exception.UnloginException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * @author jiang
 * @create 2018-03-26 19:22
 **/
public abstract class TokenUtils {

    private static final String TOKEN_EXPIRATION = "token_expiration";
    private static final String TOKEN_SECRET_KEY = "token_secret_key";

    private static ConfigService configService;

    static {
        configService = SpringContextUtils.getBean(ConfigService.class);
    }

    public static String generateToken(FgoUser user) {
        if (user == null) {
            throw new UnloginException("未登录,请重新登录");
        }
        SysConfig expiration = configService.getSysConfig(TOKEN_EXPIRATION);
        SysConfig secretKey = configService.getSysConfig(TOKEN_SECRET_KEY);
        return Jwts
                .builder()
                .setSubject("user")
                .claim("roles", user.getRoles())
                .claim("id", user.getUid())
                .setIssuedAt(new Date())
                .setIssuer("fgowiki")
                .setExpiration(new Date(System.currentTimeMillis() + Long.valueOf(expiration.getValue())))
                .signWith(SignatureAlgorithm.HS256, secretKey.getValue())
                .compact();
    }

    public static Claims parse(String token) {
        SysConfig secretKey = configService.getSysConfig(TOKEN_SECRET_KEY);
        return Jwts.parser()
                .setSigningKey(secretKey.getValue())
                .parseClaimsJws(token).getBody();
    }
}
