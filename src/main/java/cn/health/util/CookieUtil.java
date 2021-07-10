package cn.health.util;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


public class CookieUtil {
    /**
     * 向客户端设置cookie
     * @param response
     * @param name cookie的名称
     * @param value cookie的值
     * @param maxAge cookie的存活时间
     */
    public static void setCookie(HttpServletResponse response,
                                 String name,
                                 String value,
                                 int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 向客户端设置cookie
     * @param response
     * @param name cookie的名称
     * @param value cookie的值
     */
    public static void setCookie(HttpServletResponse response,
                                 String name,
                                 String value
    ){
        Cookie cookie = new Cookie(name,value);
        response.addCookie(cookie);
    }

    /**
     * 获取客户端存放的Cookies
     * @param request
     * @param name Cookie的名称
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request,String name){
        Map<String, Cookie> cookieMap = getCookieMap(request);
        if (cookieMap.containsKey(name)) {
            return cookieMap.get(name);
        }
        return null;
    }


    private static Map<String, Cookie> getCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
