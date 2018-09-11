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

import com.shopping.beans.SellerBean;
import com.shopping.doau.mydoau;

/**
 * Servlet implementation class newseller
 */
@WebServlet("/newseller")
public class newseller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newseller() {
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
		response.setContentType("text/html");
		
		String ename=request.getParameter("name");
		String econtact=request.getParameter("contact");
		String eemail=request.getParameter("email");
		String eaddress=request.getParameter("address");
		String ecity=request.getParameter("city");
		String estate=request.getParameter("state");
		String epin=request.getParameter("pin");
		
		SellerBean sb=new SellerBean();
		sb.setEaddress(eaddress);
		sb.setEcity(ecity);
		sb.setEcontact(econtact);
		sb.setEemail(eemail);
		sb.setEname(ename);
		sb.setEpin(epin);
		sb.setEstate(estate);
		
		mydoau d=new mydoau();
		int result=d.insert(sb);
		
		if(result!=0)
		{
			String id="",pass="";
			
			ResultSet rs=d.getSellerId(eemail);
			try {
				while(rs.next()) {
					id=rs.getString(1);
					pass=rs.getString(2);
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println("<p style=\" color:green;\"> Seller Created Successfully.  <br> The New Seller Has ID = "+id+" and password is "+pass +"</p>");
			RequestDispatcher rd=request.getRequestDispatcher("adminfunctions.jsp");
			rd.include(request, response);
			
		}
		else {
			out.print("<p style=\" color:red;\"> not success , Please try again </p>");
		RequestDispatcher rd=request.getRequestDispatcher("newseller.jsp");
		rd.include(request, response);
		}
		d.closeCon();
	}
	
}


