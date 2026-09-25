package com.reva.exam.model;
import java.time.LocalDateTime; import java.time.format.DateTimeFormatter; import java.util.*;
public class Attempt {
 private Student student; private Exam exam; private LocalDateTime dateTime; private final List<QuestionResult> results=new ArrayList<>(); private static int attemptCount;
 public Attempt(){this(null,null);} public Attempt(Student student,Exam exam){this.student=student;this.exam=exam;this.dateTime=LocalDateTime.now();attemptCount++;}
 public Attempt(Student student,Exam exam,LocalDateTime dateTime){this(student,exam);this.dateTime=dateTime;}
 public Student getStudent(){return student;} public Exam getExam(){return exam;} public String getDateTime(){return dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));}
 public List<QuestionResult> getResults(){return results;} public static int getAttemptCount(){return attemptCount;}
 public void recordAnswer(Question q,int selected){results.add(new QuestionResult(q,selected));}
 public int getScore(){int s=0;for(QuestionResult r:results)if(r.isCorrect())s++;return s;}
 public int getCorrectCount(){return getScore();}
 public int getWrongCount(){int n=0;for(QuestionResult r:results)if(!r.isCorrect()&&r.getSelectedOption()>=0)n++;return n;}
 public int getUnansweredCount(){return Math.max(0,exam.getQuestions().size()-results.size());}
 public double getPercentage(){return exam.getQuestions().isEmpty()?0:getScore()*100.0/exam.getQuestions().size();}
 public ResultStatus getStatus(){return getScore()>=exam.calculatePassScore()?ResultStatus.PASS:ResultStatus.FAIL;}
 public List<String> getTopicSummary(){Map<String,int[]> m=new LinkedHashMap<>();for(QuestionResult r:results){int[] c=m.computeIfAbsent(r.getQuestion().getTopic(),k->new int[2]);if(r.isCorrect())c[0]++;else c[1]++;}List<String> out=new ArrayList<>();for(Map.Entry<String,int[]> e:m.entrySet())out.add(String.format("%-18s Correct: %d | Wrong: %d",e.getKey(),e.getValue()[0],e.getValue()[1]));return out;}
 public String serialize(){StringBuilder b=new StringBuilder();for(QuestionResult r:results){if(b.length()>0)b.append(",");b.append(r.getQuestion().getNumber()).append(":").append(r.getSelectedOption());}return student.getSrn()+"|"+dateTime+"|"+exam.getCode()+"|"+b;}
}
