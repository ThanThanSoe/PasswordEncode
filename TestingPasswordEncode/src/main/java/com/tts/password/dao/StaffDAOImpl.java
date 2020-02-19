package com.tts.password.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tts.password.model.Staff;

@Repository
public class StaffDAOImpl implements StaffDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addStaff(Staff staff) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(staff);
	}

	@SuppressWarnings("unchecked")
	public List<Staff> getAllStaff() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Staff").list();
	}

	@Override
	public void deleteStaff(int staffId) {
		// TODO Auto-generated method stub
		Staff staff= (Staff) sessionFactory.getCurrentSession().load(Staff.class, staffId);
		if(staff != null) {
			this.sessionFactory.getCurrentSession().delete(staff);
		}
	}

	@Override
	public Staff getStaffById(int staffId) {
		// TODO Auto-generated method stub
		return (Staff) sessionFactory.getCurrentSession().get
				(Staff.class, staffId);
	}

	@Override
	public Staff updateStaff(Staff staff) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(staff);
		return staff;
	}

}
