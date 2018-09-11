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
 * Servlet implementation class buynow
 */
@WebServlet("/buynow")
public class buynow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buynow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/HTML");
		String name="",cemail="";
		HttpSession session=request.getSession(false);
		try{
			CustBean b=(CustBean)session.getAttribute("activesess");
			 name=b.getEname();
			 cemail=b.getEemail();
			 
			 session.setAttribute("activesess", b);
		}
		catch(Exception e){
			System.out.println("Session Object Empty");
			e.printStackTrace();
			response.sendRedirect("custlogin.jsp");
			}
		
		
		
		
		
		int stock=0;
		String itemid=request.getParameter("itemid");
		String qua=request.getParameter("quantity");
		int quan=Integer.parseInt(qua);
		mydoau d=new mydoau();
		ResultSet rs=d.getItemAttributes(itemid);
		try {
			if(rs.next()) {
				stock=Integer.parseInt(rs.getString(5));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(stock>=quan) {
			int result=d.updateStock(itemid, stock-quan);
			if(result!=0)
			{
				response.sendRedirect("buyout.jsp");
			}
			else
			{
				out.println("<script>alert('Some error ! Please Try again')</script>");
				RequestDispatcher rd=request.getRequestDispatcher("custfunctions.jsp");
				rd.include(request, response);
			}
		}
		else {
			out.println("<script>alert('Item Out Of Stock')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("custfunctions.jsp");
			rd.include(request, response);
			
		}
		
		d.closeCon();
		
	}

}
