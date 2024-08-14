package com.example.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    private static final Logger log = LoggerFactory.getLogger(DemoService.class);

    public void performAction(String value) {
        log.info("Performing action in DemoService...");
        try {
            // Simulating some business logic
            log.trace("Your log - {}", value);
            Thread.sleep(1000);
            log.info("Action performed successfully.");
        } catch (InterruptedException e) {
            log.error("An error occurred while performing the action.", e);
        }
    }
}

