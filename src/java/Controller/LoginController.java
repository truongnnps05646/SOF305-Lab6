/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.LoginBean;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author zmido_000
 */
@Controller
public class LoginController {
    @RequestMapping("login_pa")
    public String savedata(HttpServletRequest request){
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        LoginBean login = new LoginBean();
        boolean result = login.checkLogin(username, password);
            
            if(result){
                return "index";
            }
        return "login";
       
    }
}
