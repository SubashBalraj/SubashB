package com.abc.adminservice.service;

import com.abc.adminservice.entity.Admin;
import com.abc.adminservice.model.CabDetails;
import com.abc.adminservice.model.CustomerDetails;
import com.abc.adminservice.model.TripBookingDetails;

import java.util.List;

public interface AdminService {
   
	List<Admin> getAllAdmins();
    
	Admin getAdminById(int adminId);
    
	Admin createAdmin(Admin admin);
    
	Admin updateAdmin(int adminId, Admin admin);
    
	void deleteAdmin(int adminId);

	List<CabDetails> getCabDetails();
	
	List<TripBookingDetails> getTripBookingDetails();
	
	List<CustomerDetails> getCustomerDetails();
}

