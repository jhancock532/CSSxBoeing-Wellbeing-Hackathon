
package packages.model;

import packages.tables.Quote;
import packages.tables.Story;

public class QuoteStory {
    
    public Quote quote;
    public Story story;
    public String type;
    
    public QuoteStory(){}
    
    public QuoteStory(Quote quote){
        this.quote = quote;
        this.type = "quote";
    }
    
    public QuoteStory(Story story){
        this.story = story;
        this.type = "story";
    }
}
