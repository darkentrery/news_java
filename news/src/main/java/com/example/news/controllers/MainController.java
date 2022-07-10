package com.example.news.controllers;


import com.example.news.models.Post;
import com.example.news.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String main(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);

        return "main";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "create";
    }

    @PostMapping ("/create")
    public String createArticle(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);
        return "redirect:/";
    }

}