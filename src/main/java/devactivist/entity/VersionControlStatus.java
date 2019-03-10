package devactivist.entity;

import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data@Builder
@Document(collection="version_control_status")
public class VersionControlStatus {

	private String versionType;
	
	private String moduleName;
	
	private boolean syncInProgress;

	@LastModifiedDate
	private Date lastSyncStartTime;
	
	private Date lastSyncEndTime;

}
