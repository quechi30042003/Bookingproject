package com.group3.demoDuLich.controllers;

import com.group3.demoDuLich.models.User;
import com.group3.demoDuLich.models.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {
    @GetMapping
    public String showHomePage(){
        return "index";
    }

    @GetMapping("vechungtoi")
    public String showVeChungToi(){
        return "vechungtoi";
    }

    @GetMapping("success")
    public String showSuccessForm(){
        return "success";
    }
    @GetMapping("hoian")
    public String showHoiAn(){
        return "hoian";
    }
    @GetMapping("hochiminh")
    public String showHoChiMinh(){
        return "hochiminh";
        }
    @GetMapping("guidebook")
    public String showGuideForm(){
        return "guidebook";
    }
    @GetMapping("foodtour")
    public String showFoodtourForm(){
        return "foodtour";
    }
    @GetMapping("foodreview")
    public String showFoodReviewForm(){
        return "foodreview1";
    }
    @GetMapping("danang")
    public String showDaNang(){
        return "danang";
    }
    @GetMapping("dalat")
    public String showDaLat(){
        return "dalat";
    }
    @GetMapping("dichvu")
    public String showDichVuForm(){
        return "dichvu";
    }
    //---------------------------------------------------------------------//
    @GetMapping("home")
    public String addOrEdit(ModelMap model) {
        User u = new User();
//		u.setUsername("Minh Minh");
        model.addAttribute("USER",u);
        model.addAttribute("ACTION","saveOrUpdate");
        return "booking-users";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(ModelMap model, @ModelAttribute("USER") User user) {
        UserDAO dao = new UserDAO();
        dao.save(user);
        System.out.println("size:"+dao.getAll().size());
        return "booking-users";
    }

    @RequestMapping("list")
    public String list(ModelMap model) {
        UserDAO dao = new UserDAO();
        model.addAttribute("USERS",dao.getAll());
        return "view-user";
    }

    @RequestMapping("/edit/{username}")
    public String edit(ModelMap model,
                       @PathVariable(name="username") String username) {
        UserDAO dao = new UserDAO();
        User u = dao.findByUsername(username);
        model.addAttribute("USER",u);
        model.addAttribute("ACTION","/saveOrUpdate");
        return "booking-users";
    }
    @RequestMapping("/delete/{username}")
    public String delete(ModelMap model,
                         @PathVariable(name="username") String username) {
        UserDAO dao = new UserDAO();
        dao.delete(username);
        model.addAttribute("USERS",dao.getAll());
        return "view-user";
    }
//-------------------------------------------------//
    @RequestMapping("login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("register")
    public String showRegisterForm(){
        return "register";
    }
    @GetMapping("logout")
    public String showLogoutForm(){
        return "logout";
    }
}
