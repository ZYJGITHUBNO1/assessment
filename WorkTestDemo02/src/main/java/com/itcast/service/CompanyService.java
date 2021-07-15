package com.itcast.service;

import com.github.pagehelper.PageInfo;
import com.itcast.pojo.Company;
import com.itcast.pojo.Vip;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    Company findById(String id);

    Boolean addCompany(Company company);

    Boolean updateCompany(Company company);

    Boolean deleteCompany(String id);

    PageInfo getVipAndResume(String comname, String posname, String pageNum, String pageSize);

}
