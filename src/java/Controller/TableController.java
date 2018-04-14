/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.Employees;
import Model.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author zmido_000
 */
@Controller
@RequestMapping("/pages/")
public class TableController {
    
    @RequestMapping("tables/basic-table")
    public String showAll(ModelMap model) {
        Employee st = new Employee();
        List<Employees> list = new ArrayList<>();
        list = st.showEmployee("");
        model.addAttribute("listEmployee", list);

        Employees sv = new Employees();
        sv = list.get(0);
        model.addAttribute("student", sv);
        return "pages/tables/basic-table";
    }
    
    @RequestMapping("tables/basic-table/delete")
    public String delete(HttpServletRequest request, ModelMap model,
            @ModelAttribute("student") Employees employee) {
        int id = Integer.parseInt(request.getParameter("txtId"));
        Employee.delete(id);

        List<Employees> list = new ArrayList<>();
        list = Employee.showEmployee("");
        model.addAttribute("listEmployee", list);
        return "pages/tables/basic-table";
    }
}
