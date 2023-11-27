package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    /*
     * support -> 어댑터가 해당 object를 처리할 수 있는지 판별.
     * 뒤적여서 어 나 얘 알어 하면 t, 아니면 f
     * */
    boolean supports(Object handler);

    /*
     * 어댑터는 실제 컨트롤러를 호출, 결과로 ModelView 반환.
     * object 가 ModelView 반환 실패 시, 어댑터가 ModelView 를 직접 생성해서라도 반환.
     * 이전에는 프론트 컨트롤러가 실제 컨트롤러를 호출, 하지만 이 어댑터를 통해 실제 컨트롤러 호출.
     * */
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException, IOException;
}
