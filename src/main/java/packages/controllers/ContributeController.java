package packages.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import packages.repositories.StoryRepository;
import packages.repositories.QuoteRepository;
import packages.tables.Quote;
import packages.tables.Story;

@Controller
@RequestMapping(path="/contribute")
public class ContributeController {
    
    @Autowired
    private StoryRepository storyRepo;
    
    @Autowired
    private QuoteRepository quoteRepo;
    
    @RequestMapping("")
    public ModelAndView contribute() {
        //Define the model object.
        ModelAndView mav = new ModelAndView("contribute"); 
        
        Quote quote = new Quote();
        Story story = new Story();
            
        //Add these to the model view object.
        mav.addObject("submitQuote", quote);
        mav.addObject("submitStory", story);
        return mav;
    }
    
    @RequestMapping(value = "/add-quote", method = RequestMethod.PUT)
    public String addQuote(@ModelAttribute("submitQuote") Quote submittedQuote) {
        
        quoteRepo.save(submittedQuote);
        
        return "redirect:/contribute?successful";
    }
    
    @RequestMapping(value = "/add-story", method = RequestMethod.PUT)
    public String addStory(@ModelAttribute("submitStory") Story submittedStory) {
        
        storyRepo.save(submittedStory);
        
        return "redirect:/contribute?successful";
    }
    
    
}
