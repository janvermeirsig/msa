package com.xebia.frontend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.*;

@Controller
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(){
        return "index.html";
    }

    @RequestMapping("/clerk/list")
    @CrossOrigin(origins = "http://localhost:*")
    @ResponseBody
    String listOfClerks() {
        logger.info(">>>> 8082 - clerk - List method");
        String json = "";

        List<Item> items = new ArrayList<Item>();
        Date date = new Date();
        items.add(new Item("1","clerk 1", "https://angularjs.org/", "Clerk 1 " + date));
        items.add(new Item("2","clerk 2", "https://spring.io/", "Clerk 2 " + date));
        json = itemsToJson(items);

        return json;
    }

    private String itemsToJson(List<Item> items) {
        String json = "[]";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            json = objectMapper.writeValueAsString(items);
            logger.info(json);
        }
        catch (JsonProcessingException ex){
            logger.error(ex.getMessage());
        }
        return json;
    }

}
