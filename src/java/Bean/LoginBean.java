/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author TrungQuoc
 */
@Controller
public class LoginBean implements Serializable{

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRoles() {
        return roles;
    }

    public void setRoles(boolean roles) {
        this.roles = roles;
    }
  private String username;
  private String password;
  private boolean roles;
  public LoginBean(){
      
  }
  public LoginBean(String username,String password,boolean roles){
      this.username=username;
      this.password=password;
      this.roles=roles;
  }

  public boolean checkLogin(String username,String password){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ASM_DATABASE_PS05646";
            Connection con=DriverManager.getConnection(url,"sa","123");
            String sql="SELECT * FROM Users WHERE username=? and password=?";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs=stmt.executeQuery();
            boolean result=rs.next();
            rs.close();
            stmt.close();
            con.close();
            if(result){
                return true;
           
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
 
}

