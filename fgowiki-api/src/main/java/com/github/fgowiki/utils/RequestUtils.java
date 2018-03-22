package com.github.fgowiki.utils;

import com.google.common.base.Strings;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jiang
 * @create 2018-03-22 22:45
 **/
public abstract class RequestUtils {

    private static final String[] IP_HEADERS = new String[]{"x-forwarded-for", "Proxy-Client-IP", "WL-Proxy-Client-IP"};
    private static final String IP_UNKNOWN = "unknown";

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取远程IP
     * 解决在经过反向代理后无法获取真实ip
     * @return
     */
    public static String getIpAddr() {
        HttpServletRequest request = getRequest();
        for (String header : IP_HEADERS) {
            String ips = request.getHeader(header);
            if (Strings.isNullOrEmpty(ips)) {
                continue;
            }
            for (String ip : ips.split(",")) {
                if (!IP_UNKNOWN.equals(ip.trim())) {
                    return ip;
                }
            }
        }
        return request.getRemoteAddr();
    }
}
