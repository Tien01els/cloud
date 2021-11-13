package com.example.BUS;

import com.example.DAO.MemberDAO;
import com.example.Model.Member;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemberDelete", value = "/MemberDelete")
public class MemberDelete extends HttpServlet {
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean check = true;

        ObjectMapper mapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        mapper.writeValue(response.getOutputStream(), check);
    }
}
