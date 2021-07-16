package com.itcast.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResult {

    private String code;
    private Data1 data;
    private String status;
    private String serialNo;

}
