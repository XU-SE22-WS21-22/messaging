package com.example.messaging.repository;

import com.example.messaging.dto.Projects;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectsRepository extends CrudRepository<Projects, Long> {
    List<Projects> findAllByProjectName(String projectName);

    Projects findByPartnerID(Long ProjectID);
}
