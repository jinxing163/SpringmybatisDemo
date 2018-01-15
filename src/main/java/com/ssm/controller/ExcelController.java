package com.ssm.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.service.excel.ExcelExportService;


@Controller
@RequestMapping("/excel")
public class ExcelController {
	
	@Resource
	private ExcelExportService excelExportService;
	
	//Excel导出用户列表信息
	@RequestMapping("/exportUserList")
	public void excelExportUserListInfo(Model model,HttpServletResponse response){

		response.setContentType("octets/stream");  
//      response.addHeader("Content-Disposition", "attachment;filename=test.xls");  
        String excelName = "用户信息表";  
        //转码防止乱码  
        try {
			response.addHeader("Content-Disposition", "attachment;filename="+new String( excelName.getBytes("gb2312"), "ISO8859-1" )+".xls");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
        try {  
            OutputStream out = response.getOutputStream();  
            this.excelExportService.ExportUserInfo(out);
            out.close();  
        } catch (FileNotFoundException e) {  
                e.printStackTrace();  
        } catch (IOException e) {  
                e.printStackTrace();  
        }  

	}
	

}
