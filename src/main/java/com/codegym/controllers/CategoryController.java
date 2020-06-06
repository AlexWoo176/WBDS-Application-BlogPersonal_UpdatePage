package com.codegym.controllers;

import com.codegym.model.Category;
import com.codegym.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public ModelAndView listCategory() {
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/category/create")
    public ModelAndView createCategory() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/category/create")
    public String addCategory(Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("success", "A Category was Created");
        return "redirect:/category";
    }

    @GetMapping("/category/view")
    public ModelAndView view(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("/category/view");
        modelAndView.addObject("category", categoryService.findById(id));
        return modelAndView;
    }

    @GetMapping("/category/edit")
    public ModelAndView edit(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", categoryService.findById(id));
        return modelAndView;
    }

    @PostMapping("/category/edit")
    public String update(Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("success", "A Category was Edited");
        return "redirect:/category";
    }

    @GetMapping("/category/delete")
    public ModelAndView delete(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("/category/delete");
        modelAndView.addObject("category", categoryService.findById(id));
        return modelAndView;
    }
    @PostMapping("/category/delete")
    public String remove(Category category, RedirectAttributes redirectAttributes){
        categoryService.remove(category.getId());
        redirectAttributes.addFlashAttribute("success", "A Category was Deleted");
        return "redirect:/category";
    }
}
