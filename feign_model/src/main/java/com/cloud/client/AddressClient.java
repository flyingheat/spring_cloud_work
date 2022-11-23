package com.cloud.client;

import com.cloud.config.FeignClientConfiguration;
import com.cloud.pojo.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value="addressServer",configuration= FeignClientConfiguration.class)
public interface AddressClient {

    @GetMapping("/address/sheng/{pid}")
    String getShengAddress(@PathVariable Integer pid);

    @GetMapping("/address/shi/{pid}")
    String getShiAddress(@PathVariable Integer pid);

    @GetMapping("/address/qu/{pid}")
    String getQuAddress(@PathVariable Integer pid);

    @GetMapping("/address/{pid}")
    List<Address> findCityById(@PathVariable Integer pid);

}
