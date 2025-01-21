package com.example.quizzapplication;

import java.util.List;

import java.util.List;

public class Question {
    private final String questionText;
    private final String correctAnswer;
    private final List<String> options;
    private final String difficulty;
    private final int points;

    public Question(String questionText, String correctAnswer, List<String> options, String difficulty, int points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.options = options;
        this.difficulty = difficulty;
        this.points = points;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getPoints() {
        return points;
    }
}

