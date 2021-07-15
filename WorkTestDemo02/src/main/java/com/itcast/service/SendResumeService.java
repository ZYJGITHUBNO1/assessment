package com.itcast.service;

import com.itcast.pojo.SendResume;

import java.util.List;

public interface SendResumeService {

    List<SendResume> findAll();

    SendResume findById(String id);

    Boolean addSendresume(SendResume sendresume);

    Boolean updateSendresume(SendResume sendresume);

    Boolean deleteSendresume(String id);

    int sendResume(String resid, String posid);

    Boolean updateResult(String senid, String result);
}
