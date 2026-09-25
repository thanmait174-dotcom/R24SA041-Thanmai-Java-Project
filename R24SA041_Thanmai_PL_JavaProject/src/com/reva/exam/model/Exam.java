package com.reva.exam.model;
import java.util.ArrayList; import java.util.List;
// Final prevents changing the defined examination structure through inheritance.
public final class Exam {
 private final String code,title,institution,subject; private final int passMark; private final List<Question> questions=new ArrayList<>();
 public Exam(String code,String title,String institution,int passMark){this(code,title,institution,passMark,title);}
 public Exam(String code,String title,String institution,int passMark,String subject){this.code=code;this.title=title;this.institution=institution;this.passMark=passMark;this.subject=subject;}
 public String getCode(){return code;} public String getTitle(){return title;} public String getInstitution(){return institution;} public String getSubject(){return subject;} public int getPassMark(){return passMark;} public List<Question> getQuestions(){return questions;}
 public void addQuestion(Question q){questions.add(q);} public int calculatePassScore(){return (int)Math.ceil(questions.size()*passMark/100.0);}
 public final String getExamLabel(){return code+" - "+title;}
}
