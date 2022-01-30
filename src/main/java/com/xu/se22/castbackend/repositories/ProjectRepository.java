package com.xu.se22.castbackend.repositories;

import com.xu.se22.castbackend.models.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
    @Query("SELECT COUNT(p) FROM projects p WHERE p.Department=?1")
    long countDepartment(String department);

    @Query("SELECT COUNT(p) FROM projects p WHERE p.Department=?1 AND p.account.AccountID = ?2")
    long countDepartmentByAccountId(String department, String accountId);
}
