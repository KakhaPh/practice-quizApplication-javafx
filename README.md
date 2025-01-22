# Quiz Application in JavaFX

This is a simple **Quiz Application** built using **JavaFX**, which allows users to test their knowledge by answering multiple-choice questions. The app keeps track of the user's score and provides feedback on their answers.

---

## Features

- **Randomized Questions**: The app shuffles the list of questions for each game session to ensure variety.
- **Score Tracking**: Displays the current score and updates it dynamically based on correct answers.
- **Feedback Mechanism**: Provides immediate feedback on whether the selected answer is correct or incorrect.
- **Restart Game**: Option to restart the quiz and play again with a new set of questions.

---

## How It Works

1. **Question Generator**:
   - The `QuestionGenerator` class generates a list of questions with the following attributes:
     - Question Text
     - Correct Answer
     - Multiple Choices
     - Difficulty Level
     - Points

2. **Load Questions**:
   - The `loadQuestion` method dynamically updates the UI with a new question and its corresponding options.
   - Each button is tied to an event handler to validate the user's choice.

3. **UI Design**:
   - The application is styled using a `style.css` file, ensuring a visually appealing interface.
   - Components such as labels, buttons, and feedback areas are organized in a vertical layout using a `VBox`.

---

## File Structure

```
│   README.md                                           # Documentation
│
└───QuizzApplication
    │   .gitignore
    │   mvnw
    │   mvnw.cmd
    │   pom.xml
    │
    ├───.idea
    │       .gitignore
    │       encodings.xml
    │       misc.xml
    │
    ├───.mvn
    │   └───wrapper
    │           maven-wrapper.jar
    │           maven-wrapper.properties
    │
    └───src
        └───main
            ├───java
            │   │   module-info.java
            │   │
            │   └───com
            │       └───example
            │           └───quizzapplication
            │                   Main.java               # Entry point of the application    
            │                   Question.java           # Question class with attributes and methods
            │                   QuestionGenerator.java  # Generates and shuffles questions
            │
            └───resources
                └───com
                    └───example
                        └───quizzapplication
                                hello-view.fxml         # Main Reader File
                                style.css               # Stylesheet for the UI
```

---

## How to Run the Application

1. **Clone the Repository**:
   ```bash
   git clone <https://github.com/KakhaPh/practice-quizApplication-javafx>
   ```

2. **Open in IDE**:
   - Open the project in an IDE like IntelliJ IDEA or Eclipse.

3. **Add JavaFX Library**:
   - Ensure you have the JavaFX SDK set up in your project.

4. **Run the Application**:
   - Execute the `Main` class to launch the quiz application.

---

## Sample Questions

| Question                              | Options                                | Difficulty | Points |
|---------------------------------------|----------------------------------------|------------|--------|
| What is the capital of France?        | Paris, London, Berlin, Madrid          | Easy       | 1      |
| What is 5 + 3?                        | 6, 7, 8, 9                             | Easy       | 1      |
| Who painted the Mona Lisa?            | Van Gogh, Leonardo da Vinci, Picasso  | Medium     | 2      |
| What is the speed of light?           | 300000000, 150000000, 299792458       | Hard       | 3      |

---

## Future Enhancements

- Add support for more question categories.
- Include a timer for each question to increase difficulty.
- Allow users to load custom question sets from a file.
- Improve UI with advanced styling and animations.

---

## Technologies Used

- **Java**: Programming language used to develop the application.
- **JavaFX**: Framework for building the user interface.

---

## Author

[Kakha Phutkaradze]  
[kk.phutkaradze@gmail.com]
