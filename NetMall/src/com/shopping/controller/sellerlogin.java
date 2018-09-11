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

import com.shopping.beans.SellerBean;
import com.shopping.doau.mydoau;

/**
 * Servlet implementation class sellerlogin
 */
@WebServlet("/sellerlogin")
public class sellerlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sellerlogin() {
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
		String eid=request.getParameter("id");
		String epassword=request.getParameter("pass");
		
		SellerBean sb=new SellerBean();
		sb.setEid(eid);
		sb.setEpassword(epassword);
		
		mydoau d=new mydoau();
		ResultSet rs= d.login(sb);
		
		try {
			if(rs.next()) {
				
				
				HttpSession session=request.getSession();
				sb.setEname(rs.getString(1));
				session.setAttribute("activesess",sb );
				
				out.println("<script>alert(\"Login SuccessFul\")</script>");
				RequestDispatcher rd=request.getRequestDispatcher("sellerprofile");
				rd.include(request, response);
			}
			else {
				out.println("<script>alert('Sorry, username or password error !')</script>");
				RequestDispatcher rd=request.getRequestDispatcher("sellerlogin.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
