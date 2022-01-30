package com.xu.se22.castbackend.ressources;

import com.xu.se22.castbackend.models.Account;
import com.xu.se22.castbackend.repositories.AccountRepository;
import com.xu.se22.castbackend.repositories.ProjectRepository;
import com.xu.se22.castbackend.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/stats")
public class StatisticController {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private PublicationRepository publicationRepository;

    @GetMapping(path = "/projects")
    public @ResponseBody
    long getNumberOfProjectsOrByDepartment(@RequestParam(required = false) String department, @RequestParam(required = false) String accountId) {
        if(department == null)
            projectRepository.count();

        if(accountId == null)
            projectRepository.countDepartment(department);
        return projectRepository.countDepartmentByAccountId(department, accountId);
    }

    @GetMapping(path = "/publications")
    public @ResponseBody
    long getNumberOfPublications() {
        return publicationRepository.count();
    }

}
