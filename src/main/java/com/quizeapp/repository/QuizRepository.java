package com.quizeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizeapp.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {


}
