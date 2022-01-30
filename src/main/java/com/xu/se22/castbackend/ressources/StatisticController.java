package com.xu.se22.castbackend.ressources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.xu.se22.castbackend.models.Account;
import com.xu.se22.castbackend.models.Handin;
import com.xu.se22.castbackend.repositories.AccountRepository;
import com.xu.se22.castbackend.repositories.HandinRepository;
import com.xu.se22.castbackend.repositories.ProjectRepository;
import com.xu.se22.castbackend.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;

@Controller
@RequestMapping(path = "/stats")
public class StatisticController {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private PublicationRepository publicationRepository;
    @Autowired
    private HandinRepository handinRepository;

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

    @GetMapping(path = "/success")
    public @ResponseBody
    Object getSuccesStats() {

        String[] projects = handinRepository.findHandInsFroProjects();
        int projectsCounter = 0;
        int projectsSum = 0;

        if(projects.length > 0 ) {
            for (String parse : projects) {
                String[] data = parse.split(",");
                Integer id = Integer.valueOf(data[0]);

                LocalDate date = LocalDate.parse(data[1]);
                LocalDate today = LocalDate.now();

                if(date.isBefore(today.minusMonths(2))) {
                    projectsCounter++;
                }
                projectsSum++;
            }
        }

        String[] publications = handinRepository.findHandInsFromPublication();
        int publicationsCounter = 0;
        int publicationsSum = 0;

        if(publications.length > 0 ) {
            for (String parse : publications) {
                String[] data = parse.split(",");
                Integer id = Integer.valueOf(data[0]);

                LocalDate date = LocalDate.parse(data[1]);
                LocalDate today = LocalDate.now();

                if(date.isBefore(today.minusMonths(2))) {
                    publicationsCounter++;
                }
                publicationsSum++;
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode result = mapper.createObjectNode();

        result.put("publications", publicationsCounter);
        result.put("projects", projectsCounter);
        result.put("publicationsSum", publicationsSum);
        result.put("projectsSum", projectsSum);
        return result;
    }

}
