package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK); // 200 ok

        // [response-headers]
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // cache 완전 무효화
        response.setHeader("Pragma", "no-cache"); // 과거꺼도 캐시 다 무효화
        response.setHeader("my-header", "hello");

        // [Header 편의 메서드]
        /*
         * 기존에 setHeader 를 통해서 모두 하나씩 세팅해주던 방식에서
         * setContentType, CharacterEncoding 통해서 바로 넣어줄 수 있음.
         * */
//        content(response);
//        cookie(response);
        redirect(response);

        response.getWriter().write("하이하이방가루");
    }

    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8"); 이거 지정해줄 필요 없이 밑에 두줄로 퉁치기
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); // 오 이거 생략하면 자동생성해줌

    }

    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");

        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); // 600초
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //원하는 header 의 최종 결과값
        //Status Code 302
        //Location: /basic/hello-form/html

//        response.setStatus(HttpServletResponse.SC_FOUND); // 302
//        response.setHeader("Location", "/basic/hello-form.html");

        // 위의 두 줄로 하나식 세팅해주는 방법에서 sendRedirect 통해서 바로 사용 가능
        response.sendRedirect("/basic/hello-form.html");
    }
}
