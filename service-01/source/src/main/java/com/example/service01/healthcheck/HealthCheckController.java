package com.example.service01.healthcheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
        @GetMapping("/healthcheck")
        public String healthCheck() {
            return "Service is healthy";
        }
}
