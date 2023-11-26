package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        printStartLine(request);
        printHeaders(request);
    }
    private static void printStartLine(HttpServletRequest request) {
        // 첫 header 만들어보기
        System.out.println("--- REQUEST-LINE - start ---");

        System.out.println("request.getMethod() = " + request.getMethod()); // GET
        System.out.println("request.getProtocal() = " + request.getProtocol()); // HTTP/1.1
        System.out.println("request.getScheme() = " + request.getScheme()); // http

        // /request-test 뒤에 붙은 애만 보여줘
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        // http://localhost:8080/request-header 전체 url을 보여준다
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        //username=hi
        System.out.println("reqeust.getQueryString() = " + request.getQueryString());
        System.out.println("reqeust.isSecure() = " + request.isSecure()); // https 사용 유무
        System.out.println("--- REQUEST-LINE - end --- ");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("---- Headers - start ---");

        // 이전에 사용하던 구식 방식 = headerNames 다 가져와서 while문으로 출력

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ": " + headerName);
        }

        System.out.println("---- Headers - end ---");

    }
}
