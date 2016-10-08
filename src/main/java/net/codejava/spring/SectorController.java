package net.codejava.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.codejava.spring.dao.SectorDAO;
import net.codejava.spring.model.Project;
import net.codejava.spring.model.Sector;
import net.codejava.spring.services.ProjectService;
import net.codejava.spring.services.SectorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SectorController {
	
	/*@Autowired
	private SectorDAO sectorDao;
	*/
	
	 @Autowired
	 private ProjectService projectService;
	 
	 @Autowired
	 private SectorService sectorService;
	 
	 
	 
	@RequestMapping(value = "/sectors", method = RequestMethod.GET)
	public String listPersons(Model model) {
		//ModelAndView model=new ModelAndView();
		model.addAttribute("sector", new Sector());
		model.addAttribute("sectorList", sectorService.list());
		 model.addAttribute("projectList",  projectService.list());
		return "sector";
	}
	 
	//For add and update person both
	@RequestMapping(value= "/addSector", method = RequestMethod.POST)
	public String addSector(@ModelAttribute("sector") Sector s){
		
		if(s.getId() == 0){
			//new person, add it
			 sectorService.addSector(s);
		}else{
			//existing person, call update
			 sectorService.updateSector(s);
		}
		
		return "redirect:/sectors";
		
	}
	 @RequestMapping("/editSector/{id}")
	    public String editSector(@PathVariable("id") int id, Model model){
	        model.addAttribute("sector", sectorService.getSectorById(id));
	        model.addAttribute("projectList",  projectService.list());
	        model.addAttribute("sectorList", sectorService.list()); //sectorList and jsp item shoudld be same in foreach
	        return "sector";
	    }
	
	
		@RequestMapping("/removeSector/{id}")
	    public String removeSector(@PathVariable("id") int id){
			sectorService.removeSector(id);
	        return "redirect:/sectors";
	    }
	
	
	 
}
