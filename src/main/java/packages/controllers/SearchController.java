package packages.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import packages.repositories.StoryRepository;
import packages.repositories.QuoteRepository;
import packages.tables.Quote;
import packages.tables.Story;

@Controller
public class SearchController {
    
    @Autowired
    private StoryRepository storyRepo;
    
    @Autowired
    private QuoteRepository quoteRepo;
    
    @RequestMapping(value = "search", method = RequestMethod.PUT)
    public String search(@RequestParam("query") String searchQuery) {
        
        
        
        return "search";
    }
    
    
    
}
