
package packages.repositories;

import org.springframework.data.repository.CrudRepository;
import packages.tables.Story;

public interface StoryRepository extends CrudRepository<Story, Integer>{
    
}
