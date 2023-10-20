package com.mrunmai.springbootmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "index.jsp";
    }

    @RequestMapping("add")
    public String add(HttpServletRequest req){
        int i = Integer.parseInt(req.getParameter("first"));
        int j = Integer.parseInt(req.getParameter("second"));
        
        int result = i+j;
        HttpSession session = req.getSession();
        session.setAttribute("result", result);

        return "result.jsp";
    }
}
