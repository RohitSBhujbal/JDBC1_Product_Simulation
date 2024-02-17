package com.bank.JDBC_Bank_CRUD;

import java.sql.*;

public class ProductOperation {
    static Connection con;
    static Statement statement;

    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1ejm10","root","tiger");
            statement=con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertData(int id, String name, double price, int qty, String cat) {
     String query="insert into product values("+id+",'"+name+"'," +
             ""+price+","+qty+",'"+cat+"')";
        try {
           int count=statement.executeUpdate(query);
            System.out.println(count+" DATA INSERTED");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData(int id, double price) {
        String query="update product set p_price="+price+" where p_id="+id;
        try {
            int count=statement.executeUpdate(query);
            System.out.println(count+" DATA UPDATED");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
   
    public void displayData() {
        String query="select * from product";
        ResultSet rs;
        try {
            rs=statement.executeQuery(query);
            System.out.println("ID NAME PRICE QTY CATEGORY");
            while (rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getInt(4)+" "+rs.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

	public void delete(int id) {
		String query="DELETE FROM product WHERE p_id ="+id;
		try {
			int count=statement.executeUpdate(query);
			System.out.println(count+" Data Deleted Successfully...!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
