package hello.servlet.web.frontcontroller.v5;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    // handler 가 매핑된 데이터 저장
    private final Map<String, Object> handlerMappingMap = new HashMap<>();
}
