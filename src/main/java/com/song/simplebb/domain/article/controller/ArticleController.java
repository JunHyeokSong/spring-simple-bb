package com.song.simplebb.domain.article.controller;

import com.song.simplebb.domain.article.Article;
import com.song.simplebb.domain.user.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {
    @GetMapping("/api/getArticle")
    Article getArticle(@RequestParam("articleid") String aid) {
        UserDao u = UserDao.getUserDao();
        return new Article();

    }
}
