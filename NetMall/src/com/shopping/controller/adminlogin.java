package com.shopping.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminlogin
 */
@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/HTML");
		String ename=request.getParameter("name");
		String epass=request.getParameter("pass");
		
		if(ename.equals("admin")&& epass.equals("admin123")) {
			out.print("<script>alert(\"Login Successful\")</script>");
			RequestDispatcher rd=request.getRequestDispatcher("adminfunctions.jsp");
			rd.include(request, response);;
		}
		else {
			out.print("Username OR Password error");
			RequestDispatcher rd=request.getRequestDispatcher("adminlogin.jsp");
			rd.include(request, response);
		}
	}

	

}
