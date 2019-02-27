package devactivist.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection="PasRedmineDetails")
public class PasRedmineDetails {
	
	@Id
	private ObjectId id;

	@Indexed(unique=true)
	private String pasFileName;
	
	private String dprName;
	
	private String lableader;
	private String assignee;
	
	private long redmineTicket;
}
