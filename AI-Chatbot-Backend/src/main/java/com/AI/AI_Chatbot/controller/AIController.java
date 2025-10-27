package com.AI.AI_Chatbot.controller;
import java.util.Map;


import com.AI.AI_Chatbot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AIController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/get")
    public ResponseEntity<String> askQuestion(@RequestBody Map<String, String> payload)
    {
        String question=payload.get("question");
        String answer=questionService.getAnswer(question);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }


    @GetMapping("/hello")
    public ResponseEntity<String> printing()
    {
        return new ResponseEntity<>("Hello",HttpStatus.OK);
    }
}
