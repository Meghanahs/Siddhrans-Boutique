package com.siddhrans.boutique.controller;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.siddhrans.boutique.model.DressType;
import com.siddhrans.boutique.service.DressTypeService;

@Controller
public class DressTypeController {

	@Autowired
	DressTypeService dressTypeService;
	
	static final Logger logger = LoggerFactory.getLogger(DressTypeController.class);


	@RequestMapping(value={"/dressTypeList"}, method = RequestMethod.GET)
	public String adddepartment(Model model) {
		List<DressType>DressTypeList=dressTypeService.findAllDressTypes();
		model.addAttribute("DressTypeList",DressTypeList);
		model.addAttribute("dressType",new DressType());
		model.addAttribute("loggedinuser", getPrincipal());
		return "dressType";
	}
	@RequestMapping(value={"/adddressType"}, method = RequestMethod.POST)
	public String adddepartment(@Valid DressType dressType, BindingResult result,Model model) {
		List<DressType>DressTypeList=dressTypeService.findAllDressTypes();
		model.addAttribute("DressTypeList",DressTypeList);
		if (result.hasErrors()) {
			logger.debug("ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());		
			model.addAttribute("dressType", dressType);
	
			return "dressType";
		}	
		
		/*DressTypeList.add(dressType);*/
		dressTypeService.saveDressType(dressType);
		DressTypeList.add(dressType);
		model.addAttribute("message","Dress Type added Sucessfully.");
		model.addAttribute("dressType", new DressType());
		model.addAttribute("loggedinuser", getPrincipal());
		return "dressType";
	}
	
	@RequestMapping(value = { "/deleteDressType" }, method = RequestMethod.POST)
	public String deleteDressType(@Valid DressType dressType, BindingResult result, ModelMap model) {
		dressTypeService.deleteDressType(dressType.getDressId());
		List<DressType>DressTypeList=dressTypeService.findAllDressTypes();
		model.addAttribute("DressTypeList",DressTypeList);
		model.addAttribute("message","Deleted Dress Type Sucessfully.");
		model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/adddressType";
	}
	
	@RequestMapping(value={"/editDressType"}, method = RequestMethod.POST)
	public String editDressType(@Valid DressType dressType, BindingResult result,ModelMap model) {
		DressType dressTypeData = dressTypeService.findById(dressType.getDressId());
       	model.addAttribute("dressTypeData", dressTypeData);	
		model.addAttribute("loggedinuser", getPrincipal());
		return "editDressType";
	}
			
	@RequestMapping(value={"/UpdateDressType"}, method = RequestMethod.POST)
	public String updateDressType(@Valid DressType dressTypeData, BindingResult result,
			ModelMap model) {
		dressTypeService.updateDressType(dressTypeData);
		/*model.addAttribute("message","Updated Employee Sucessfully.");*/
		model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/dressTypeList";
	}
	
	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String loggedinUser = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			loggedinUser = ((UserDetails)principal).getUsername();
		} else {
			loggedinUser = principal.toString();
		}
		return loggedinUser;
	}
}