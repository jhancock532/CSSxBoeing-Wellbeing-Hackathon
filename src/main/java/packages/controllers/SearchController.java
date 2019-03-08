package packages.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



import packages.repositories.StoryRepository;
import packages.repositories.QuoteRepository;
import packages.tables.Quote;
import packages.tables.Story;

import packages.model.QuoteStory;
import packages.model.Query;

@Controller
@RequestMapping(path="/search")
public class SearchController {
    
    @Autowired
    private StoryRepository storyRepo;
    
    @Autowired
    private QuoteRepository quoteRepo;
    
    @RequestMapping("")
    public ModelAndView search(@RequestParam("query") String query) {
        //Define the model object.
        ModelAndView mav = new ModelAndView("search"); 
        
        //Based on query get a list of quotes and stories for the user.
        List<QuoteStory> quotesAndStories = combineQuotesAndStories(getQuotes(query), getStories(query));
        
        Query searchQuery;
        //Create a query object for the Query string
        if (quotesAndStories.size() > 0){
            searchQuery = new Query(query, true); //Results have been found.
        } else {
            searchQuery = new Query(query, false); //No results have been found.
        }
            
        //Add these to the model view object.
        mav.addObject("QuoteStories", quotesAndStories);
        mav.addObject("searchQuery", searchQuery);
        return mav;
    }
    
    private List<QuoteStory> combineQuotesAndStories(List<Quote> quotes, List<Story> stories){
        List<QuoteStory> combinedQuoteStories = new ArrayList<QuoteStory>();
        
        if (stories.size() > 0){
            Story storyOne = stories.get(0);
            combinedQuoteStories.add(new QuoteStory(storyOne));
        }
        
        if (quotes.size() > 0){
            Quote quoteOne = quotes.get(0);
            combinedQuoteStories.add(new QuoteStory(quoteOne));
        }
        
        if (stories.size() > 1){
            Story storyTwo = stories.get(1);
            combinedQuoteStories.add(new QuoteStory(storyTwo));
        }
        
        if (quotes.size() > 1){
            Quote quoteTwo = quotes.get(1);
            combinedQuoteStories.add(new QuoteStory(quoteTwo));
        }

        if (stories.size() > 2){
            Story storyThree = stories.get(2);
            combinedQuoteStories.add(new QuoteStory(storyThree));
        }
        
        return combinedQuoteStories;
    }
    
    private List<Story> getStories(String query){
        List<Story> relevantStories = new ArrayList<Story>();
        Iterable<Story> allQuotes = storyRepo.findAll();
        
        for (Story story: allQuotes){
            relevantStories.add(story);
        }
        
        return relevantStories;
    }
    
    private List<Quote> getQuotes(String query){
        List<Quote> relevantQuotes = new ArrayList<Quote>();
        Iterable<Quote> allQuotes = quoteRepo.findAll();
        
        for (Quote quote: allQuotes){
            relevantQuotes.add(quote);
        }
        
        return relevantQuotes;
    }
}
