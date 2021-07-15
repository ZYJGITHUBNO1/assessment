package com.itcast.service;

import com.itcast.pojo.Resume;

import java.util.List;

public interface ResumeService {

    List<Resume> findAll();

    Resume findById(String id);

    Boolean addResume(Resume resume);

    Boolean updateResume(Resume resume);

    Boolean deleteResume(String id);
}
