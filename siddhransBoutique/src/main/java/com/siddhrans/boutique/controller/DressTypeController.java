package com.siddhrans.boutique.controller;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


	@RequestMapping(value={"/adddressType"}, method = RequestMethod.GET)
	public String adddepartment(Model model) {
		List<DressType>DressTypeList=dressTypeService.findAllDressTypes();
		model.addAttribute("DressTypeList",DressTypeList);
		model.addAttribute("dressType",new DressType());
		return "dressType";
	}
	@RequestMapping(value={"/adddressType"}, method = RequestMethod.POST)
	public String adddepartment(@Valid DressType dressType, BindingResult result,Model model) {
		List<DressType>DressTypeList=dressTypeService.findAllDressTypes();
		model.addAttribute("DressTypeList",DressTypeList);
		if (result.hasErrors()) {
			logger.debug("ERROR IS : "+result.getAllErrors()+" error count is "+result.getErrorCount());		
			model.addAttribute("dressType", dressType);
			return "customerDetails";
		}	
		
		/*DressTypeList.add(dressType);*/
		dressTypeService.saveDressType(dressType);
		DressTypeList.add(dressType);
		model.addAttribute("message","Dress Type added Sucessfully.");
		model.addAttribute("dressType", new DressType());
		return "dressType";
	}
}