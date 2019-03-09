
package packages.model;

import java.util.List;

public class Query {
    private String query;
    
    private Boolean resultFound;
    
    private List<String> relatedTags;
    
    public Query(){}
    
    public Query(String query, Boolean resultsFound, List<String> relatedTags){
        this.query = query;
        this.resultFound = resultsFound;
        this.relatedTags = relatedTags;
    }
    
    public String getQuery(){
        return this.query;
    }
    
    public Boolean anyResultsFound(){
        return this.resultFound;
    }
    
    public List<String> getRelatedTags(){
        return this.relatedTags;
    }
}
