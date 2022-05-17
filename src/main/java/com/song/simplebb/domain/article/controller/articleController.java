package com.song.simplebb.domain.article.controller;

import com.song.simplebb.domain.article.article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class articleController {
    @GetMapping("/api/getArticle")
    article getArticle(@RequestParam("articleid") String aid) {
        return new article();
    }
}
