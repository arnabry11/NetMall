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

import com.shopping.beans.CartBean;
import com.shopping.beans.CartItemBean;
import com.shopping.beans.CustBean;
import com.shopping.beans.ItemBean;
import com.shopping.doau.mydoau;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
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
		String button=request.getParameter("button");
		if(button.equals("Add To Cart"))
		{
		 String strAction = request.getParameter("action");
		   
		   
		  if(strAction!=null && !strAction.equals("")) {
		   if(strAction.equals("add")) {
		    addToCart(request);
		    out.print("<script>alert('Item Added To Cart')</script>");
			  RequestDispatcher rd=request.getRequestDispatcher("custprofile");
			  rd.include(request, response);
		   } else if (strAction.equals("Update")) {
		    updateCart(request);
		    out.print("<script>alert('Item quantity changed')</script>");
			  RequestDispatcher rd=request.getRequestDispatcher("ShoppingCart.jsp");
			  rd.include(request, response);
		   } else if (strAction.equals("Delete")) {
		    deleteCart(request);
		    out.print("<script>alert('Item Deleted from Cart')</script>");
			  RequestDispatcher rd=request.getRequestDispatcher("ShoppingCart.jsp");
			  rd.include(request, response);
		   }
		  }
		}
		else {
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
	public void addToCart(HttpServletRequest request)
	{
		 CartBean cartBean = null;
		   HttpSession session=request.getSession();
		  Object objCartBean = session.getAttribute("cart");
		 
		  if(objCartBean!=null) {
		   cartBean = (CartBean) objCartBean ;
		  } else {
		   cartBean = new CartBean();
		   session.setAttribute("cart", cartBean);
		  }
		
		String item_id=request.getParameter("itemid");
		String equantity=request.getParameter("quantity");
		for(int i=0;i<cartBean.getLineItemCount();i++)
		{
			CartItemBean cib=cartBean.getCartItems(i);
			if(item_id.equals(cib.getEid()))
					{
						
						return;
					}
		}
		mydoau d=new mydoau();
		ResultSet rs=d.getItemAttributes(item_id);
		ItemBean ib=new  ItemBean();
		try {
			while(rs.next())
			{
				ib.setEid(item_id);
				ib.setEseller_id(rs.getString(1));
				ib.setEname(rs.getString(2));
				ib.setEprice(rs.getString(3));
				ib.setEdetails(rs.getString(4));
				ib.setEstock(rs.getString(5));
			}
			d.closeCon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			d.closeCon();
		}
		
		cartBean.addCartItem(ib,equantity);
	}
	
	 protected void updateCart(HttpServletRequest request) {
		  HttpSession session = request.getSession();
		  String equantity = request.getParameter("quantity");
		  String eindex = request.getParameter("index");
		  
		  CartBean cartBean = null;
		   
		  Object objCartBean = session.getAttribute("cart");
		  if(objCartBean!=null) {
		   cartBean = (CartBean) objCartBean ;
		  } else {
		   cartBean = new CartBean();
		  }
		  cartBean.updateCartItem(eindex,equantity);
		 }
		
	 
	 protected void deleteCart(HttpServletRequest request) {
		  HttpSession session = request.getSession();
		  String ItemIndex = request.getParameter("deleteindex");
		  CartBean cartBean = null;
		   
		  Object objCartBean = session.getAttribute("cart");
		  if(objCartBean!=null) {
		   cartBean = (CartBean) objCartBean ;
		  } else {
		   cartBean = new CartBean();
		  }
		  cartBean.deleteCartItem(ItemIndex);
		 }

}
