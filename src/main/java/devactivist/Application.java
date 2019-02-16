package devactivist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import devactivist.entity.WorksheetPasDetails;

import devactivist.repository.interfaces.WorksheetPasDetailsRepo;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private WorksheetPasDetailsRepo pasDetailsRepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<WorksheetPasDetails> cxv = pasDetailsRepo.findAll();
		System.out.println(cxv);
		
		List<String> pasFileList = new ArrayList<String>();
		pasFileList.add("file1.pas");
		pasFileList.add("file2.pas");
		pasFileList.add("file3.pas");

		List<String> dupFileList = new ArrayList<String>();
		dupFileList.add("file1.pas");
		dupFileList.add("file2.pas");
		dupFileList.add("file3.pas");

		WorksheetPasDetails pasDetails = WorksheetPasDetails.builder()
				.dprName("aciil.dpr")
				.assignee("developer")
				.lableader("lead")
				.commonCount(5)
				.targetCount(5)
				.totalCount(15)
				.duplicateCount(5)
				.targetPasFiles(pasFileList)
				.duplicatePasFiles(dupFileList)
				.build();
		
//		pasDetailsRepo.save(pasDetails);
		
		cxv = pasDetailsRepo.findAll();
		System.out.println(cxv);
		
	}

}
