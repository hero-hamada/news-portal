package com.epam.newsPortal.controller;

import com.epam.newsPortal.dto.NewsDTO;
import com.epam.newsPortal.model.News;
import com.epam.newsPortal.service.NewsService;
import org.hibernate.SessionFactory;
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
import java.util.stream.Collectors;

@Controller
@RequestMapping("/news")
public class NewsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class.getName());

    @Autowired
    private NewsService newsService;
    @Autowired
    private SessionFactory sessionFactory;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("newsList", newsService.getAll());
        return "news/index";
    }

    @GetMapping("/{id}")

    public String getById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("news", newsService.getById(id));
        return "news/view";
    }

    @GetMapping("/add")
    public String addNews(@ModelAttribute("news") News news) {
        return "news/add";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid NewsDTO newsDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "news/add";
        }
        newsService.save(newsDTO);
        return "redirect:/news";
    }

     @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("news", newsService.getById(id));
        return "news/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("news") @Valid NewsDTO newsDTO, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "news/edit";
        }
        newsService.update(newsDTO);

        return "redirect:" + request.getHeader("referer").replace("/edit","");
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") List<String> newsIds) {
        List<Long> newsIdsToDelete = newsIds.stream().map(Long::parseLong).collect(Collectors.toList());
        newsIdsToDelete.forEach((id) -> newsService.delete(id));
        return "redirect:/news";
    }

    @DeleteMapping("/{id}/delete")
    public String edit(@PathVariable("id") Long id) {
        newsService.delete(id);
        return "redirect:/news";
    }
}