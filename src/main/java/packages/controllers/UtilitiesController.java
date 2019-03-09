
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
        
        Quote quote1 = new Quote("Love yourself. It is important to stay positive because beauty comes from the inside out.", "Jenn Proske", "love, self-love, positive");
        Quote quote2 = new Quote("Love myself I do. Not everything, but I love the good as well as the bad. I love my crazy lifestyle, and I love my hard discipline. I love my freedom of speech and the way my eyes get dark when I'm tired. I love that I have learned to trust people with my heart, even if it will get broken. I am proud of everything that I am and will become.", "Johnny Weir", "love, self-love, heart, good, bad");
        
        quoteRepo.save(quote1);
        quoteRepo.save(quote2);
        
        Story story1 = new Story("Transforming my life long affair with low self-esteem", "Evelyn Marinoff describes how she turned a negative relationship  with herself into a positive one. She lists the experiments she tried which resulted in this transformation.", "https://www.alustforlife.com/soul/finding-purpose/transforming-my-life-long-affair-with-low-self-esteem", "love, self-love, low self-esteem, self-esteem");
        Story story2 = new Story("Self Love Story: Lessons From the Heart", "Evelyn Lim tells a story about her personal relationships and events which lead to insights about the nature of love; love for yourself as well as love for others.", "https://www.evelynlim.com/self-love-story-lessons-from-the-heart/", "love, self-love, relationships");
        Story story3 = new Story("A Lesson In Self-Worth From A Monk", "A folk tale about how we determine our self worth.", "https://thriveglobal.com/stories/a-lesson-in-self-worth-from-a-monk/", "self-worth, self-esteem");
        
        storyRepo.save(story1);
        storyRepo.save(story2);
        storyRepo.save(story3);
        
        return "index";
    }
    
}
