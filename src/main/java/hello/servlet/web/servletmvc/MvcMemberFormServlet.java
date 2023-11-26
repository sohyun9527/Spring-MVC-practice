package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//controller 역할
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        // WEB-INF ? 꼭 컨트롤러를 거쳐서 호출을 받고싶음. 외부에서 그냥 호출하면 호출 안당할거임요

        // dispatcher: controller -> view 이동 시 사용
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        /*
        forward -> servlet 에서 jsp 호출 가능
        다른 서블릿이나 JSP로 이동할 수 있는 기능. 서버 내부에서 다시 호출이 발생한다. 클라이언트와 재소통하는 redirect X
        */
        dispatcher.forward(request, response);
    }
}
