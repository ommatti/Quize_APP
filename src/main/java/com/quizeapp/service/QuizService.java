package com.quizeapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.quizeapp.entity.Question;
import com.quizeapp.entity.Quiz;
import com.quizeapp.repository.QuestionRepository;
import com.quizeapp.repository.QuizRepository;

@Service
public class QuizService {

    private QuizRepository quizRepository;
    private QuestionRepository questionRepository;

    public QuizService(QuizRepository quizRepository, QuestionRepository questionRepository) {
        super();
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    // Create Quiz By Category, Number of Questions and Title
    public Quiz createQuiz(String category, int noOfQuestions, String title) {

        // Fetch all questions by category
        List<Question> allQuestions = questionRepository.findByCategory(category);

        if (allQuestions.isEmpty()) {
            throw new RuntimeException("No Questions Found for Category: " + category);
        }

        if (noOfQuestions > allQuestions.size()) {
            throw new RuntimeException("Only " + allQuestions.size() 
                + " Questions Available for Category: " + category);
        }

        // Pick random questions
        List<Question> selectedQuestions = new ArrayList<>();
        Random random = new Random();

        while (selectedQuestions.size() < noOfQuestions) {
            int randomIndex = random.nextInt(allQuestions.size());
            Question randomQuestion = allQuestions.get(randomIndex);

            if (!selectedQuestions.contains(randomQuestion)) {
                selectedQuestions.add(randomQuestion);
            }
        }

        // Create and Save Quiz
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(selectedQuestions);

        return quizRepository.save(quiz);
    }
}
