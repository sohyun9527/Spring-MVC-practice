package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") // /hello 라는 url 호출 시 해당 서블릿 이름(helloServlet) 을 실행한다. 중복 불가!
public class HelloServlet extends HttpServlet {

    // 컨트롤 + O -> service 상속받음.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");

        // WAS 서버의 구현체들 출력
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // request.getParameter ->  쿼리 파라미터를 쉽게 읽을 수 있도록 지원해준다.
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 이 밑에 두개는 header 세팅
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //getWriter.write -> http.body에 메세지가 다 들어간다.
        response.getWriter().write("hello " + username);
    }
}
