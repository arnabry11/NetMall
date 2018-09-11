package com.shopping.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.doau.mydoau;

/**
 * Servlet implementation class removeseller
 */
@WebServlet("/removeseller")
public class removeseller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeseller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String eid=request.getParameter("id");
		PrintWriter out=response.getWriter();
		response.setContentType("text/HTML");
		mydoau d=new mydoau();
		int result=d.delete(eid);
		d.closeCon();
		if(result!=0) {
			out.print("<p style=\" color:green;\">Delete Success </p>");
			RequestDispatcher rd=request.getRequestDispatcher("adminfunctions.jsp");
			rd.include(request, response);
		}
		else {
			out.print("<p style=\" color:red;\"><i>INVALID seller ID !! Please try again</i></p>");
			RequestDispatcher rd=request.getRequestDispatcher("removeseller.jsp");
			rd.include(request, response);
		}
	}

}
