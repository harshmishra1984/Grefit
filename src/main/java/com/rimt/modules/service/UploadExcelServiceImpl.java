package com.rimt.modules.service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.rimt.common.util.ViewToDto;
import com.rimt.dataaccess.entities.Inventory;
import com.rimt.dataaccess.entities.UserAccount;
import com.rimt.form.InventoryForm;
import com.rimt.modules.dao.CrudRepository;

@Service
public class UploadExcelServiceImpl implements UploadExcelService {
	
	@Resource
	DataService dataService;
	
	@Resource
	CrudRepository crudRepository;

	public void  uploadExcel(UserAccount user , String filename) throws Exception {
		
		ColumnPositionMappingStrategy<InventoryForm> strat = new ColumnPositionMappingStrategy<InventoryForm>();
		strat.setType(InventoryForm.class);
		String[] columns = new String[] { "City", "Location", 
				"Property Type", "Builder", "Project",  "BHK", "Size",  
				"Unit (ft/yd)", "Floor",  "Tower", "Booking", "Paid Up",
				"Demand",  "White Part", "Black Part" , "Remark"}; 
		strat.setColumnMapping(columns);
		

		CsvToBean<InventoryForm> csv = new CsvToBean<InventoryForm>();
		CSVReader csvReader = new CSVReader(new FileReader(filename), ',');

		List<InventoryForm> list = csv.parse(strat, csvReader);
		List<Inventory> list_part = new ArrayList<Inventory>();
		
		int counter = 0;
		for (Object object : list) {
			if (counter ==  0){
				counter= counter + 1; 
				continue;
			} 
			InventoryForm inventoryForm = (InventoryForm) object;
			Inventory dto = ViewToDto.convert(inventoryForm);
			list_part.add(dto);
		}
		load(user, list_part);
	}
	
	private void load(UserAccount user,
			List<Inventory> list) {
		String sql =
				"INSERT INTO inventory " +
						" (user_id,city,locality,builder,project,inventory_type,bhk,unit,size,tower,floor,"
						+ " booking_amount,paid_up,white,"
						+ " black,property_type,status,remark,demand)"+
						" VALUES " +
						" ( %d, '%s' ,'%s' ,'%s', '%s' ,'%s' ,'%s', '%s' ,'%s' ,'%s', '%s' ,'%s' ,'%s', '%s' ,'%s' ,'%s', %d ,'%s','%s') ";
		List<String> strList =  new ArrayList<String>();
		for (int i = 0; i<list.size(); i++){
			strList.add(String.format(sql, user.getId(), list.get(i).getCity(),list.get(i).getLocality(),
					list.get(i).getBuilder(), list.get(i).getProject(), 
					list.get(i).getInventoryType(), list.get(i).getBhk(), list.get(i).getUnit(), 
					list.get(i).getSize(), list.get(i).getTower(), list.get(i).getFloor(), list.get(i).getBookingAmount(), 
					list.get(i).getPaidUp(),list.get(i).getWhite(), list.get(i).getBlack(), list.get(i).getPropertyType(), 
					1, list.get(i).getRemark(), list.get(i).getDemand()));
		}
		for(String str : strList){
			System.out.println(str);
		}
		crudRepository.insertBatchSQL(strList.toArray(new String[strList.size()]));
		
	}
	


}
