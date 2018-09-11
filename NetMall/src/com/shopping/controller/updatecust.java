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
import com.shopping.doau.*;

/**
 * Servlet implementation class updatecust
 */
@WebServlet("/updatecust")
public class updatecust extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecust() {
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
		String eaddress=request.getParameter("address");
		String eemail=request.getParameter("email");
		String econtact=request.getParameter("contact");
		String edob=request.getParameter("dob");
		String egender=request.getParameter("gender");
		String estate=request.getParameter("state");
		String ecity=request.getParameter("city");
		String epassword=request.getParameter("password");
		
		CustBean b=new CustBean();
		b.setEname(ename);
		b.setEaddress(eaddress);
		b.setEcontact(econtact);
		b.setEemail(eemail);
		b.setEgender(egender);
		b.setEcity(ecity);
		b.setEstate(estate);
		b.setEpassword(epassword);
		b.setEdob(edob);
		HttpSession session=request.getSession();
		session.setAttribute("activesess", b);
		mydoau d=new mydoau();
		d.closeCon();
		int result=d.updateCust(b);
	    if(result!=0) {
	    	out.println("<p align=\"center\" style=\" font-size: x-large;font-family: cursive;font-style: oblique; color: green;\">UPDATE success</p>");
	    RequestDispatcher rd=request.getRequestDispatcher("custprofile");
	    rd.include(request, response);
	    
	    }else {
	    	out.println("<p style=\" font-size: x-large;font-family: cursive;font-style: oblique; color: red;\">not success</p>");
	    	 RequestDispatcher rd=request.getRequestDispatcher("updatecust.jsp");
	 	    rd.include(request, response);
	    }
		
	}

}
