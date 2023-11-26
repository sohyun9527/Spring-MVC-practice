package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {
    //v1은 controller 가 forward 까지 처리하는 방식에서 view 를 보여주는걸 MyView 의 책임으로 변경
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
