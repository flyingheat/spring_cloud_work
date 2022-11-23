package com.address.address_manage.controller;

import com.address.address_manage.mapper.AddressMapper;
import com.address.address_manage.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {
    //ankle6868
    @Autowired
    private AddressMapper addressMapper;

    @GetMapping("/sheng/{pid}")
    @ResponseBody
    public String getShengAddress(@PathVariable Integer pid) {
        return addressMapper.getSheng(pid);
    }

    @GetMapping("/shi/{pid}")
    @ResponseBody
    public String getShiAddress(@PathVariable Integer pid) {

        System.out.println(pid);

        return addressMapper.getShi(pid);

    }

    @GetMapping("/qu/{pid}")
    @ResponseBody
    public String getQuAddress(@PathVariable Integer pid) {

        return addressMapper.getQu(pid);

    }

    @GetMapping("{pid}")
    @ResponseBody
    public List<Address> findCityById(@PathVariable Integer pid) {

        return addressMapper.findCityById(pid);

    }


}
