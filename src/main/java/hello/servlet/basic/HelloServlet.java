package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") //url패턴을 /hello로 줬음 : localhost:8080/hello로 들어가면 여기가 동작
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service() 함수 호출");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username" );
        System.out.println("username  : "+username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello  !  " + username);
    }
}
