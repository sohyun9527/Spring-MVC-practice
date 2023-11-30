package hello.servlet.web.springmvc.old;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// SpringBean 이름을 url 패턴으로 맞춤
@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");

        // 논리적인 이름으로 물리적인 view 를 그려줌 -> Spring Boot 가 application.properties 를 뒤져서 prefix, surfix 찾아와
        // 0순위 -> BeanNameViewResolver : 빈 이름으로 뷰 찾아서 반환하기
        // 1순위 -> InternalResourceViewResolver : JSP 처리 가능한 뷰 반환 이번엔 1순위가 호출된거!(내부에서 자원 이동, 찾기)
        return new ModelAndView("new-form");
    }

    /* Spring Boot 가 자동등록하는 핸들러 매핑, 핸들러 어댑터

     * HandlerMapping
     * 0 순위 -> RequestMappingHandlerMapping : 애노테이션 기반의 컨트롤러인 @RequestMapping 에서 사용
     * 1 순위 -> BeanNameUrlHandlerMapping : 스프링 빈의 이름으로 핸들러를 찾는다.
     *
     * 여기의 경우 RequestMapping 없으니까 url 패턴으로 핸들러를 찾아온 것

     HandlerAdapter
     0 순위 -> RequestMappingHandlerAdapter : @RequestMapping 에서 사용
     1 순위 -> HttpRequestHandlerAdapter : HttpRequestHandler 처리
     2 순위 -> SimpleControllerHandlerAdapter : Controller 인터페이스 (애노테이션 X, implements Controller) 처리
     */
}
