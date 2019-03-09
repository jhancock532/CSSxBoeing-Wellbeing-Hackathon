package packages.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

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
        
        List<String> relatedTags = getRelatedTagsFromSearchResults(quotesAndStories);
        
        Query searchQuery;
        //Create a query object for the Query string
        if (quotesAndStories.size() > 0){
            searchQuery = new Query(query, true, relatedTags); //Results have been found.
        } else {
            searchQuery = new Query(query, false, relatedTags); //No results have been found.
        }
            
        //Add these to the model view object.
        mav.addObject("QuoteStories", quotesAndStories);
        mav.addObject("searchQuery", searchQuery);
        return mav;
    }
    
    private List<String> getRelatedTagsFromSearchResults(List<QuoteStory> results){
        Map<String, Integer> potentialTags = new HashMap<String, Integer>();
        List<String> relatedTags = new ArrayList<String>();
        List<String> tags = new ArrayList<String>();
        
        for (QuoteStory qs : results){
            if (qs.type == "quote"){
                tags = qs.quote.getTagsList();
            }

            if (qs.type == "story"){
                tags = qs.story.getTagsList();
            }
                         
            for (Integer i = 0; i < tags.size(); i++){
                String tag = tags.get(i);
                if (potentialTags.containsKey(tag)){
                    Integer count = potentialTags.get(tag);
                    count += 1;
                    potentialTags.put(tag, count);
                } else {
                    potentialTags.put(tag, 1);
                }
            }
        }
        
        Map<String, Integer> sortedTags = potentialTags
            .entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(
                toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new)
            );
        
        relatedTags = new ArrayList<String>(sortedTags.keySet());
        
        if (relatedTags.size() > 15){
            relatedTags = relatedTags.stream().limit(15).collect(Collectors.toList());
        }
        
        return relatedTags;
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
        Iterable<Story> allStories = storyRepo.findAll();
        
        for (Story story: allStories){
            List<String> tags = story.getTagsList();
            
            if (tags.contains(query)){
                relevantStories.add(story);
            }
        }
        
        return relevantStories;
    }
    
    private List<Quote> getQuotes(String query){
        List<Quote> relevantQuotes = new ArrayList<Quote>();
        Iterable<Quote> allQuotes = quoteRepo.findAll();
        
        for (Quote quote: allQuotes){
            List<String> tags = quote.getTagsList();
            
            if (tags.contains(query)){
                relevantQuotes.add(quote);
            }
        }
        
        return relevantQuotes;
    }
}
