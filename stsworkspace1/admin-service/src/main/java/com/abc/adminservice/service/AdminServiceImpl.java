package com.abc.adminservice.service;

import com.abc.adminservice.entity.Admin;
import com.abc.adminservice.exception.ResourceNotFoundException;
import com.abc.adminservice.model.CabDetails;
import com.abc.adminservice.model.CustomerDetails;
import com.abc.adminservice.model.TripBookingDetails;
import com.abc.adminservice.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CabServiceClient cabServiceClient;
    
    @Autowired
    private BookingServiceClient bookingServiceClient;
    
    @Autowired
    private CustomerServiceClient customerServiceClient;

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(int adminId) {
        return adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with ID: " + adminId));
    }

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(int adminId, Admin admin) {
        if (!adminRepository.existsById(adminId)) {
            throw new ResourceNotFoundException("Admin not found with ID: " + adminId);
        }
        admin.setAdminId(adminId);
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(int adminId) {
        if (!adminRepository.existsById(adminId)) {
            throw new ResourceNotFoundException("Admin not found with ID: " + adminId);
        }
        adminRepository.deleteById(adminId);
        System.out.println("Deleted Successfully");
    }

    @Override
    public List<CabDetails> getCabDetails(){
        return cabServiceClient.getAllCabDetails();
    }
    
    @Override
    public List<TripBookingDetails> getTripBookingDetails(){
        return bookingServiceClient.getAllTripBookingDetails();
    }
    
    @Override
    public List<CustomerDetails> getCustomerDetails(){
        return customerServiceClient.getAllCustomerDetails();
    }
}