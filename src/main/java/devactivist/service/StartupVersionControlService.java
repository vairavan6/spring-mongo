package devactivist.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

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

	@PostConstruct
	public void callSVN() {

		List<String> versionList = new ArrayList<>();

		versionList.add(UtilityConstants.AC_GIT);
		versionList.add(UtilityConstants.AC_SVN40);
		versionList.add(UtilityConstants.AC_SVN41);

		VersionControlStatus versionControlStatus = VersionControlStatus.builder()
				.syncInProgress(true)
				.lastSyncStartTime(new Date())
				.build();

		versionList.forEach(vType -> {
			versionControlStatus.setVersionType(vType);
			versionControlStatus.setModuleName("CAC");
			versionControlStatusRepo.save(versionControlStatus);
			versionControlStatus.setModuleName("CAM");
			versionControlStatusRepo.save(versionControlStatus);
			versionControlStatus.setModuleName("CBM");
			versionControlStatusRepo.save(versionControlStatus);
			versionControlStatus.setModuleName("CCM");
			versionControlStatusRepo.save(versionControlStatus);
			versionControlStatus.setModuleName("CFM");
			versionControlStatusRepo.save(versionControlStatus);
		});

	}
}
