package com.example.Schedule.service.interfaces;

import com.example.Schedule.model.University;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface AdminService {
    void CreateUniversity(University university);
    List<University> GetUniversity(Pageable pageable);
}
