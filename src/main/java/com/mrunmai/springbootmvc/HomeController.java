package com.mrunmai.springbootmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mrunmai.springbootmvc.model.Alien;

@Controller
public class HomeController {

    // this will get called before any request and will create a model and adds the
    // attribute to model
    @ModelAttribute
    public void ModelData(Model m) {
        m.addAttribute("name", "Aliens");
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("add")
    public String add(@RequestParam("first") int i, @RequestParam("second") int j, Model m) {
        // Instead of using Request object use RequestParam annotation.
        // int i = Integer.parseInt(req.getParameter("first"));
        // int j = Integer.parseInt(req.getParameter("second"));

        // ModelAndView mv = new ModelAndView("result");
        // mv.setViewName("result");
        int result = i + j;
        m.addAttribute("result", result);

        // HttpSession session = req.getSession();
        // session.setAttribute("result", result);

        return "result";
    }

    //Way 1 @RequestMapping(value="addAlien",method=RequestMethod.POST)
    //Way 2
    @PostMapping(value = "addAlien")
    public String addAlien(
            /* @RequestParam("aid") int aid, @RequestParam("aname") String aname, Model m */ @ModelAttribute("a1") Alien a) {
        /*
         * Alien a = new Alien();
         * a.setAid(aid);
         * a.setAname(aname);
         * 
         * m.addAttribute("alien", a);
         */
        return "result";
    }
    // instead of writing this all commented section just create modelattri and it
    // will assign the values automatically.
}

/*
 * index.jsp and result.jsp are added to views folder because everyone can
 * access them if they are only in webapp folder. so we added application
 * properties to tell the app that files are in views folder so added prefix. As
 * for the suffix we told the application that suffix is .jsp
 */

// Instead of Model you can also use ModelMap object. This is used if you only
// want to store the data in Model.