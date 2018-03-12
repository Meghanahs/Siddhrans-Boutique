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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.siddhrans.boutique.model.Department;
import com.siddhrans.boutique.model.Designation;
import com.siddhrans.boutique.service.DepartmentService;
import com.siddhrans.boutique.service.DesignationService;

@Controller
public class DesignationController {

	static final Logger logger = LoggerFactory.getLogger(DesignationController.class);

	@Autowired
	DesignationService designationService;

	@Autowired
	DepartmentService departmentService;

	/*	@RequestMapping(value={"/adddesignation"}, method = RequestMethod.GET)
    public String addDesignation(Model model) {
		List<Department> departments = departmentService.findAllDepartments();
		model.addAttribute("designation",new Designation());
		model.addAttribute("departmentList",departments);
        return "designation";
    }*/

	@RequestMapping(value={"/listDesignation"}, method = RequestMethod.GET)
	public String addDesignation(Model model) {
		List<Designation> designations = designationService.findAllDesignations();
		model.addAttribute("designations", designations);
		List<Department> departmentsList = departmentService.findAllDepartments();
		model.addAttribute("departmentsList",departmentsList);
		model.addAttribute("designation",new Designation());
		model.addAttribute("loggedinuser", getPrincipal());
		return "designation";
	}

	/*@RequestMapping(value={"/saveDesignation"}, method = RequestMethod.POST)
    public String saveDesignation(@Valid Designation designation, BindingResult result,Model model,
    		final RedirectAttributes redirectAttrs) {
		designationService.saveDesignation(designation);
        return "redirect:adddesignation";
    }*/

	@RequestMapping(value={"/adddesignation"}, method = RequestMethod.POST)
	public String saveDesignation(@Valid Designation designation, BindingResult result,Model model) {
		if (result.hasErrors()) {
			logger.debug("ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());
			List<Department> departmentsList = departmentService.findAllDepartments();
			model.addAttribute("departmentsList",departmentsList);
			List<Designation> designations = designationService.findAllDesignations();
			model.addAttribute("designations", designations);
			model.addAttribute("designation", designation);
			model.addAttribute("loggedinuser", getPrincipal());
			return "designation";
		}
		designationService.saveDesignation(designation);
		List<Designation> designations = designationService.findAllDesignations();
		model.addAttribute("designations", designations);
		List<Department> departmentsList = departmentService.findAllDepartments();
		model.addAttribute("departmentsList",departmentsList);
		model.addAttribute("designation",new Designation());
		model.addAttribute("message","Designation Added Sucessfully.");
		model.addAttribute("loggedinuser", getPrincipal());
		return "designation";
	}
	
	@RequestMapping(value={"/editDesignation"}, method = RequestMethod.POST)
	public String editdesignationdata(@Valid Designation designation, BindingResult result,ModelMap model) {
		Designation designationData = designationService.findByID(designation.getDesignationId());
		List<Department> departmentsList = departmentService.findAllDepartments();
		model.addAttribute("departmentsList",departmentsList);
		model.addAttribute("designationData", designationData);	
		model.addAttribute("loggedinuser", getPrincipal());
		return "editDesignation";
	}
	
	
	
	@RequestMapping(value={"/editdesignationData"}, method = RequestMethod.POST)
	public String updatedesignation(@Valid Designation designationData, BindingResult result,
			ModelMap model) {
		designationService.updateDesignation(designationData);
		model.addAttribute("message","Updated Employee Sucessfully.");
		model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/adddesignation";
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