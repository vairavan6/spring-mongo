package devactivist.repository.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import devactivist.entity.PasFileHierarchy;

public interface PasFileHierarchyRepo extends MongoRepository<PasFileHierarchy, String>{

}
