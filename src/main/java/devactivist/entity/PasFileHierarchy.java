package devactivist.entity;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PasFileHierarchy {
	
	private boolean isChild = false;
	private boolean isParent;
	private String parentFile;
	private String fileName;
	
	private List<PasFileHierarchy> childEntry;

}
