package com.revature.quizzard.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

/*
 * This RootController dictates what view will be displayed upon start up
 * You can find this view after running the app > go to http://localhost:5000
 */
@Controller	
public class RootController {

    @GetMapping
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public RedirectView redirectToApiDocumentation() {
        return new RedirectView("swagger-ui/index.html"); 
        
        /*
         * To automatically load up the Swagger documentation:
         * return new RedirectView("swagger-ui/index.html");
         * 
         * To redirect to a an html page within src/main/resources/static
         * return new RedirectView("index.html");
         * 
         * See com.revature.quizzard.config.SwaggerConfig.java for base package scan details.
         */
    }

}
