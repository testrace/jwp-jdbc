package core.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HandlerInterceptor {

    default boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return true;
    };

    default void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

    };

    default void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler) {

    };
}