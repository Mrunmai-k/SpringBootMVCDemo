package com.mrunmai.springbootmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "index.jsp";
    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("first") int i, @RequestParam("second") int j) {
        // Instead of using Request object use RequestParam annotation.
        // int i = Integer.parseInt(req.getParameter("first"));
        // int j = Integer.parseInt(req.getParameter("second"));

        ModelAndView mv = new ModelAndView();
        mv.setViewName("result.jsp");
        int result = i + j;
        mv.addObject("result", result);

        // HttpSession session = req.getSession();
        // session.setAttribute("result", result);

        return mv;
    }
}
