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
 * Servlet implementation class updateitem
 */
@WebServlet("/updateitem")
public class updateitem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateitem() {
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
		
		String eseller_id=request.getParameter("sid");
		String ename=request.getParameter("name");
		String eprice=request.getParameter("price");
		String edetails=request.getParameter("details");
		String estock=request.getParameter("stock");
		String eid=request.getParameter("id");
		
		ItemBean ib=new ItemBean();
		ib.setEseller_id(eseller_id);
		ib.setEname(ename);
		ib.setEprice(eprice);
		ib.setEdetails(edetails);
		ib.setEstock(estock);
		ib.setEid(eid);
//	if(ib.getEname()!=null) {
		mydoau d=new mydoau();
		int result=d.updateItem(ib);
		d.closeCon();
		if(result!=0)
		{
			out.println("Update Success");
			RequestDispatcher rd=request.getRequestDispatcher("sellerprofile");
			rd.include(request, response);
		}
		else {
			out.print("<p style=\" color:red;\"> not success,Invalid item id , Please try again </p>");
		RequestDispatcher rd=request.getRequestDispatcher("sellerprofile");
		rd.include(request, response);
		}
	//	}else {
//			out.print("Login First!!!!!!");
//			RequestDispatcher rd=request.getRequestDispatcher("logout");
//			rd.include(request, response);
//		}
		
		
		
	}

}
