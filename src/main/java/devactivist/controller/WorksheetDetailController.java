package devactivist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devactivist.entity.PasFileHierarchy;
import devactivist.service.HierarchyClassifierService;

@RestController
@CrossOrigin
@RequestMapping("worksheet/")
public class WorksheetDetailController {
	
	@Autowired
	private HierarchyClassifierService hierarchyService;
	
	@GetMapping("save/pas/hiearchy")
	public void savePasFileHierarchy() {
		hierarchyService.main();	
	}
	
	@GetMapping("pas/hiearchy")
	public List<PasFileHierarchy> retrievePasFileHierarchy() {
		return hierarchyService.getHierarchyData();
	}
	
	@PostMapping("save/pas/details")
	public void persistPasInfo() {
		
	}
	
	@PostMapping("save/suggest/plugin/details")
	public void persistSuggestPluginData() {
		
	}
	
	@PostMapping("save/social/plugin/details")
	public void persistSocialPluginData() {
		
	}
}
