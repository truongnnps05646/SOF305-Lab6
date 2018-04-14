/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author zmido_000
 */
@Controller
public class PagingController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    
    @RequestMapping("pages/charts/chartjs")
    public String chart(){
        return "pages/charts/chartjs";
    }
    
    @RequestMapping("pages/forms/basic_elements")
    public String form(){
        return "pages/forms/basic_elements";
    }
    
    @RequestMapping("pages/tables/basic-table")
    public String table(){
        return "pages/tables/basic-table";
    }
}
