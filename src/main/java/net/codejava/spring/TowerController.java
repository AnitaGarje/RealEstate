package net.codejava.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.codejava.spring.dao.TowerDAO;
import net.codejava.spring.model.Sector;
import net.codejava.spring.model.Tower;
import net.codejava.spring.services.SectorService;
import net.codejava.spring.services.TowerService;

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
public class TowerController {
	
	/*@Autowired
	private SectorDAO towerDao;
	*/
	
	 @Autowired
	 private SectorService sectorService;
	 
	 @Autowired
	 private TowerService towerService;
	 
	 
	 
	@RequestMapping(value = "/towers", method = RequestMethod.GET)
	public String listPersons(Model model) {
		//ModelAndView model=new ModelAndView();
		model.addAttribute("tower", new Tower());
		model.addAttribute("towerList", towerService.list());
		 model.addAttribute("sectorList",  sectorService.list());
		return "tower";
	}
	 
	//For add and update person both
	@RequestMapping(value= "/addTower", method = RequestMethod.POST)
	public String addTower(@ModelAttribute("tower") Tower s){
		
		if(s.getId() == 0){
			//new person, add it
			 towerService.addTower(s);
		}else{
			//existing person, call update
			 towerService.updateTower(s);
		}
		
		return "redirect:/towers";
		
	}
	 @RequestMapping("/editTower/{id}")
	    public String editTower(@PathVariable("id") int id, Model model){
	        model.addAttribute("tower", towerService.getTowerById(id));
	        model.addAttribute("sectorList",  sectorService.list());
	        model.addAttribute("towerList", towerService.list()); //towerList and jsp item shoudld be same in foreach
	        return "tower";
	    }
	
	
		@RequestMapping("/removeTower/{id}")
	    public String removeTower(@PathVariable("id") int id){
			towerService.removeTower(id);
	        return "redirect:/towers";
	    }
	
	
	 
}
