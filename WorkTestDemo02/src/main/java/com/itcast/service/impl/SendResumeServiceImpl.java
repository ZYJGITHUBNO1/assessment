package com.itcast.service.impl;

import com.itcast.mapping.PositionMapping;
import com.itcast.mapping.ResumeMapping;
import com.itcast.mapping.SendResumeMapping;
import com.itcast.pojo.SendResume;
import com.itcast.service.SendResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SendResumeServiceImpl implements SendResumeService {

    @Autowired
    private SendResumeMapping sendresumeMapping;

    @Autowired
    private ResumeMapping resumeMapping;

    @Autowired
    private PositionMapping positionMapping;

    @Override
    public List<SendResume> findAll() {

        return sendresumeMapping.findAll();
    }

    @Override
    public SendResume findById(String id) {
        return sendresumeMapping.findById(id);
    }

    @Override
    public Boolean addSendresume(SendResume sendresume) {
        sendresumeMapping.addSendresume(sendresume);
        return true;
    }

    @Override
    public Boolean updateSendresume(SendResume sendresume) {
        sendresumeMapping.updateSendresume(sendresume);
        return true;
    }

    @Override
    public Boolean deleteSendresume(String id) {
        sendresumeMapping.deleteSendresume(id);
        return true;
    }

    @Override
    public int sendResume(String resid, String posid) {

        int result =1;   //0：没有投过简历  1：已经投过简历  2：该职位已经招满
        //判断简历是否已经投递过
        int num = sendresumeMapping.isSend(resid, posid);
        if(num ==0){

            //没有投过简历 判断职位是否已经招满
            //得到职位招聘的人数
            int posNum = sendresumeMapping.getPosNum(posid);
            //得到职位预计招聘的人数
            int recruitNum = positionMapping.getRecruitNum(posid);

            if(posNum >= recruitNum){
                //已经招聘满
                return 2;
            }


            //投递简历

            String vipId = resumeMapping.getVipId(resid);

            SendResume sendResume = new SendResume();
            sendResume.setResid(resid);
            sendResume.setPosid(posid);
            sendResume.setVipid(vipId);

            long time = System.currentTimeMillis();
            Date date = new Date(time);

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String dateDf = df.format(date);
            sendResume.setSendtime(dateDf);

            sendresumeMapping.addSendresume(sendResume);
            result=0;
        }

        return result;
    }

    /**
     * 修改面试结果
     *
     * @param senid
     * @param result
     * @return
     */
    @Override
    public Boolean updateResult(String senid, String result) {

        Boolean flag = true;

        try {
            sendresumeMapping.updateResult(senid, result);
        } catch (Exception e) {
            flag=false;
            e.printStackTrace();
        }

        return flag;
    }

}
