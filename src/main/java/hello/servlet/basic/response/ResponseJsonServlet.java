package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Content-Type: application/json

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8"); // json은 자체적으로 내정되어 있어서 필요 없는애긴 함.

        HelloData helloData = new HelloData();
        helloData.setUsername("sohyun");
        helloData.setAge(99);

        //{"username"="sohyun", "age"=99}
        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);
    }
}
