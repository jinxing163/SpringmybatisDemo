package com.ssm.service.excel;

import java.io.OutputStream;

public interface ExcelExportService {

	void ExportUserInfo(OutputStream out);
	
	void ImportUserInfo();
}
