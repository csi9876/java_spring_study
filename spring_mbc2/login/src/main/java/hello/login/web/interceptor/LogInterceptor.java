package hello.login.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    public static final String LOG_ID = "logId";


    // 컨트롤러 호출 전 호출
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();     // 요청 로그 구분을 위한 uuid
        request.setAttribute(LOG_ID, uuid);

        //@RequestMapping의 경우: HandlerMethod 사용
        //정적 리소스의 경우: ResourceHttpRequestHandler 사용
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler; //호출할 컨트롤러 메서드의 모든 정보가 포함되어 있다.
        }
        log.info("REQUEST [{}][{}][{}]", uuid, requestURI, handler);
        return true; //false 면 진행X
    }


    // 컨트롤러 호출 후 호출
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.info("postHandle [{}]", modelAndView);
    }

    // 뷰 렌더링 이후 호출
    // 예외가 발생해도 호출
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse
            response, Object handler, Exception ex) throws Exception {

        String requestURI = request.getRequestURI(); String logId = (String)request.getAttribute(LOG_ID);
        log.info("RESPONSE [{}][{}]", logId, requestURI);

        if (ex != null) {
            log.error("afterCompletion error!!", ex);
        }
    }
}