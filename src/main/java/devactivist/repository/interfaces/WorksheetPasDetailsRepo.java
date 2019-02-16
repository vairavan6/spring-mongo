package devactivist.repository.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import devactivist.entity.WorksheetPasDetails;

public interface WorksheetPasDetailsRepo extends MongoRepository<WorksheetPasDetails, String>{

	public WorksheetPasDetails findByDprName(String dprName);
}
