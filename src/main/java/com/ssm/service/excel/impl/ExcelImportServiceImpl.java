package com.ssm.service.excel.impl;



import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.UrlResource;

import com.ssm.service.excel.ExcelImportService;

public class ExcelImportServiceImpl implements ExcelImportService{

	@Override
	public void ImportUserInfo() {
		UrlResource resource;
		try {
			resource = new UrlResource("");
			XSSFWorkbook wb = new XSSFWorkbook(resource.getInputStream());
	        XSSFSheet sheet = wb.getSheetAt(0);
	        wb.close();
        
	        if(sheet!=null){
				 //标题占两行，从第三行开始（index=2）到最后一行
	            for(int rowNum = 2 ; rowNum <= sheet.getLastRowNum() ; rowNum++){

	                //获取某一行
	                XSSFRow row = sheet.getRow(rowNum);
	                if(row != null){
	                	
	                	//获取excel中某一列的值,目前只获取章节列（章节列下标为2）
	                	XSSFCell cell = row.getCell(2);
	                	if(cell !=null){
	                		String cellValue=cell.toString();
		                	
			                
	                	}
	                	
	                }           
	            }
	            

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
       
		
	}

}
