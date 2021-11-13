package com.example.BUS;

import com.example.DAO.MemberDAO;
import com.example.Model.Member;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/showMember"})
public class MemberBUS extends HttpServlet {
    private Member member;

    public void init() {this.member = new Member();}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//

        this.doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Member member = MemberDAO.selectMeber();

        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        mapper.writeValue(response.getOutputStream(), member);
    }
}
