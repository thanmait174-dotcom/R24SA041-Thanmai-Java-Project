package com.reva.exam.model;
public class QuestionResult {
 private final Question question; private final int selectedOption;
 public QuestionResult(Question question,int selectedOption){this.question=question;this.selectedOption=selectedOption;}
 public Question getQuestion(){return question;} public int getSelectedOption(){return selectedOption;}
 public boolean isCorrect(){return selectedOption==question.getCorrectOption();}
 public String getSelectedAnswerText(){return selectedOption<0?"Not Answered":question.getOptions()[selectedOption];}
 public String getCorrectAnswerText(){return question.getCorrectAnswerText();}
}
