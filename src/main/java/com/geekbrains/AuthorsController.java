package com.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAllAuthors(Model uiModel){
        Author author = new Author();
        author.setFirstName("Ivan");
        List<Author> authors = Collections.singletonList(author);
        uiModel.addAttribute("authors", authors);
        return "home";
    }
}