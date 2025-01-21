package com.example.quizzapplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class Main extends Application {
    private List<Question> questions;

    @Override
    public void start(Stage primaryStage) {
        QuestionGenerator questionGenerator = new QuestionGenerator();
        questions = questionGenerator.generateQuestions();

        Collections.shuffle(questions);
        AtomicReference<List<Question>> selectedQuestions = new AtomicReference<>(questions.subList(0, 5));

        final int[] currentQuestionIndex = {0};
        final int[] totalScore = {0};

        Label questionLabel = new Label();
        questionLabel.getStyleClass().add("question-label");

        Button option1 = new Button();
        Button option2 = new Button();
        Button option3 = new Button();
        Button option4 = new Button();
        option1.getStyleClass().add("option-button");
        option2.getStyleClass().add("option-button");
        option3.getStyleClass().add("option-button");
        option4.getStyleClass().add("option-button");

        Label feedbackLabel = new Label();
        Label scoreLabel = new Label("Score: 0");
        scoreLabel.getStyleClass().add("score-label");

        Button nextButton = new Button("Next");
        nextButton.getStyleClass().add("next-button");
        nextButton.setDisable(true);

        Button restartButton = new Button("Restart Game");
        restartButton.getStyleClass().add("next-button");
        restartButton.setVisible(false);

        VBox layout = new VBox(10);
        layout.getStyleClass().add("root");
        layout.getChildren().addAll(questionLabel, option1, option2, option3, option4, feedbackLabel, scoreLabel, nextButton, restartButton);

        Scene scene = new Scene(layout, 400, 400);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cool Quiz Application");
        primaryStage.show();

        loadQuestion(selectedQuestions.get().get(currentQuestionIndex[0]), questionLabel, List.of(option1, option2, option3, option4), feedbackLabel, totalScore, scoreLabel, nextButton);

        nextButton.setOnAction(_ -> {
            currentQuestionIndex[0]++;
            feedbackLabel.setText("");
            nextButton.setDisable(true);

            if (currentQuestionIndex[0] < selectedQuestions.get().size()) {
                loadQuestion(selectedQuestions.get().get(currentQuestionIndex[0]), questionLabel, List.of(option1, option2, option3, option4), feedbackLabel, totalScore, scoreLabel, nextButton);
            } else {
                questionLabel.setText("Quiz Over! Your final score is: " + totalScore[0]);
                layout.getChildren().removeAll(option1, option2, option3, option4, nextButton);
                restartButton.setVisible(true);
            }
        });

        restartButton.setOnAction(_ -> {
            Collections.shuffle(questions);
            if (questions.size() >= 5) {
                selectedQuestions.set(new ArrayList<>(questions.subList(0, 5)));
            } else {
                selectedQuestions.set(new ArrayList<>(questions));
            }

            currentQuestionIndex[0] = 0;
            totalScore[0] = 0;

            scoreLabel.setText("Score: 0");
            feedbackLabel.setText("");
            restartButton.setVisible(false);

            layout.getChildren().clear();
            layout.getChildren().addAll(questionLabel, option1, option2, option3, option4, nextButton, feedbackLabel, scoreLabel, restartButton);

            loadQuestion(
                    selectedQuestions.get().get(currentQuestionIndex[0]),
                    questionLabel,
                    List.of(option1, option2, option3, option4),
                    feedbackLabel,
                    totalScore,
                    scoreLabel,
                    nextButton
            );
        });


    }
    
    private void loadQuestion(Question question, Label questionLabel, List<Button> options, Label feedbackLabel, int[] totalScore, Label scoreLabel, Button nextButton) {
        questionLabel.setText(question.getQuestionText() + " (" + question.getDifficulty() + " - " + question.getPoints() + " points)");
        List<String> answers = question.getOptions();

        for (Button option : options) {
            option.setDisable(false);
            option.getStyleClass().removeAll("correct", "wrong");
        }

        for (int i = 0; i < options.size(); i++) {
            Button option = options.get(i);
            option.setText(answers.get(i));

            option.setOnAction(_ -> {
                if (option.getText().equals(question.getCorrectAnswer())) {
                    totalScore[0] += question.getPoints();
                    feedbackLabel.setText("Correct! You earned " + question.getPoints() + " points.");
                    feedbackLabel.setStyle("-fx-text-fill: green;");
                    option.getStyleClass().add("correct");
                } else {
                    feedbackLabel.setText("Wrong! The correct answer was: " + question.getCorrectAnswer());
                    feedbackLabel.setStyle("-fx-text-fill: red;");
                    option.getStyleClass().add("wrong");
                }

                scoreLabel.setText("Score: " + totalScore[0]);
                nextButton.setDisable(false);

                for (Button btn : options) {
                    btn.setDisable(true);
                }
            });
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
