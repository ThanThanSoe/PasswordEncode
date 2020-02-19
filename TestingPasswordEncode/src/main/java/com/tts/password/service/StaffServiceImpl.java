package com.tts.password.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tts.password.dao.StaffDAO;
import com.tts.password.model.Staff;

@Service
@Transactional
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	private StaffDAO staffDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void addStaff(Staff staff) {
		// TODO Auto-generated method stub
		staff.setPassword(passwordEncoder.encode(staff.getPassword()));
		staffDao.addStaff(staff);
	}

	@Override
	public List<Staff> getAllStaff() {
		// TODO Auto-generated method stub
		return staffDao.getAllStaff();
	}

	@Override
	public void deleteStaff(int staffId) {
		// TODO Auto-generated method stub
		staffDao.deleteStaff(staffId);
	}

	@Override
	public Staff getStaffById(int staffId) {
		// TODO Auto-generated method stub
		return staffDao.getStaffById(staffId);
	}

	@Override
	public Staff updateStaff(Staff staff) {
		// TODO Auto-generated method stub
		return staffDao.updateStaff(staff);
	}

}

