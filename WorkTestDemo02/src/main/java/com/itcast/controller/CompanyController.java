package com.itcast.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.pojo.Company;
import com.itcast.pojo.Vip;
import com.itcast.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @PostMapping("findAll")
    public ResponseEntity<List<Company>> findAll(){
        List<Company> allList = companyService.findAll();
        if(allList != null){
            return ResponseEntity.ok(allList);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("findById")
    public ResponseEntity<Company> findById(@RequestBody Map<String,String> map){
        Company company = companyService.findById(map.get("comid"));
        if(company != null){
            return ResponseEntity.ok(company);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("add")
    public ResponseEntity<Boolean> addCompany(@RequestBody Company company){
        Boolean aBoolean = companyService.addCompany(company);
        return ResponseEntity.ok(aBoolean);
    }

    @PostMapping("update")
    public ResponseEntity<Boolean> updateCompany(@RequestBody Company company){
        Boolean aBoolean = companyService.updateCompany(company);
        return ResponseEntity.ok(aBoolean);
    }

    @PostMapping("delete")
    public ResponseEntity<Boolean> deleteCompany(@RequestBody Map<String,String> map){
        Boolean aBoolean = companyService.deleteCompany(map.get("comid"));
        return ResponseEntity.ok(aBoolean);
    }

    /**
     * 通过公司名称和职位名称获取会员信息和简历信息
     * @param map
     * @return
     */
    @PostMapping("getVipAndResume")
    public ResponseEntity<PageInfo> getVipAndResume(@RequestBody Map<String,String> map){
        String comname = map.get("comname");
        String posname = map.get("posname");
        String pageNum = map.get("pageNum");
        String pageSize = map.get("pageSize");

        PageInfo pageInfo = companyService.getVipAndResume(comname,posname,pageNum,pageSize);

        if(pageInfo != null){
            return ResponseEntity.ok(pageInfo);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
