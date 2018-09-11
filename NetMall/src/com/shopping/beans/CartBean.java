// This is my second commit.
package com.shopping.beans;

import java.util.ArrayList;

public class CartBean {
	
	ArrayList<CartItemBean> allcartitems=new ArrayList<CartItemBean>();
	double cartsum=0;
	
	
	public void addCartItem(ItemBean ib,String equantity) {
		
		CartItemBean cib=new CartItemBean();
		int qua=Integer.parseInt(equantity);
		int stock=Integer.parseInt(ib.getEstock());
		if(qua<=stock) {
		
		 cib.setEdetails(ib.getEdetails());
		 cib.setEid(ib.getEid());
		 cib.setEname(ib.getEname());
		 cib.setEprice(ib.getEprice());
		 cib.setEquantity(qua);
		 cib.setEsellerid(ib.getEseller_id());
		 cib.setEstock(stock);
		 double tcost=qua*(Integer.parseInt(ib.getEprice()));
		 cib.setTotalcost(tcost);
		 allcartitems.add(cib);
		 cartTotal();
		}
	}
	
	public void updateCartItem(String index, String quantity)
	{
		int eindex=Integer.parseInt(index);
		int qua=Integer.parseInt(quantity);
		CartItemBean cib=null;
		cib=allcartitems.get(eindex);
		int stock=cib.getEstock();
		if(qua <= stock)
		{
			double tcost=qua*(Integer.parseInt(cib.getEprice()));
			cib.setEquantity(qua);
			cib.setTotalcost(tcost);
			cartTotal();
		}
		
	}
	
	public void deleteCartItem(String index)
	{
		int eindex=Integer.parseInt(index);
		allcartitems.remove(eindex);
		cartTotal();
	}
	
	
	
	public double getCartsum() {
		return cartsum;
	}

	public void setCartsum(double cartsum) {
		this.cartsum = cartsum;
	}

	public void cartTotal() {
		double csum=0;
		for(int i=0;i<allcartitems.size();i++)
		{
			CartItemBean cib=allcartitems.get(i);
			csum+=cib.getTotalcost();
		}
		setCartsum(csum);
	} 
	
	 public int getLineItemCount() {
		  return allcartitems.size();
		 }
	 public CartItemBean getCartItems(int index) 
		{
			CartItemBean cib=allcartitems.get(index);
			return cib;
		}
	 
	 
	
//	public void editcartitem(int index,int qua)
//	{
//		allcartitems.get(index).setEquantity(qua);
//	}
//	
//	public void addToList(CartItemBean cib) {
//			
//		allcartitems.add(cib);
//	}

//	
//	public  int checkItemPresent(String item_id) {
//		
//		int c=-1;
//		
//		for(int i=0;i<allcartitems.size();i++)
//		{
//			CartItemBean cib=allcartitems.get(i);
//			if(cib.getEid().equals(item_id))
//				c=1;
//		}
//		
//		return c;
//		
//	}

}
