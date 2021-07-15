package com.itcast.mapping;

import com.itcast.pojo.Resume;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ResumeMapping {
    List<Resume> findAll();

    Resume findById(String id);

    void addResume(Resume resume);

    void updateResume(Resume resume);

    void deleteResume(String id);

    /**
     * 获取简历上的会员号
     * @param resid
     * @return
     */
    String getVipId(String resid);
}
