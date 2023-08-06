package dev.afonso.springplayground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {
    @GetMapping("/")
    Map<String, Object> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("it_works", true);
        response.put("learn_more", "https://github.com/afonsodemori/spring-playground");
        response.put("created_by", "https://afonso.dev");
        return response;
    }
}
