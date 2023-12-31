package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);
    }

    private void printEtc(HttpServletRequest request) {
        System.out.println("---- 기타 조회 start --- ");

        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() =" + request.getRemoteAddr());
        System.out.println("request.getRemotePort() = " + request.getRemotePort());

        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " + request.getLocalName());
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
        System.out.println("request.getLocalPort() = " + request.getLocalPort());

        System.out.println("---기타 조회 end --- ");
        System.out.println();
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

//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName + ": " 한+ headerName);
//        }
        // iterator 사용한 출력 방식
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ": " + headerName));

        System.out.println("test?");
        // header 의 특정 정보만 알고싶을 경우
        request.getHeader("host");

        System.out.println("---- Headers - end ---");
        System.out.println();
    }

    // 편리한 방식으로 정보 출력
    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println(" --- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " + request.getServerName()); // Host 헤더
        System.out.println("request.getServerPort() = " + request.getServerPort()); // Host 헤더
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();

        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();

        /*
         * null로 조회되는 이유?
         * GET 방식은 단순 조회. body쪽에 담기는게 없음.
         * POSTMAN을 통해 POST로 쏴서 확인 가능!
         * */
        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());

        System.out.println("--- Header 편의 조회 end --- ");
        System.out.println();
    }
}
