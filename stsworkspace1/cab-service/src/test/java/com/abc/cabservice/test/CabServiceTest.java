package com.abc.cabservice.test;


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

import com.abc.cabservice.entity.Cab;
import com.abc.cabservice.exception.ResourceNotFoundException;
import com.abc.cabservice.model.CabResponse;
import com.abc.cabservice.model.Driver;
import com.abc.cabservice.repository.CabRepository;
import com.abc.cabservice.service.CabServiceImpl;
import com.abc.cabservice.service.DriverServiceClient;

public class CabServiceTest {

    @Mock
    private CabRepository cabRepository;

    @Mock
    private DriverServiceClient driverService;

    @InjectMocks
    private CabServiceImpl cabService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCab() {
        Cab cab = new Cab();
        cab.setCabId(1);
        cab.setCarType("SUV");
        cab.setRatePerKm(10);

        when(cabRepository.save(cab)).thenReturn(cab);

        Cab addedCab = cabService.addCab(cab);

        assertEquals(cab, addedCab);
    }

    @Test
    public void testUpdateCab() throws ResourceNotFoundException {
        Cab cab = new Cab();
        cab.setCabId(1);
        cab.setCarType("SUV");
        cab.setRatePerKm(10);

        when(cabRepository.findById(1)).thenReturn(Optional.of(cab));

        Cab updatedCab = cabService.updateCab(cab);

        assertNotNull(updatedCab);
        assertEquals(cab, updatedCab);
    }

    @Test
    public void testDeleteCab() {
        Cab cab = new Cab();
        cab.setCabId(1);

        when(cabRepository.findById(1)).thenReturn(Optional.of(cab));

        assertDoesNotThrow(() -> cabService.deleteCab(1));
    }

    @Test
    public void testGetAllCabs() {
        Cab cab1 = new Cab();
        cab1.setCabId(1);
        cab1.setCarType("SUV");
        cab1.setRatePerKm(10);
        cab1.setDriverId(101);

        List<Cab> cabList = new ArrayList<>();
        cabList.add(cab1);

        when(cabRepository.findAll()).thenReturn(cabList);

        Driver driver = new Driver();
        driver.setUsername("Rakesh");
        driver.setLicenseNo("ABCD1234");

        when(driverService.getDriverDetails(101)).thenReturn(driver);

        List<CabResponse> cabResponses = cabService.getAllCabs();

        assertNotNull(cabResponses);
        assertEquals(1, cabResponses.size());
        assertEquals(1, cabResponses.get(0).getCabId());
        assertEquals("SUV", cabResponses.get(0).getCarType());
        assertEquals(10.0, cabResponses.get(0).getRatePerKm());
        assertNotNull(cabResponses.get(0).getDriver());
        assertEquals(driver.getUsername(), cabResponses.get(0).getDriver().getUsername());
    }

    @Test
    public void testViewCabsOfType() throws ResourceNotFoundException {
       
        String carType = "SUV";
        List<String> suvCabs = new ArrayList<>();
        suvCabs.add("SUV Cab 1");
        suvCabs.add("SUV Cab 2");

        when(cabRepository.viewCarType(carType)).thenReturn(suvCabs);

        List<String> result = cabService.viewCabsOfType(carType);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("SUV Cab 1"));
        assertTrue(result.contains("SUV Cab 2"));
    }

    @Test
    public void testCountCabsOfType() throws ResourceNotFoundException {
        
        List<Cab> cabList = new ArrayList<>();
        cabList.add(new Cab());
        cabList.add(new Cab());
        cabList.add(new Cab());

        when(cabRepository.findAll()).thenReturn(cabList);

        int result = cabService.countCabsOfType();
        assertEquals(3, result);
    }
}

