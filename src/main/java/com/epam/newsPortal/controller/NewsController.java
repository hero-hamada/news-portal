package com.epam.newsPortal.controller;

import com.epam.newsPortal.dto.NewsDTO;
import com.epam.newsPortal.service.NewsService;
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

/**
 * Controller for {@link com.epam.newsPortal.model.News}'s pages.
 *
 * @author Merey Zhanakhmetova
 * @version 1.0
 */

@Controller
@RequestMapping("/news")
public class NewsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class.getName());

    @Autowired
    private NewsService newsService;

    /**
     * Adds List of {@link com.epam.newsPortal.dto.NewsDTO} objects as newsList attribute to the Model,
     * Redirects to main page with all news
     * @param model {@link org.springframework.ui.Model} object
     * @return main page "news/index"
     * @see NewsService#getAll()
     */
    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("newsList", newsService.getAll());
        return "news/index";
    }

    /**
     * Adds news attribute to the Model then redirects to the page of one news
     * @param id primary key of {@link com.epam.newsPortal.dto.NewsDTO}
     * @param model {@link org.springframework.ui.Model} object
     * @return main page "news/index"
     * @see NewsService#getById(Long)
     */
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("news", newsService.getById(id));
        return "news/view";
    }

    /**
     * Redirects to the add new news page
     * @param newsDTO {@link com.epam.newsPortal.dto.NewsDTO} object
     * @return "news/add" page to add news
     */
    @GetMapping("/add")
    public String addNews(@ModelAttribute("news") NewsDTO newsDTO) {
        return "news/add";
    }

    /**
     * Creates new news with given {@link com.epam.newsPortal.dto.NewsDTO} object
     * @param newsDTO {@link com.epam.newsPortal.dto.NewsDTO} object from the form
     * @param bindingResult to validate data received from the form
     * @return redirects to the main page, if bindingResult has errors redirects to the news/add page
     */
    @PostMapping()
    public String create(@ModelAttribute("person") @Valid NewsDTO newsDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "news/add";
        }
        newsService.save(newsDTO);
        return "redirect:/news";
    }

    /**
     * Gets by id {@link com.epam.newsPortal.dto.NewsDTO} object and adds to model to edit
     * @param model {@link org.springframework.ui.Model} object
     * @param id id of {@link com.epam.newsPortal.dto.NewsDTO} object to edit
     * @return redirects to the edit news page
     */
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("news", newsService.getById(id));
        return "news/edit";
    }

    /**
     * Receives {@link com.epam.newsPortal.dto.NewsDTO} object from the form
     * and calls {@link com.epam.newsPortal.service.NewsService}'s {@code update(newsDTO)} to update
     * @param newsDTO {@link com.epam.newsPortal.dto.NewsDTO} object from the form
     * @param bindingResult to validate received data from the form
     * @param request {@link HttpServletRequest} to get request header
     * @return redirects to the view page of edited news
     * @see NewsService#update(NewsDTO)
     */
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("news") @Valid NewsDTO newsDTO, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "news/edit";
        }
        newsService.update(newsDTO);

        return "redirect:" + request.getHeader("referer").replace("/edit","");
    }

    /**
     * Deletes List of news by their ids
     * @param newsIds List of {@link com.epam.newsPortal.dto.NewsDTO} ids from the form to delete
     * @return main page "news/index"
     * @see NewsService#delete(Long)
     */
    @DeleteMapping("/delete")
    public String deleteByIds(@RequestParam("id") List<String> newsIds) {
        List<Long> newsIdsToDelete = newsIds.stream().map(Long::parseLong).collect(Collectors.toList());
        newsIdsToDelete.forEach((id) -> newsService.delete(id));
        return "redirect:/news";
    }

    /**
     * Deletes one news by id
     * @param id {@link com.epam.newsPortal.dto.NewsDTO} id from the form to delete
     * @return main page "news/index"
     * @see NewsService#delete(Long)
     */
    @DeleteMapping("/{id}/delete")
    public String deleteById(@PathVariable("id") Long id) {
        newsService.delete(id);
        return "redirect:/news";
    }
}