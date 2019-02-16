package devactivist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("worksheet/")
public class WorksheetDetailController {
	
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
