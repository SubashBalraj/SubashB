package com.abc.adminservice.service;


import com.abc.adminservice.model.CabDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "cab-service")
public interface CabServiceClient {

    @GetMapping("/cab/all")
    List<CabDetails> getAllCabDetails();
}
