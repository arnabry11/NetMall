package com.shopping.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.beans.SellerBean;
import com.shopping.doau.mydoau;

/**
 * Servlet implementation class updateseller
 */
@WebServlet("/updateseller")
public class updateseller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateseller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
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
		String eid=request.getParameter("id");
		
		SellerBean sb=new SellerBean();
		sb.setEaddress(eaddress);
		sb.setEcity(ecity);
		sb.setEcontact(econtact);
		sb.setEemail(eemail);
		sb.setEname(ename);
		sb.setEpin(epin);
		sb.setEstate(estate);
		sb.setEid(eid);
		
		mydoau d=new mydoau();
		int result=d.update(sb);
		d.closeCon();
		if(result!=0) {
			out.println("<p style=\" color:green;\"><b>Seller Details Updated Successfully</b> </p>");
			RequestDispatcher rd=request.getRequestDispatcher("adminfunctions.jsp");
			rd.include(request, response);
		}
		else {
			out.println("<p style=\" color:red;\"><u>Seller Details Updation Failed. Please try again</u></p>");
			RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
		rd.include(request, response);
	
		}
	}
}
