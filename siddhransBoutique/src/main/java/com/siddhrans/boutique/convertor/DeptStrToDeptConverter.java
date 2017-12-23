package com.siddhrans.boutique.convertor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.siddhrans.boutique.model.Department;
import com.siddhrans.boutique.service.DepartmentService;

@Component
public class DeptStrToDeptConverter implements Converter<Object, Department>{
 
    static final Logger logger = LoggerFactory.getLogger(DeptStrToDeptConverter.class);
     
    @Autowired
    DepartmentService departmentService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Department convert(Object element) {
    	if(element instanceof String){
    		Integer id = Integer.parseInt((String)element);
            logger.info("Department ID is: {}",id);
            Department department= departmentService.findById(id);
            logger.info("Department : {}",department);
            return department;
    	} else {
    		return (Department)element;
    	}
    }    
}
