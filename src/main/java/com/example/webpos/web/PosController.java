package com.example.webpos.web;

import com.example.webpos.biz.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PosController {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @GetMapping("/")
    public String pos(Model model) {
        //posService.add("PD2",1);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("total",posService.total(posService.getCart()));
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        posService.deleteItem(id);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("total",posService.total(posService.getCart()));
        return "index";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") String id, Model model){
        //System.out.println(id);
        posService.add(id, 1);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("total",posService.total(posService.getCart()));
        return "index";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") String id, Model model){
        posService.removeProduct(id);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("total",posService.total(posService.getCart()));
        return "index";
    }

    @GetMapping("/empty")
    public String empty(Model model){
        posService.newCart();
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("total",posService.total(posService.getCart()));
        return "index";
    }

    @GetMapping("/charge")
    public String charge(Model model){

        return "charge";
    }

}
