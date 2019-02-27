package devactivist.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection="pas_file_hierarchy")
public class PasFileHierarchy {
	
	private boolean isChild = false;
	private boolean isParent;
	private String parentFile;
	private String fileName;
	
	private List<PasFileHierarchy> childEntry;

}
