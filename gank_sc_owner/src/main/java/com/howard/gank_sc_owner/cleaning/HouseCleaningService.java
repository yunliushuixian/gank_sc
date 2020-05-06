package com.howard.gank_sc_owner.cleaning;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "property-company-service")
public interface HouseCleaningService {
    @PostMapping(path = "/cleaning", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void submitClean(@RequestBody String msg);
}
