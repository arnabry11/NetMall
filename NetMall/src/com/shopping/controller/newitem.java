package com.shopping.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.beans.ItemBean;
import com.shopping.doau.mydoau;


/**
 * Servlet implementation class newitem
 */
@WebServlet("/newitem")
public class newitem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newitem() {
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
		
		String eseller_id=request.getParameter("sid");
		String ename=request.getParameter("name");
		String eprice=request.getParameter("price");
		String edetails=request.getParameter("details");
		String estock=request.getParameter("stock");
		
		ItemBean ib=new ItemBean();
		ib.setEseller_id(eseller_id);
		ib.setEname(ename);
		ib.setEprice(eprice);
		ib.setEdetails(edetails);
		ib.setEstock(estock);
		if(ib.getEname()!=null) {
		mydoau d=new mydoau();
		int result=d.insertItem(ib);
		
		if(result!=0)
		{
			out.println("<script>alert('Insert Success')</script>");
			RequestDispatcher rd=request.getRequestDispatcher("sellerprofile");
			rd.include(request, response);
			d.closeCon();
		}
		else {
			out.print("<p style=\" color:red;\"> not success , Please try again </p>");
		RequestDispatcher rd=request.getRequestDispatcher("sellerprofile");
		rd.include(request, response);
		d.closeCon();
		}
		
	}else {
			out.print("Login First!!!!!!");
			RequestDispatcher rd=request.getRequestDispatcher("logout");
			rd.include(request, response);
		}
		
	}

}
