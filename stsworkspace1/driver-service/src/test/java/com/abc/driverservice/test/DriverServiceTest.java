package com.abc.driverservice.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.abc.driverservice.entity.Address;
import com.abc.driverservice.entity.Driver;
import com.abc.driverservice.exception.NotValidId;
import com.abc.driverservice.exception.ResourceNotFoundException;
import com.abc.driverservice.repository.AddressRepository;
import com.abc.driverservice.repository.DriverRepository;
import com.abc.driverservice.service.DriverServiceImpl;

public class DriverServiceTest {

    @Mock
    private DriverRepository driverRepository;

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private DriverServiceImpl driverService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInsertDriver() {
        Driver driver = new Driver();
        driver.setUserId(1);
        driver.setUsername("Rakesh");

        when(driverRepository.save(driver)).thenReturn(driver);

        Driver insertedDriver = driverService.insertDriver(driver);

        assertNotNull(insertedDriver);
        assertEquals(driver.getUserId(), insertedDriver.getUserId());
        assertEquals(driver.getUsername(), insertedDriver.getUsername());
    }

    @Test
    public void testViewDriverById() throws NotValidId {
        int driverId = 1;
        Driver driver = new Driver();
        driver.setUserId(driverId);
        driver.setUsername("Rakesh");

        when(driverRepository.findById(driverId)).thenReturn(Optional.of(driver));

        Driver viewedDriver = driverService.viewDriverById(driverId);

        assertNotNull(viewedDriver);
        assertEquals(driver.getUserId(), viewedDriver.getUserId());
        assertEquals(driver.getUsername(), viewedDriver.getUsername());
    }
    @Test
    public void testUpdateDriver() throws ResourceNotFoundException {
        int driverId = 1;
        Driver driver = new Driver();
        driver.setUserId(driverId);
        driver.setUsername("Rakesh");

        when(driverRepository.findById(driverId)).thenReturn(Optional.of(driver));
        when(driverRepository.save(driver)).thenReturn(driver);

        Driver updatedDriver = driverService.updateDriver(driver);

        assertNotNull(updatedDriver);
        assertEquals(driver.getUserId(), updatedDriver.getUserId());
        assertEquals(driver.getUsername(), updatedDriver.getUsername());
    }

    @Test
    public void testDeleteDriverById() throws ResourceNotFoundException {
        int driverId = 1;
        Driver driver = new Driver();
        driver.setUserId(driverId);
        driver.setUsername("Rakesh");

        Address address = new Address();
        driver.setAddress(address);

        when(driverRepository.findById(driverId)).thenReturn(Optional.of(driver));

        assertDoesNotThrow(() -> driverService.deleteDriverById(driverId));

        verify(driverRepository, times(1)).delete(driver);
        verify(addressRepository, times(1)).delete(address);
    }

    @Test
    public void testGetAllDrivers() {
        List<Driver> driverList = new ArrayList<>();
        driverList.add(new Driver());
        driverList.add(new Driver());
        driverList.add(new Driver());

        when(driverRepository.findAll()).thenReturn(driverList);

        List<Driver> retrievedDrivers = driverService.getAllDrivers();

        assertNotNull(retrievedDrivers);
        assertEquals(3, retrievedDrivers.size());
    }
}
