package com.shopping.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.beans.CustBean;


/**
 * Servlet implementation class custprofile
 */
@WebServlet("/custprofile")
public class custprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public custprofile() {
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
		
		HttpSession session=request.getSession(false);
		CustBean cb=(CustBean)session.getAttribute("activesess");
		if(cb.getEname()!=null) {
			//String name=(String)session.getAttribute("name");
			
			//out.print("Hello, "+name+"Welcome to Profile");
			RequestDispatcher rd=request.getRequestDispatcher("custfunctions.jsp");
			rd.include(request, response);
			
		}
		else {
			out.print("<script>alert('Please Login First')</script>");
			request.getRequestDispatcher("custlogin.jsp").include(request, response);
		}
		
		
	}

}
