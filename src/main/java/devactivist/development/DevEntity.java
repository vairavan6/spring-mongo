package devactivist.development;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DevEntity {
	
	private String fileName;
	private String framework;
	private String layoutType;
	private String layoutPattern;

}
