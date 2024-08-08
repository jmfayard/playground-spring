package dev.jmfayard.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/1")
@RestController
public class HealthController {

    @RequestMapping("health")
    public @ResponseBody String greeting() {
        return "Hello, World!";
    }

}