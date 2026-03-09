package com.quizeapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.quizeapp.dto.QuestionDto;
import com.quizeapp.entity.Question;
import com.quizeapp.repository.QuestionRepository;

@Service
public class QuestionService {

	private QuestionRepository repository;

	private ModelMapper modelMapper;

	public QuestionService(QuestionRepository repository, ModelMapper modelMapper) {
		super();
		this.repository = repository;
		this.modelMapper = modelMapper;

	}

	// Save Question
	public QuestionDto saveQuestion(QuestionDto questionDto) {
	    Question question = modelMapper.map(questionDto, Question.class);
	    Question savedQuestion = repository.save(question);
	    return modelMapper.map(savedQuestion, QuestionDto.class);
	}

	// Get All Questions
	public List<Question> getAllQuestion() {
	    return repository.findAll();
	}

	// Get Questions By Difficulty
	public List<Question> getQuestionByDifficulty(String level) {
	    return repository.findByDifficaltyLevel(level);
	}

	// Delete Question By Id
	public void deleteQuestion(Long id) {
	    repository.deleteById(id);
	}

	// Update Question By Id
	public QuestionDto updateQuestion(Long id, QuestionDto questionDto) {
	    Question existingQuestion = repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));

	    existingQuestion.setQuestionTitle(questionDto.getQuestionTitle());
	    existingQuestion.setOption1(questionDto.getOption1());
	    existingQuestion.setOption2(questionDto.getOption2());
	    existingQuestion.setOption3(questionDto.getOption3());
	    existingQuestion.setOption4(questionDto.getOption4());
	    existingQuestion.setRightAnswer(questionDto.getRightAnswer());
	    existingQuestion.setDifficaltyLevel(questionDto.getDifficaltyLevel());
	    existingQuestion.setCategory(questionDto.getCategory());

	    Question updatedQuestion = repository.save(existingQuestion);
	    return modelMapper.map(updatedQuestion, QuestionDto.class);
	}
}
