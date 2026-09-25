package com.reva.exam.model;
import java.util.Arrays;
public class Question {
 private final int number; private String text; private String[] options; private int correctOption; private String topic; private QuestionType type;
 public Question(){this(0,"Question",new String[]{"A","B","C","D"},0,"General");}
 public Question(int number,String text,String[] options,int correctOption,String topic){this(number,text,options,correctOption,topic,QuestionType.MCQ);}
 public Question(int number,String text,String[] options,int correctOption,String topic,QuestionType type){this.number=number;this.text=text;this.options=options;this.correctOption=correctOption;this.topic=topic;this.type=type;}
 public int getNumber(){return number;} public String getText(){return text;} public void setText(String text){this.text=text;}
 public String[] getOptions(){return options;} public int getCorrectOption(){return correctOption;} public String getTopic(){return topic;} public QuestionType getType(){return type;}
 public String getCorrectAnswerText(){return options[correctOption];}
 @Override public String toString(){return number+". "+text+" "+Arrays.toString(options);}
}
