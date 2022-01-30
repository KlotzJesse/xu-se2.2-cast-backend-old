package com.xu.se22.castbackend.ressources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xu.se22.castbackend.models.Account;
import com.xu.se22.castbackend.models.Handin;
import com.xu.se22.castbackend.repositories.AccountRepository;
import com.xu.se22.castbackend.repositories.HandinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/handins")
public class HandinController {
    @Autowired

    private HandinRepository handinRepository;

    @GetMapping
    public @ResponseBody
    Iterable<Handin> getAllHandins() {
        return handinRepository.findAll();
    }

    @GetMapping("/last")
    public @ResponseBody
    Object getLastHandins(@RequestParam() Integer accountId) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode result = mapper.createObjectNode();

        String[] latestProjectHandIn = handinRepository.findLatestProjectHandIn(accountId);
        String[] latestPublicationHandIn = handinRepository.findLatestPublicationHandIn(accountId);

        if(latestProjectHandIn.length > 0) {
            latestProjectHandIn = latestProjectHandIn[0].split(",");

            ObjectNode project = mapper.createObjectNode();
            project.put("name", latestProjectHandIn[1]);
            project.put("handinDate", latestProjectHandIn[0]);

            result.set("project", project);
        }

        if(latestPublicationHandIn.length > 0) {
            latestPublicationHandIn = latestPublicationHandIn[0].split(",");
            ObjectNode publication = mapper.createObjectNode();
            publication.put("name", latestPublicationHandIn[1]);
            publication.put("handinDate", latestPublicationHandIn[0]);

            result.set("publication", publication);
        }

        return result;
    }

}
