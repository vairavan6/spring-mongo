package devactivist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devactivist.service.HierarchyClassifierService;

@Controller
@RestController
@RequestMapping("worksheet/")
public class WorksheetDetailController {
	
	@Autowired
	private HierarchyClassifierService hierarchyService;
	
	@GetMapping("save/pas/hiearchy")
	public void savePasFileHierarchy() {
		hierarchyService.main();	
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
