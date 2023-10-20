package com.mrunmai.springbootmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "index.jsp";
    }

    @RequestMapping("add")
    public String add(@RequestParam("first")int i,@RequestParam("second")int j,HttpSession session){
        // Instead of using Request object use RequestParam annotation.
        // int i = Integer.parseInt(req.getParameter("first"));
        // int j = Integer.parseInt(req.getParameter("second"));
        
        int result = i+j;
        // HttpSession session = req.getSession();
        session.setAttribute("result", result);

        return "result.jsp";
    }
}
