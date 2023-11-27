package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV4 extends HttpServlet {

    // 생성 시 미리 매핑을 해둬서 어떤 컨트롤러를 호출할지 맞춰 놓는다.
    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String requestURI = request.getRequestURI(); // 주소의 슬래시 뒤 (/front-co~~) 부분을 다 받아올 수 있음.
        //interface 로 구현했으니까 퉁칠수 있네 ... 다형성
        ControllerV4 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        /*paramMap 을 넘겨줘야함.
         * parameter 내부에 저장된 값들을 모두 넣어주기 위해 한 작업들
         * 1. request 내부에 있는 모든 Parameter 뽑아옴
         * 2. 돌면서 paramMap 에다 넣어줌 (name, value)
         * */

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);
        MyView view = viewResolver(viewName);

        view.render(model, request, response);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName ->
                        paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;
    }
}
