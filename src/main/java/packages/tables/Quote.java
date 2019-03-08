package packages.tables;

import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quote {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String quote;
    
    private String author;
    
    private String tags;
    
    public Quote(){}
    
    public Quote(String quote, String author, String tags){
        this.quote = quote;
        this.author = author;
        this.tags = tags;
    }
    
    public List<String> getTagsList(){
        List<String> items = Arrays.asList(this.tags.split(","));
        return items;
    }
    
    public Integer getId(){
        return this.id;
    }
    
    public String getQuote(){
        return this.quote;
    }
    
    public void setQuote(String quote){
        this.quote = quote;
    }
    
    public String getTags(){
        return this.tags;
    }
    
    public void setTags(String tags){
        this.tags = tags;
    }
    
}
