package com.tts.password.service;

import java.util.List;

import com.tts.password.model.Staff;

public interface StaffService {

	public void addStaff(Staff staff);
	
	public List<Staff> getAllStaff();

	public void deleteStaff(int staffId);

	public Staff getStaffById(int staffId);

	public Staff updateStaff(Staff staff);
}
