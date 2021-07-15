package com.itcast.pojo;

import lombok.Data;


@Data
public class Vip {

    private String vipid;
    private String vipname;
    private String phone;
    private String worktime;

    private Resume resume;

}
