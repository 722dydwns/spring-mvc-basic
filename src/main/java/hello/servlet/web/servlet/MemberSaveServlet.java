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

//회원 저장용 서블릿
@WebServlet(name="memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    //멤버 레포지토리 필요함
    private MemberRepository memberRepository = MemberRepository.getInstance();//싱글톤이라 이렇게 들고 옴

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       ///여기서는 폼에 입력된 회원 정보를 가져와서 읽고, 저장해야 함
        System.out.println("memberSaveServlet.service() ");
        //request로 접근해서 정보 얻어오기
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        //멤버 객체 만듬
        Member member = new Member(username, age);
        //레포지토리에 저장
        memberRepository.save(member);

        //저장 잘 됐는지 응답을 response에 html로 세팅해서 코드로 보내보기
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter w = response.getWriter();

        w.write("<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "성공\n" +
                "<ul>\n" +
                "    <li>id="+member.getId()+"</li>\n" +
                "    <li>username="+member.getUserName()+"</li>\n" +
                "    <li>age="+member.getAge()+"</li>\n" +
                "</ul>\n" +
                "<a href=\"/index.html\">메인</a>\n" +
                "</body>\n" +
                "</html>");
    }
}
