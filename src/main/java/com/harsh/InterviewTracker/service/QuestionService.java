package com.harsh.InterviewTracker.service;

import com.harsh.InterviewTracker.entity.Question;

import java.util.List;

public interface QuestionService {

    Question addQuestion(Question question);

    List<Question> getAllQuestions();

    Question getQuestionById(Long id);

    Question updateQuestion(Long id, Question question);

    void deleteQuestion(Long id);

    List<Question> getQuestionsByCompany(String company);

    List<Question> getQuestionsByTopic(String topic);

    List<Question> getQuestionsByDifficulty(String difficulty);

    List<Question> getQuestionsByStatus(String status);
}