package com.shopping.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.beans.CustBean;

import com.shopping.doau.mydoau;

/**
 * Servlet implementation class custlogin
 */
@WebServlet("/custlogin")
public class custlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public custlogin() {
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
		String eemail=request.getParameter("email");
		String epassword=request.getParameter("pass");
		
		CustBean cb=new CustBean();
		cb.setEemail(eemail);;
		cb.setEpassword(epassword);
		
		mydoau d=new mydoau();
		ResultSet rs= d.loginCust(cb);
		
		try {
			if(rs.next()) {
				
				
				HttpSession session=request.getSession();
				cb.setEname(rs.getString(2));
				cb.setEemail(eemail);
				cb.setEid(rs.getString(1));
				session.setAttribute("activesess",cb );
				d.closeCon();
				out.print("<script>alert(\"Login SuccessFul\")</script>");
				RequestDispatcher rd=request.getRequestDispatcher("custprofile");
				rd.include(request, response);
			}
			else {
				d.closeCon();
				out.println("<script>alert('Sorry, username or password error ! ')</script>");
				RequestDispatcher rd=request.getRequestDispatcher("custlogin.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
