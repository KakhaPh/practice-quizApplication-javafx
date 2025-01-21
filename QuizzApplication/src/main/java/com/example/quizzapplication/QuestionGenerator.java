package com.example.quizzapplication;


import java.util.ArrayList;
import java.util.List;

public class QuestionGenerator {
    public List<Question> generateQuestions() {
        List<Question> questions = new ArrayList<>();

        // Easy questions
        questions.add(new Question("What is the capital of France?", "Paris", List.of("Paris", "London", "Berlin", "Madrid"), "easy", 1));
        questions.add(new Question("What is 5 + 3?", "8", List.of("6", "7", "8", "9"), "easy", 1));
        questions.add(new Question("What is the largest ocean?", "Pacific Ocean", List.of("Atlantic Ocean", "Indian Ocean", "Pacific Ocean", "Arctic Ocean"), "easy", 1));
        questions.add(new Question("What is 12 x 12?", "144", List.of("144", "121", "132", "156"), "easy", 1));

        // Medium questions
        questions.add(new Question("What is the square root of 144?", "12", List.of("12", "14", "16", "18"), "medium", 2));
        questions.add(new Question("Who painted the Mona Lisa?", "Leonardo da Vinci", List.of("Van Gogh", "Leonardo da Vinci", "Picasso", "Michelangelo"), "medium", 2));
        questions.add(new Question("Which planet has the most moons?", "Saturn", List.of("Earth", "Mars", "Jupiter", "Saturn"), "medium", 2));

        // Hard questions
        questions.add(new Question("What is the speed of light?", "299792458", List.of("300000000", "150000000", "299792458", "299000000"), "hard", 3));
        questions.add(new Question("Who developed the theory of relativity?", "Einstein", List.of("Newton", "Einstein", "Galileo", "Tesla"), "hard", 3));

        return questions;
    }
}
