
package packages.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import packages.repositories.QuoteRepository;
import packages.repositories.StoryRepository;
import packages.tables.Quote;
import packages.tables.Story;

@Controller
public class UtilitiesController {
    
    @Autowired
    private StoryRepository storyRepo;
    
    @Autowired
    private QuoteRepository quoteRepo;
    
    @RequestMapping("/reset-repos")
    public String reset(){
        
        quoteRepo.deleteAll();
        storyRepo.deleteAll();
        
        Quote quote1 = new Quote("Quote text one", "Author", "love,hate");
        Quote quote2 = new Quote("Quote text two", "Author", "love,hate");
        
        quoteRepo.save(quote1);
        quoteRepo.save(quote2);
        
        Story story1 = new Story("Title One", "Description", "URL", "love,hate");
        Story story2 = new Story("Title Two", "Description", "URL", "love,hate");
        Story story3 = new Story("Title Three", "Description", "URL", "love,hate");
        
        storyRepo.save(story1);
        storyRepo.save(story2);
        storyRepo.save(story3);
        
        return "index";
    }
    
}
