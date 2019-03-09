package packages.tables;

import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Quote {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @Lob 
    @Column(name="quote", length=1024)
    private String quote;
    
    private String author;
    
    @Lob 
    @Column(name="tags", length=512)
    private String tags;
    
    public Quote(){}
    
    public Quote(String quote, String author, String tags){
        this.quote = quote;
        this.author = author;
        this.tags = tags;
    }
    
    public List<String> getTagsList(){
        List<String> items = Arrays.asList(this.tags.split("\\s*,\\s*"));
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
    
    public String getAuthor(){
        return this.author;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
    
    public String getTags(){
        return this.tags;
    }
    
    public void setTags(String tags){
        this.tags = tags;
    }
    
}
