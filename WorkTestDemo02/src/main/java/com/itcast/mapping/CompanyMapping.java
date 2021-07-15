package com.itcast.mapping;

import com.itcast.pojo.Company;
import com.itcast.pojo.Vip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompanyMapping {
    List<Company> findAll();

    Company findById(String id);

    void addCompany(Company company);

    void updateCompany(Company company);

    void deleteCompany(String id);

    List<Vip> getVipAndResume(@Param("comname") String comname,@Param("posname") String posname);

}
