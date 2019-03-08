package packages.tables;

import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Story {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String title;
    
    private String description;
    
    private String URL;
    
    private String tags;
    
    public Story(){}
    
    public Story(String title, String description, String URL, String tags){
        this.title = title;
        this.description = description;
        this.URL = URL;
        this.tags = tags;
    }
    
    public List<String> getTagsList(){
        List<String> items = Arrays.asList(this.tags.split(","));
        return items;
    }
    
    public Integer getId(){
        return this.id;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setDescription(String Description){
        this.description = Description;
    }
    
    public String getURL(){
        return this.URL;
    }
    
    public void setURL(String URL){
        this.URL = URL;
    }
    
    public String getTags(){
        return this.tags;
    }
    
    public void setTags(String tags){
        this.tags = tags;
    }
    
}
