
package packages.model;

public class Query {
    private String query;
    
    private Boolean resultFound;
    
    public Query(){}
    
    public Query(String query, Boolean resultsFound){
        this.query = query;
    }
    
    public String getQuery(){
        return this.query;
    }
    
    public Boolean anyResultsFound(){
        return this.resultFound;
    }
}
