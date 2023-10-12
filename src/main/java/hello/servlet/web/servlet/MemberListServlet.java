package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//회원정보 목록 얻어오는 서블릿
@WebServlet(name="memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();//싱글톤이라 이렇게 들고 옴

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //리스트만 꺼내서 응답하면 됨

        List<Member> members =memberRepository.findAll();

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        //응답으로 보낼 response에 html형태로 가져와서 보냄

        PrintWriter w = response.getWriter();
        w.write("<html>");
        w.write("<head>");
        w.write("    <meta charset=\"UTF-8\">");
        w.write("    <title>Title</title>");
        w.write("</head>");
        w.write("<body>");
        w.write("<a href=\"/index.html\">메인</a>");
        w.write("<table>");
        w.write("    <thead>");
        w.write("    <th>id</th>");
        w.write("    <th>username</th>");
        w.write("    <th>age</th>");
        w.write("    </thead>");
        w.write("    <tbody>");

        //List로 얻은 각 Member의 객체를 id, name, age 순으로 출력해서 html로 보낸다.
        for (Member member : members) {
            w.write("    <tr>");
            w.write("        <td>"+member.getId()+"</td>");
            w.write("        <td>"+member.getUserName()+"</td>");
            w.write("        <td>"+member.getAge()+"</td>");
            w.write("    </tr>");
        }

        w.write("    </tbody>");
        w.write("</table>");
        w.write("</body>");
        w.write("</html>");
    }
}
