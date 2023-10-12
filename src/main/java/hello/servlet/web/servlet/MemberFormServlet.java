package hello.servlet.web.servlet;

import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//회원 등록용 서블릿
@WebServlet(name = "memberFormServlet" , urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HttpServlet {

    //멤버 레포지토리 필요함
    private MemberRepository memberRepository = MemberRepository.getInstance();//싱글톤이라 이렇게 들고 옴

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //응답으로 html이 나가야 하니까
        //Content Body를 잡아줘야 한다.
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter w = response.getWriter();
        //여기서 html 응답할 모양을 작성해줌 : 회원이 등록할 정보를 html 폼 형태로 받기 위해
        //서블릿으로 사용하다보니, 자바 코드로 작성해야 하니 불편하다.
        w.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/servlet/members/save\" method=\"post\">\n" +
                "    username: <input type=\"text\" name=\"username\" />\n" +
                "    age:      <input type=\"text\" name=\"age\" />\n" +
                "    <button type=\"submit\">전송</button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>\n");
    }
}
