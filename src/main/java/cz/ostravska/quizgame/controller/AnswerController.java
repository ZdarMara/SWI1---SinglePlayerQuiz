package cz.ostravska.quizgame.controller;

import cz.ostravska.quizgame.model.UserAnswer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @PostMapping("/submit")
    public ResponseEntity<String> submitAnswer(@RequestBody UserAnswer userAnswer) {
        // Prozatím jen odpověz, že data byla přijata:
        return ResponseEntity.ok("Odpověď přijata: " + userAnswer.getDirection());

    }
}
