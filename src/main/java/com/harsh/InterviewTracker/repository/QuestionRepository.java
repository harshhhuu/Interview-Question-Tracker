package com.harsh.InterviewTracker.repository;

import com.harsh.InterviewTracker.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByCompany(String company);

    List<Question> findByTopic(String topic);

    List<Question> findByDifficulty(String difficulty);

    List<Question> findByStatus(String status);

    List<Question> findByTitleContainingIgnoreCase(String title);
}