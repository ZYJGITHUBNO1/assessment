package com.itcast.service.impl;

import com.itcast.mapping.ResumeMapping;
import com.itcast.pojo.Resume;
import com.itcast.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeMapping resumeMapping;

    @Override
    public List<Resume> findAll() {

        return resumeMapping.findAll();
    }

    @Override
    public Resume findById(String id) {
        return resumeMapping.findById(id);
    }

    @Override
    public Boolean addResume(Resume resume) {
        resumeMapping.addResume(resume);
        return true;
    }

    @Override
    public Boolean updateResume(Resume resume) {
        resumeMapping.updateResume(resume);
        return true;
    }

    @Override
    public Boolean deleteResume(String id) {
        resumeMapping.deleteResume(id);
        return true;
    }
}
