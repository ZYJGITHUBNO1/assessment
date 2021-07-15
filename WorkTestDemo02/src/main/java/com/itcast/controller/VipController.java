package com.itcast.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.pojo.UploadVip;
import com.itcast.pojo.Vip;
import com.itcast.service.impl.VipServiceImpl;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("vip")
public class VipController {

    @Autowired
    private VipServiceImpl vipService;

    @PostMapping("findAll")
    public ResponseEntity<PageInfo> findAll(){
        PageInfo allList = vipService.findAll();
        if(allList != null){
            return ResponseEntity.ok(allList);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("findById")
    public ResponseEntity<Vip> findById(@RequestBody Map<String,String> map){
        Vip vip = vipService.findById(map.get("vipid"));
        if(vip != null){
            return ResponseEntity.ok(vip);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("add")
    public ResponseEntity<Boolean> addVip(@RequestBody Vip vip){
        Boolean aBoolean = vipService.addVip(vip);
        return ResponseEntity.ok(aBoolean);
    }

    @PostMapping("update")
    public ResponseEntity<Boolean> updateVip(@RequestBody Vip vip){
        Boolean aBoolean = vipService.updateVip(vip);
        return ResponseEntity.ok(aBoolean);
    }

    @PostMapping("delete")
    public ResponseEntity<Boolean> deleteVip(@RequestBody Map<String,String> map){
        Boolean aBoolean = vipService.deleteVip(map.get("vipid"));
        return ResponseEntity.ok(aBoolean);
    }

    /**
     * 导出数据
     * @param response
     * @return
     */
    @GetMapping("upload")
    public void uploadData(HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("会员信息表");
        List<UploadVip> list = vipService.upload();

        //定义文件名
        String filename="Vip"+".xls";

        int rowNum=1;
        String [] header={"会员编号","会员姓名","电话","工作年限","公司编号","公司名称","公司规模","地址","行业"};
        HSSFRow row = sheet.createRow(0);

        //添加表格头信息
        for (int i = 0; i < header.length; i++) {
            HSSFCell cell = row.createCell((short) i);
            HSSFRichTextString textString = new HSSFRichTextString(header[i]);
            cell.setCellValue(textString);
        }

        for (UploadVip uploadVip : list) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(new HSSFRichTextString(uploadVip.getVipid()));
            row1.createCell(1).setCellValue(new HSSFRichTextString(uploadVip.getVipname()));
            row1.createCell(2).setCellValue(new HSSFRichTextString(uploadVip.getPhone()));
            row1.createCell(3).setCellValue(new HSSFRichTextString(uploadVip.getWorktime()));
            row1.createCell(4).setCellValue(new HSSFRichTextString(uploadVip.getComid()));
            row1.createCell(5).setCellValue(new HSSFRichTextString(uploadVip.getComname()));
            row1.createCell(6).setCellValue(new HSSFRichTextString(uploadVip.getCommodel()));
            row1.createCell(7).setCellValue(new HSSFRichTextString(uploadVip.getAddress()));
            row1.createCell(8).setCellValue(new HSSFRichTextString(uploadVip.getIndustry()));
            rowNum++;
        }

        response.setContentType("application/oct-steam");
        response.setHeader("Content-disposition","attachment;filename="+filename);
        response.flushBuffer();
        workbook.write(response.getOutputStream());

    }

}
