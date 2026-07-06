package com.harsh.InterviewTracker.service;

import com.harsh.InterviewTracker.entity.Question;
import com.harsh.InterviewTracker.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository repository;

    @Override
    public Question addQuestion(Question question) {
        question.setCreatedAt(LocalDate.now());
        question.setRevisionCount(0);
        return repository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return repository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Question updateQuestion(Long id, Question question) {

        Question existing = repository.findById(id).orElse(null);

        if (existing != null) {

            existing.setTitle(question.getTitle());
            existing.setTopic(question.getTopic());
            existing.setDifficulty(question.getDifficulty());
            existing.setCompany(question.getCompany());
            existing.setStatus(question.getStatus());
            existing.setNotes(question.getNotes());

            return repository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteQuestion(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Question> getQuestionsByCompany(String company) {
        return repository.findByCompany(company);
    }

    @Override
    public List<Question> getQuestionsByTopic(String topic) {
        return repository.findByTopic(topic);
    }

    @Override
    public List<Question> getQuestionsByDifficulty(String difficulty) {
        return repository.findByDifficulty(difficulty);
    }

    @Override
    public List<Question> getQuestionsByStatus(String status) {
        return repository.findByStatus(status);
    }
}