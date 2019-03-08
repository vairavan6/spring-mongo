package devactivist.repository.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import devactivist.entity.VersionControlStatus;

public interface VersionControlStatusRepo extends MongoRepository<VersionControlStatus, String>{

}
