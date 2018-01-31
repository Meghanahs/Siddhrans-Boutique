package com.siddhrans.boutique.controller;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.validation.Valid;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.siddhrans.boutique.model.DressType;
import com.siddhrans.boutique.model.MeasurementDetails;
import com.siddhrans.boutique.service.CustomerDetailsService;
import com.siddhrans.boutique.service.DressTypeService;
import com.siddhrans.boutique.service.MeasurementDetailsService;

public class GenerateBillController {
	@Autowired
	MeasurementDetailsService MeasurementDetailsService;
	@Autowired
	DressTypeService dressTypeService;
	@Autowired
	CustomerDetailsService customerDetailsService;

	@RequestMapping(value = { "/generate-Bill" }, method = RequestMethod.GET)
	public String generateBill(ModelMap model) {
		List<MeasurementDetails> measurementDetails = MeasurementDetailsService.findAllMeasurementDetails();
		model.addAttribute("measurementDetails", measurementDetails);
		return "measurementdetails";		
	}
	
@RequestMapping(value = {"/generate-Bill"}, method = RequestMethod.POST)
public String generateBill(@Valid MeasurementDetails measurementDetails, BindingResult result,
		ModelMap model) throws  IOException, DocumentException {
	MeasurementDetails measurementDetailsdata = MeasurementDetailsService.findByID(measurementDetails.getMeasurementId());
   	model.addAttribute("measurementDetailsdata", measurementDetailsdata);
   	List<DressType> dressTypeList= dressTypeService.findAllDressTypes();
	model.addAttribute("dressTypeList",dressTypeList);
        return"measurementdetails";
}

private void generateAndSaveBill(MeasurementDetails measurementDetails) throws  IOException, DocumentException{
	//TODO: Write logic to add total salary to template excel sheet
	File file = new File("C:/Bill/BillTemplate.xlsx");
	FileInputStream inputStream = new FileInputStream(file);
	BufferedInputStream bis = new BufferedInputStream(inputStream);
	Workbook workbook =  new XSSFWorkbook(bis);
	workbook.setForceFormulaRecalculation(true);
	Sheet sheet = workbook.getSheetAt(0);
	//int rowCount = sheet.getLastRowNum();
	Row row = sheet.getRow(1);
	Cell cell = row.createCell(29);//total order Column
	inputStream.close();
	bis.close();
/*
	FileOutputStream outputStream = new FileOutputStream("C:/Bill/"+CustomerDetailsService.);
	workbook.write(outputStream);
	cell = row.createCell(8);//total Salary Column
	cell.setCellValue(0.0);
	cell = row.createCell(7);//OT Salary Column
	cell.setCellValue(0.0);
	workbook.close();
	outputStream.close();*/

}

}
