package com.example.BUS;

import com.example.DAO.MemberDAO;
import com.example.Model.Member;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemberAdd", value = "/MemberAdd")
public class MemberAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Member member;  
        boolean check = false;
        
        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        mapper.writeValue(response.getOutputStream(), check);
    }
}
