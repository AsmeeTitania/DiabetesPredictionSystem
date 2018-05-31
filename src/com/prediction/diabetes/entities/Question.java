package com.prediction.diabetes.entities;

import com.prediction.diabetes.QuestionType;


public class Question {
    String question;
    QuestionType type;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }
}
