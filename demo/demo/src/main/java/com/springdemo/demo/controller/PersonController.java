package com.springdemo.demo.controller;


import com.springdemo.demo.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
    public class PersonController {
    private static final Logger LOG = LogManager.getLogger(Log4J2Controller.class);

        @ModelAttribute("person") // Pre-populate form object
        public Person person() {
            return new Person();
        }

        @GetMapping("/")
        public String showForm(Model model) {
            model.addAttribute("person", person()); // Add pre-populated object
            //return "person_form"; // Name of Thymeleaf template
            System.out.println("IN person");
            LOG.debug("Debugging log in our greeting method");
            LOG.info("Info log in our greeting method");
            LOG.warn("Warning log in our greeting method");
            //LOG.error("Error in our greeting method");
            return "Hello!!!";
        }

        @PostMapping("/")
        public String submitForm(@ModelAttribute Person person, Model model) {
            // Process submitted data, save if needed
            model.addAttribute("submittedPerson", person); // Add submitted object
            return "person_display"; // Name of Thymeleaf template with display
        }
    }

