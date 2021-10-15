package com.example.mobdevproject.model;

public class Exercise {

    private int exerciseId;
    private String text;
    private String correctAnswer;
    private String answer;

    public Exercise(int exerciseId, String text, String correctAnswer) {
        this.exerciseId = exerciseId;
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.answer = "";
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
