package com.rimt.dataaccess.entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestMain {
	
	/**
	 * @param filePath
	 * @throws Exception
	 */
	public static void getKnownGoodMap(String filePath) throws Exception{
		Workbook wb = WorkbookFactory.create(new File("/home/mobilestorm/Desktop/rimt.xlsx"));
	    Sheet mySheet = wb.getSheetAt(0);
	    Iterator<Row> rowIter = mySheet.rowIterator();
	    Map<Integer, String> map =new HashMap<Integer, String>();
	    map.put(0, "name");
	    map.put(1, "type");
	    map.put(2, "grade");
	    TestInv inv = null;
	    while(rowIter.hasNext()){
	    	int index = 0;
	    	inv = new TestInv();
	    	Row row = rowIter.next();
	    	while(index<=2){
	    		Cell cell = row.getCell(index);
	    		//System.out.println(cell);
	    		RichTextString s = null;
	    		if(cell!=null){
	    			s = cell.getRichStringCellValue();
	    		}
	    		
	    		if (s!=null)
	    			System.out.println(s.toString());
	    		else
	    			System.out.println("Null");
	    		index = index+1;
	    	}
	    	
	    		
	    	}
	    	
	    }
	
	
        

	
	
	public static void main(String[] args) throws Exception{
		getKnownGoodMap("/home/mobilestorm/Desktop/rimt.xlsx");
	}

}
