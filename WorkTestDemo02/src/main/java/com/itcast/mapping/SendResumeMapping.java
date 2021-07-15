package com.itcast.mapping;

import com.itcast.pojo.SendResume;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SendResumeMapping {
    List<SendResume> findAll();

    SendResume findById(String id);

    void addSendresume(SendResume sendresume);

    void updateSendresume(SendResume sendresume);

    void deleteSendresume(String id);

    int isSend(@Param("resid") String resid, @Param("posid") String posid);

    /**
     * 修改面试结果
     * @param senid
     * @param result
     * @return
     */
    void updateResult(@Param("senid") String senid,@Param("result") String result);

    /**
     * 得到职位招聘的人数
     * @param posid
     * @return
     */
    int getPosNum(String posid);
}
