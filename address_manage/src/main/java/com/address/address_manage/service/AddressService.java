package com.address.address_manage.service;

import com.address.address_manage.mapper.AddressMapper;
import com.address.address_manage.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressMapper addressMapper;

    public List<Address> findCityById(Integer pid){

        return addressMapper.findCityById(pid);

    }

    public String getSheng(Integer shid) {
        return addressMapper.getSheng(shid);
    }

    public String getShi(Integer shId) {
        return addressMapper.getShi(shId);
    }

    public String getQu(Integer qId) {
        return addressMapper.getQu(qId);
    }

}
