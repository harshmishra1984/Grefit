package com.rimt.modules.service;

import java.util.List;

import com.rimt.dataaccess.entities.UserAccount;

public interface UploadExcelService {
	
	public void uploadExcel(UserAccount user ,String filename) throws Exception;

}
