package com.abc.adminservice.test;

import com.abc.adminservice.entity.Admin;
import com.abc.adminservice.exception.ResourceNotFoundException;
import com.abc.adminservice.model.CabDetails;
import com.abc.adminservice.repository.AdminRepository;
import com.abc.adminservice.service.AdminServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminServiceImpl adminService;

    @Test
    public void testGetAllAdmins() {
        Admin admin1 = new Admin();
        Admin admin2 = new Admin();
        List<Admin> admins = Arrays.asList(admin1, admin2);

        when(adminRepository.findAll()).thenReturn(admins);

        List<Admin> result = adminService.getAllAdmins();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetAdminById() {
        Admin admin = new Admin();
        admin.setAdminId(1);

        when(adminRepository.findById(1)).thenReturn(Optional.of(admin));

        Admin result = adminService.getAdminById(1);

        assertNotNull(result);
        assertEquals(1, result.getAdminId());
    }

    @Test
    public void testGetAdminById_AdminNotFound() {
        when(adminRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> adminService.getAdminById(1));
    }
    
    @Test
    public void testCreateAdmin() {
        Admin admin = new Admin();
        admin.setUsername("Ram");

        when(adminRepository.save(admin)).thenReturn(admin);

        Admin result = adminService.createAdmin(admin);

        assertNotNull(result);
        assertEquals("Ram", result.getUsername());
    }

    @Test
    public void testUpdateAdmin() {
        Admin existingAdmin = new Admin();
        existingAdmin.setAdminId(1);
        existingAdmin.setUsername("Existing Admin");

        Admin updatedAdmin = new Admin();
        updatedAdmin.setAdminId(1);
        updatedAdmin.setUsername("Updated Admin");

        when(adminRepository.existsById(1)).thenReturn(true);
        when(adminRepository.save(updatedAdmin)).thenReturn(updatedAdmin);

        Admin result = adminService.updateAdmin(1, updatedAdmin);

        assertNotNull(result);
        assertEquals("Updated Admin", result.getUsername());
    }

    @Test
    public void testUpdateAdmin_AdminNotFound() {
        Admin updatedAdmin = new Admin();
        updatedAdmin.setAdminId(1);
        updatedAdmin.setUsername("Updated Admin");

        when(adminRepository.existsById(1)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> adminService.updateAdmin(1, updatedAdmin));
    }

    @Test
    public void testDeleteAdmin() {
        Admin admin = new Admin();
        admin.setAdminId(1);
        admin.setUsername("Ram");

        when(adminRepository.existsById(1)).thenReturn(true);

        adminService.deleteAdmin(1);

        verify(adminRepository, times(1)).deleteById(1);
    }

    @Test
    public void testDeleteAdmin_AdminNotFound() {
        when(adminRepository.existsById(1)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> adminService.deleteAdmin(1));
    }
    
}

    

