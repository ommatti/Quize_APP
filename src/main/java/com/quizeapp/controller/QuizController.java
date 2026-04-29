package com.quizeapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quizeapp.dto.APIResponse;
import com.quizeapp.dto.QuizeQuestionDto;
import com.quizeapp.entity.Quiz;
import com.quizeapp.service.QuizService;

@RestController
@RequestMapping("/api/v1/quize")
public class QuizController {

	private QuizService quizService;

	public QuizController(QuizService quizService) {
		super();
		this.quizService = quizService;
	}


	// Create Quiz]
	@PostMapping("/create")
	public ResponseEntity<APIResponse<Quiz>> createQuiz(@RequestParam String category, @RequestParam int noOfQuestions,
			@RequestParam String title) {

		Quiz quiz = quizService.createQuiz(category, noOfQuestions, title);

		APIResponse<Quiz> response = new APIResponse();

		response.setMessage("Quiz Created Successfully with Title: " + quiz.getTitle() + " | Total Questions: "
				+ quiz.getQuestions().size());
		response.setStatus("SUCCESS");
		response.setStatusCode(HttpStatus.CREATED.value()); // 201
		response.setTimeStamp(new Date());
		response.setData(quiz);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// Fetch
	@GetMapping("get/{id}")
	public ResponseEntity<APIResponse<List<QuizeQuestionDto>>> getQuizeQuestions(@PathVariable Long id) {

		List<QuizeQuestionDto> quizeQuestion = quizService.getQuizeQuestion(id);

		APIResponse<List<QuizeQuestionDto>> response = new APIResponse<>();

		response.setMessage("Questions fetched for Quiz Id: " + id + " | Total Questions: " + quizeQuestion.size());

		response.setStatus("SUCCESS");
		response.setStatusCode(HttpStatus.OK.value()); // ✅ 200 (not 201)
		response.setTimeStamp(new Date());
		response.setData(quizeQuestion); // ✅ correct data

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
