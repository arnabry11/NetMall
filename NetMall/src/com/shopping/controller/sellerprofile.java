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

import com.shopping.beans.SellerBean;

/**
 * Servlet implementation class sellerprofile
 */
@WebServlet("/sellerprofile")
public class sellerprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sellerprofile() {
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
		SellerBean sb=(SellerBean)session.getAttribute("activesess");
		if(sb.getEname()!=null) {
			//String name=(String)session.getAttribute("name");
			
			//out.print("Hello, "+name+"Welcome to Profile");
			RequestDispatcher rd=request.getRequestDispatcher("sellerfunctions.jsp");
			rd.include(request, response);
		}
		else {
			out.print("Please Login First");
			request.getRequestDispatcher("sellerlogin.jsp").include(request, response);
		}
	}

}
