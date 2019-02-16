package devactivist.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection="WorksheetPasDetails")
public class WorksheetPasDetails {
	@Id
	private ObjectId id;

	@Indexed(unique=true)
	private String dprName;
	
	private long totalCount;
	private long targetCount;
	private long duplicateCount;
	private long commonCount;
	
	private String lableader;
	private String assignee;
	
	private List<String> targetPasFiles;
	private List<String> duplicatePasFiles;
}
