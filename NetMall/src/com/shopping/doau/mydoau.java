package com.shopping.doau;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.beans.CustBean;
import com.shopping.beans.ItemBean;
import com.shopping.beans.SellerBean;
import com.shopping.connection.myconnect;


		

public class mydoau {
				
	//private static int itemid=110;
	
			Connection con=myconnect.dbcon();
			PreparedStatement ps=null;
			int result;
			ResultSet rs=null;
			
			
			public int checkCustEmail(String email) {
				int chk=0;
				
				String sql="select * from custinfo where email=?";
				try {
					ps=con.prepareStatement(sql);
		
					ps.setString(1,email);
					rs=ps.executeQuery();
					if(rs.next())
						chk=1;
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return chk;
				
			}
			
			
			public int insertCust(CustBean b) {
				
				String sql="insert into custinfo(name,address,email,contact,dob,gender,state,city,password) values(?,?,?,?,?,?,?,?,?)";
				try {
					ps=con.prepareStatement(sql);
					ps.setString(1,b.getEname());
					ps.setString(2,b.getEaddress());
					ps.setString(3,b.getEemail());
					ps.setString(4,b.getEcontact());
					ps.setString(5,b.getEdob());
					ps.setString(6,b.getEgender());
					ps.setString(7,b.getEstate());
					ps.setString(8,b.getEcity());
					ps.setString(9,b.getEpassword());
					result=ps.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return result;
				
				
			}
			
			
			
			
			public int insert(SellerBean b)
			{
				String sql="insert into sellerinfo(name,contact,email,address,city,state,pin)values(?,?,?,?,?,?,?)";
				try {
					ps=con.prepareStatement(sql);
					ps.setString(1, b.getEname());
					ps.setString(2,b.getEaddress());
					ps.setString(3,b.getEemail());
					ps.setString(4,b.getEcontact());
				
					ps.setString(5,b.getEcity());
					ps.setString(6,b.getEstate());
					ps.setString(7,b.getEpin());
					
					result=ps.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return result;
				
			}
			
			public int insertItem(ItemBean b)
			{
				String sql="insert into iteminfo(seller_id,name,price,details,stock)values(?,?,?,?,?)";
				
				
				try {
					ps=con.prepareStatement(sql);
					
					ps.setString(1, b.getEseller_id());
					ps.setString(2, b.getEname());
					ps.setString(3,b.getEprice());
					ps.setString(4,b.getEdetails());
					ps.setString(5,b.getEstock());
				
					
					
					result=ps.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//if(result!=0)
					//itemid++;
					
				return result;
				
			}
			
			public ResultSet getSellerId(String email) {
				
				String sql="select id,password from sellerinfo where email=?";
				try {
					ps=con.prepareStatement(sql);
					ps.setString(1,email);
					rs=ps.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
				
			}
			

			
			public int update(SellerBean sb)
			{
				String sql="update sellerinfo set name=?,address=?,email=?,contact=?,state=?,city=?,pin=? where id=?";
				
				try {
					ps = con.prepareStatement(sql);
					ps.setString(2,sb.getEaddress());
					ps.setString(3,sb.getEemail());
					ps.setString(4,sb.getEcontact());
					ps.setString(7,sb.getEpin());
				
					ps.setString(5,sb.getEstate());
					ps.setString(6,sb.getEcity());
				
					ps.setString(1, sb.getEname());
					ps.setString(8, sb.getEid());
					result=ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return result;
			}
			
			public int updateItem(ItemBean sb)
			{
				String sql="update iteminfo set name=?,price=?,details=?,stock=? where id=? and seller_id=?";
				
				try {
					ps = con.prepareStatement(sql);
					ps.setString(1,sb.getEname());
					ps.setString(2,sb.getEprice());
					ps.setString(3,sb.getEdetails());
					ps.setString(4,sb.getEstock());
				
					ps.setString(5,sb.getEid());
					ps.setString(6,sb.getEseller_id());
				
					
					result=ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return result;
			}
			
			
			public int updateCust(CustBean sb)
			{
				String sql="update custinfo set name=?,address=?,contact=?,dob=?,gender=?,state=?,city=?,password=? where email=?";
				
				try {
					ps = con.prepareStatement(sql);
					ps.setString(1,sb.getEname());
					ps.setString(2,sb.getEaddress());
					ps.setString(3,sb.getEcontact());
					ps.setString(4,sb.getEdob());
				
					ps.setString(5,sb.getEgender());
					ps.setString(6,sb.getEstate());
					ps.setString(7,sb.getEcity());
					ps.setString(8,sb.getEpassword());
					ps.setString(9,sb.getEemail());
					
					result=ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return result;
			}
			
			
			public int delete(String eid) {
				
				String sql="delete from sellerinfo where id=?";
				try {
					ps=con.prepareStatement(sql);
					ps.setString(1, eid);
					result=ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return result;
			}
			
public int deleteItem(String eid,String seid) {
				
				String sql="delete from iteminfo where id=? and seller_id=?";
				try {
					ps=con.prepareStatement(sql);
					ps.setString(1, eid);
					ps.setString(2, seid);
					result=ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				}
				return result;
			}
			
			
			public ResultSet view(SellerBean sb)
			{
				String sql="select name,contact,email,address,city,state,pin from sellerinfo where id=?";
				try {
					ps=con.prepareStatement(sql);
					ps.setString(1, sb.getEid());
					rs=ps.executeQuery();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
				
			}
			
			
			public ResultSet viewCust(CustBean sb)
			{
				String sql="select id,name,address,contact,dob,gender,state,city from custinfo where email=?";
				try {
					ps=con.prepareStatement(sql);
					ps.setString(1, sb.getEemail());
					rs=ps.executeQuery();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
				
			}
			
			
			public ResultSet viewItem(ItemBean sb)
			{
				String sql="select name,price,details,stock from iteminfo where id=? and seller_id=?";
				try {
					ps=con.prepareStatement(sql);
		
					ps.setString(1, sb.getEid());
					ps.setString(2, sb.getEseller_id());
					rs=ps.executeQuery();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
				
			}
			
			public ResultSet getItemAttributes(String item_id)
			{
				String sql="select seller_id,name,price,details,stock from iteminfo where id=?";
				try {
					ps=con.prepareStatement(sql);
		
					ps.setString(1,item_id);
				
					rs=ps.executeQuery();
					
					
		          
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
				
			}
			
			
			
			
			
			public ResultSet viewAllItem(ItemBean sb)
			{
				String sql="select id,name from iteminfo where  seller_id=?";
				try {
					ps=con.prepareStatement(sql);
		
					//ps.setString(1, sb.getEid());
					ps.setString(1, sb.getEseller_id());
					rs=ps.executeQuery();
					
					 					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
				
			}
			
			
			
			public ResultSet login(SellerBean b) {
				
				String sql="select name from sellerinfo where id=? and password=?";
				try {
					ps=con.prepareStatement(sql);
					ps.setString(1, b.getEid());
					ps.setString(2, b.getEpassword());
					rs=ps.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
				
			}
			
public ResultSet loginCust(CustBean b) {
				
				String sql="select id,name from custinfo where email=? and password=?";
				try {
					ps=con.prepareStatement(sql);
					ps.setString(1, b.getEemail());
					ps.setString(2, b.getEpassword());
					rs=ps.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
				
			}

public ResultSet retrieveAllItems() {
	
	String sql="select seller_id,id,name,price,details,stock from iteminfo";
	try {
		ps=con.prepareStatement(sql);
		rs=ps.executeQuery();
		
		  
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return rs;
}



public int updateStock(String itemid,int stock)
{
	String sql="update iteminfo set stock=? where id=?";
	String st=Integer.toString(stock);
	try {
		ps=con.prepareStatement(sql);
		ps.setString(1,st );
		ps.setString(2, itemid);
		result=ps.executeUpdate();
		
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
}

public void closeCon() {
	
	try {
		con.close();
		rs.close();
		System.out.println("Connection Closed");
		System.out.println();
		System.out.println("-----------------");
		System.out.println();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
			
			
}



