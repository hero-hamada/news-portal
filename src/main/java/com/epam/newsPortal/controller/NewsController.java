package com.epam.newsPortal.controller;

import com.epam.newsPortal.dao.NewsDAO;
import com.epam.newsPortal.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class.getName());

    private NewsDAO newsDAO;

    @Autowired
    public NewsController(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("newsList", newsDAO.list());
        return "news/index";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("news", newsDAO.get(id));
        return "news/view";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("person", personDAO.show(id));
//        return "people/show";
//    }

//    @GetMapping("/new")
//    public String newPerson(@ModelAttribute("person") Person person) {
//        return "people/new";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "people/new";
//        }
//        personDAO.save(person);
//        return "redirect:/people";
//    }
//
    @ResponseBody
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("news", newsDAO.get(id));
        return "news/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("news") @Valid News news, BindingResult bindingResult,
                         @PathVariable("id") Long id, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "news/edit";
        }

        newsDAO.saveOrUpdate(id, news);
        return "redirect:" + request.getHeader("referer");
    }

    @DeleteMapping("/delete")
    public String delete(@ModelAttribute("newsIds") @Valid List<Long> newsIds) {
        newsDAO.delete(newsIds);
        return "redirect:/news";
    }
}