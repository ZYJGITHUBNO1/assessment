package com.itcast.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("picturedata")
public class PictureData {

    @TableId(value = "policyNo")
    private String policyNo;
    @TableField("imageid")
    private String imageid;
    @TableField("companyname")
    private String companyname;
    @TableField("underWriteDate")
    private String underWriteDate;
    @TableField("premium")
    private String premium;


}
