package com.ssm.service.excel.impl;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.stereotype.Service;

import com.ssm.constant.ExcelConstant;
import com.ssm.pojo.User;
import com.ssm.service.IUserService;
import com.ssm.service.excel.ExcelExportService;

@Service("excelExportService")
public class ExcelExportServiceImpl implements ExcelExportService{

	@Resource
	private IUserService userService;
	
	@Override
	public void ExportUserInfo(OutputStream out) {
		
		// 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        try  
        {  
        	
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
            HSSFSheet sheet = wb.createSheet("学生表一");  
            sheet.setDefaultColumnWidth(ExcelConstant.DefaultColumnWidth.intValue());  
            sheet.setDefaultRowHeightInPoints(ExcelConstant.DefaultRowHeightInPoints.intValue()); 
     
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
            HSSFRow row = sheet.createRow((int) 0);  
            // 第四步，创建单元格，并设置值表头 设置表头居中  
            HSSFCellStyle headStyle = getExcelHeadStyle(wb);//表头样式  
            HSSFCellStyle cellStyle = getExcelCellStyle(wb);//单元格样式  
    		List<String>headInfoList=getExcelHeadInfo();
    		
    		for (int i = 0; i < headInfoList.size(); i++) {
    			this.createExcelCell(sheet,row, i, headInfoList.get(i), headStyle);
    		}
            
            // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
            List<User> list = userService.getUserListTop100(); 
            
            for (int i = 0; i < list.size(); i++){
            	
            	User user =list.get(i); 
            	if(user !=null){
            		row = sheet.createRow((int) i + 1);  
            		// 第四步，创建单元格，并设置值  
            		this.createExcelCell(sheet,row, 0, user.getId()==null?"":user.getId().toString(), cellStyle);
            		this.createExcelCell(sheet,row, 1, user.getUsername()==null?"":user.getUsername(), cellStyle);
            		this.createExcelCell(sheet,row, 2, user.getNickName()==null?"":user.getNickName(), cellStyle);
            		if(user.getSex() !=null && user.getSex().equals("1")){
            			this.createExcelCell(sheet,row, 3,"男", cellStyle);
            		}else if(user.getSex() !=null && user.getSex().equals("0")){
            			this.createExcelCell(sheet,row, 3,"女", cellStyle);
            		}else{
            			this.createExcelCell(sheet,row, 3,user.getSex(), cellStyle);
            		}
            		
            		this.createExcelCell(sheet,row, 4, user.getPhoneNumber()==null?"":user.getPhoneNumber(), cellStyle);
            		this.createExcelCell(sheet,row, 5, user.getIdCardsNumber()==null?"":user.getIdCardsNumber(), cellStyle);
            		this.createExcelCell(sheet,row, 6, user.geteMail()==null?"":user.geteMail(), cellStyle);
            		this.createExcelCell(sheet,row, 7, user.getBirthday()==null?"":user.getBirthday(), cellStyle);
            		this.createExcelCell(sheet,row, 8, user.getCompanyName()==null?"":user.getCompanyName(), cellStyle);

            	}
                 
    		}
            // 第六步，将文件存到指定位置  
//            FileOutputStream fout = new FileOutputStream("E:/test/students.xls");  
              if(out !=null){
            	  wb.write(out); 
              }
              wb.close();  
        }  
        catch (Exception e)  {  
        	
            e.printStackTrace();  
        }
        
	}
	
	//excel表头信息定义
	public List<String>getExcelHeadInfo(){
		List<String> list=new ArrayList<String>();
		list.add(0,"用户编号");
		list.add(1,"用户名");
		list.add(2,"昵称");
		list.add(3,"性别");
		list.add(4,"手机号");
		list.add(5,"身份证");
		list.add(6,"邮箱");
		list.add(7,"出生年月");
		list.add(8,"公司名称");
		return list;
	}
	
	//创建Excel单元格公用方法
	//row : 	excel行对象
	//index: 	excel创建列单元格下标
	//cellValue：单元格的值
	//style: 	excel单元格样式
	public void createExcelCell(HSSFSheet sheet,HSSFRow row,Integer index,String cellValue, HSSFCellStyle style){
		HSSFCell cell=row.createCell(index);  
        cell.setCellValue(cellValue);  
        if(style !=null){
        	cell.setCellStyle(style);
        } 
        if(cellValue ==null || cellValue==""){
        	HSSFComment comment=this.getCellAnnotation(sheet);
        	cell.setCellComment(comment);//添加注释
        }
        
	}
	
	//获取excel头部的样式
	public HSSFCellStyle getExcelHeadStyle(HSSFWorkbook wb){
		
		HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中 
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
        // 背景色
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
        style.setFillBackgroundColor(HSSFColor.PALE_BLUE.index); 
        // 设置边框
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN); 
        // 自动换行  
        style.setWrapText(true);  
        // 生成一个字体
        HSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 11);
        font.setColor(HSSFColor.BLACK.index);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("微软雅黑");
        // 把字体 应用到当前样式
        style.setFont(font);
		
		return style;
	}
	
	//获取excel单元格的样式
	public HSSFCellStyle getExcelCellStyle(HSSFWorkbook wb){
		HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中 
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中

        // 设置边框
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN); 
        // 自动换行  
        style.setWrapText(true);  
        // 生成一个字体
        HSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setColor(HSSFColor.BLACK.index);
        font.setFontName("微软雅黑");
        // 把字体 应用到当前样式
        style.setFont(font);
		
		return style;
	}
	
	//单元格注释
	public HSSFComment getCellAnnotation(HSSFSheet sheet){
		 // 添加单元格注释
        // 创建HSSFPatriarch对象,HSSFPatriarch是所有注释的容器.
        HSSFPatriarch patr = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        HSSFComment comment = patr.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short)4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("信息为空！"));
        // 设置注释作者. 当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("JinXing");
        
        return comment;
	}

	@Override
	public void ImportUserInfo() {
		// TODO Auto-generated method stub
		
	}
	
}
