package com.example.demo.generator.controller;

import com.example.demo.generator.model.Sentence;
import com.example.demo.generator.service.GenerateSentenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/list")
public class SentenceController {

    private final GenerateSentenceService generateSentenceService;

    public SentenceController(GenerateSentenceService generateSentenceService) {
        this.generateSentenceService = generateSentenceService;
    }

    @GetMapping("/sentence")
        public ResponseEntity<Sentence> showSentences(){
        Sentence sentence = new Sentence(generateSentenceService.makeSentences());
        return ResponseEntity.ok(sentence);
    }

}
