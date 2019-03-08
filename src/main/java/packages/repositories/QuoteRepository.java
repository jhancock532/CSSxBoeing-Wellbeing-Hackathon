
package packages.repositories;

import org.springframework.data.repository.CrudRepository;
import packages.tables.Quote;

public interface QuoteRepository extends CrudRepository<Quote, Integer>{
    
}
