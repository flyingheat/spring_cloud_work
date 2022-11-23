package com.address.address_manage.mapper;

import com.address.address_manage.pojo.Address;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.util.List;

@Repository
public interface AddressMapper {

    @Select("select * from city where pid = #{pid}")
    List<Address> findCityById(Integer pid);
    @Select("select cname from city where id = #{shid}")
    String getSheng(Integer shid);
    @Select("select cname from city where id = #{shId}")
    String getShi(Integer shId);
    @Select(" select cname from city where id = #{qid}")
    String getQu(Integer qId);

}
