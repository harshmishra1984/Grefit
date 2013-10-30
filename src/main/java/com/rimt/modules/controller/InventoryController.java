package com.rimt.modules.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import com.rimt.core.AccountUtil;
import com.rimt.dataaccess.entities.UserAccount;
import com.rimt.form.FileUploadForm;
import com.rimt.modules.service.UploadExcelService;

@Controller
public class InventoryController {
	
	 @RequestMapping(value="/add-inventory", method = RequestMethod.GET)  
	 public String addinventory(ModelMap model, HttpServletRequest request) {
		return "addinventory";
	 }
	 
	 @Autowired
	 private ServletContext context;
	 
	 @Resource
	 UploadExcelService uploadExcelService;
	 
	 @RequestMapping(value = "/upload", method = RequestMethod.POST)
	 public String upload (
	            @ModelAttribute("uploadForm") FileUploadForm uploadForm,
	                    Model map, HttpServletRequest request, HttpServletResponse response) throws Exception{
	        List<MultipartFile> files = uploadForm.getFiles();
	        List<String> fileNames = new ArrayList<String>();
	        UserAccount user = AccountUtil.currentAccount();
	         
	        if(null != files && files.size() > 0) {
	            for (MultipartFile multipartFile : files) {
	                String fileName = multipartFile.getOriginalFilename();
	                fileNames.add(fileName);
	                long milli = new Date().getTime();
	                String file = fileName.substring(0, fileName.indexOf("."));
	                try {
	                	multipartFile.transferTo(new File(context.getInitParameter("uploaded_file_path") + file + "_"+milli+".csv"));
	                }
	                catch(Exception ex){
	                	
	                }
	                uploadExcelService.uploadExcel(user, context.getInitParameter("uploaded_file_path") + file + "_"+milli+".csv");
	                System.out.println(fileName);
	 
	            }
	        }
	         
	        map.addAttribute("files", fileNames);
	        return "upload";
	    }
	 
}
