package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itcast.mapping.CompanyMapping;
import com.itcast.pojo.Company;
import com.itcast.pojo.Vip;
import com.itcast.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapping companyMapping;

    @Override
    public List<Company> findAll() {

        return companyMapping.findAll();
    }

    @Override
    public Company findById(String id) {
        return companyMapping.findById(id);
    }

    @Override
    public Boolean addCompany(Company company) {
        companyMapping.addCompany(company);
        return true;
    }

    @Override
    public Boolean updateCompany(Company company) {
        companyMapping.updateCompany(company);
        return true;
    }

    @Override
    public Boolean deleteCompany(String id) {
        companyMapping.deleteCompany(id);
        return true;
    }

    /**
     * 根据公司名称和职位名称获取会员信息和简历信息
     * @param comname
     * @param posname
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo getVipAndResume(String comname, String posname, String pageNum, String pageSize) {

        Integer pagenum = Integer.valueOf(pageNum);
        Integer pagesize = Integer.valueOf(pageSize);

        PageHelper.startPage(pagenum,pagesize);

        List<Vip> vipAndResume = companyMapping.getVipAndResume(comname, posname);

        PageInfo pageInfo = new PageInfo(vipAndResume);

        return pageInfo;
    }

}
