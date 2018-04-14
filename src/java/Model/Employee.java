/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bean.Employees;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zmido_000
 */
public class Employee {
     public static List<Employees> showEmployee(String tennv){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ASM_DATABASE_PS05646";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "select * from Staffs";
            if(tennv.length() > 0){
                sql += " where Name like '%"+tennv+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Employees> list = new ArrayList<Employees>();
            while(rs.next()){
                int masv = rs.getInt("Id");
                String name = rs.getString("Name");
                Boolean gender = rs.getBoolean("Gender");
                if(gender.equals(true)){
                    gender.toString().concat("Nam");
                }
                Date birthday = rs.getDate("Birthday");
                String email = rs.getString("Email");
                String major = rs.getString("Phone");
                int salary = rs.getInt("Salary");
                Employees sp = new Employees(masv, name, gender, birthday, email, name, salary);
                list.add(sp);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
     
     public static void delete(int id){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ASM_DATABASE_PS05646";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "delete from Staffs where Id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
