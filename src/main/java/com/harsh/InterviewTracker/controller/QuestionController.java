package com.harsh.InterviewTracker.controller;

import com.harsh.InterviewTracker.entity.Question;
import com.harsh.InterviewTracker.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService service;

    // Add Question
    @PostMapping
    public Question addQuestion(@RequestBody Question question) {
        return service.addQuestion(question);
    }

    // Get All Questions
    @GetMapping
    public List<Question> getAllQuestions() {
        return service.getAllQuestions();
    }

    // Get Question by ID
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return service.getQuestionById(id);
    }

    // Update Question
    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable Long id,
                                   @RequestBody Question question) {
        return service.updateQuestion(id, question);
    }

    // Delete Question
    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        service.deleteQuestion(id);
        return "Question deleted successfully.";
    }

    // Search by Company
    @GetMapping("/company/{company}")
    public List<Question> getByCompany(@PathVariable String company) {
        return service.getQuestionsByCompany(company);
    }

    // Search by Topic
    @GetMapping("/topic/{topic}")
    public List<Question> getByTopic(@PathVariable String topic) {
        return service.getQuestionsByTopic(topic);
    }

    // Search by Difficulty
    @GetMapping("/difficulty/{difficulty}")
    public List<Question> getByDifficulty(@PathVariable String difficulty) {
        return service.getQuestionsByDifficulty(difficulty);
    }

    // Search by Status
    @GetMapping("/status/{status}")
    public List<Question> getByStatus(@PathVariable String status) {
        return service.getQuestionsByStatus(status);
    }
}