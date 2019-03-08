package devactivist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devactivist.dto.UtilityConstants;
import devactivist.entity.VersionControlStatus;
import devactivist.repository.interfaces.VersionControlStatusRepo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StartupVersionControlService {
	
	@Autowired
	private VersionControlStatusRepo versionControlStatusRepo;

	public static void main(String[] args) {
		
	}
	
//	@PostConstruct
	public static void callSVN() {
		
		VersionControlStatus versionControlStatus = VersionControlStatus.builder()
				.versionType(UtilityConstants.AC_GIT)
				.syncInProgress(false)
				.build();
		
	}
}
