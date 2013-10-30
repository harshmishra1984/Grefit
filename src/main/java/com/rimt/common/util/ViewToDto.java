package com.rimt.common.util;

import com.rimt.common.UserAccountStatus;
import com.rimt.dataaccess.entities.Inventory;
import com.rimt.form.InventoryForm;

public class ViewToDto {
	
	public static Inventory convert(InventoryForm inv){
		Inventory dto = new Inventory();
		
		dto.setCity(inv.getCity());
		dto.setPropertyType(inv.getPropertyType());
		dto.setBhk(inv.getBhk());
		dto.setBlack(inv.getBlackPart());
		dto.setBookingAmount(inv.getBooking());
		dto.setBuilder(inv.getBuilder());
		dto.setDemand(inv.getDemand());
		dto.setFloor(inv.getFloor());
		dto.setLocality(inv.getLocation());
		dto.setPaidUp(inv.getPaydUp());
		dto.setProject(inv.getProject());
		dto.setRemark(inv.getRemark());
		dto.setStatus(UserAccountStatus.ACTIVE);
		return dto;
	}
	
	
	

}
