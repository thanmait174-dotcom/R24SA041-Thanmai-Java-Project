package com.reva.exam.service;
import com.reva.exam.model.*; import java.util.*;
public class ExamService {
 private final List<Student> students=new ArrayList<>(); private final List<Attempt> attempts=new ArrayList<>(); private final List<Exam> exams=new ArrayList<>();
 public void registerStudent(Student s){if(s!=null&&findStudent(s.getSrn())==null)students.add(s);}
 public Student findStudent(String srn){for(Student s:students)if(s.getSrn().equalsIgnoreCase(srn.trim()))return s;return null;}
 public List<Student> searchStudents(String q){List<Student> m=new ArrayList<>();String x=q.trim().toLowerCase();for(Student s:students)if(s.getSrn().toLowerCase().contains(x)||s.getName().toLowerCase().contains(x)||s.getEmail().toLowerCase().contains(x))m.add(s);return m;}
 public void addExam(Exam e){if(e!=null)exams.add(e);} public Exam findExam(String code){for(Exam e:exams)if(e.getCode().equalsIgnoreCase(code))return e;return null;} public void addAttempt(Attempt a){if(a!=null)attempts.add(a);}
 public List<Attempt> findAttemptsByStudent(String srn){List<Attempt> m=new ArrayList<>();for(Attempt a:attempts)if(a.getStudent().getSrn().equalsIgnoreCase(srn.trim()))m.add(a);return m;}
 public double passRate(){if(attempts.isEmpty())return 0;int p=0;for(Attempt a:attempts)if(a.getStatus()==ResultStatus.PASS)p++;return p*100.0/attempts.size();}
 public List<Student> getStudents(){return students;} public List<Exam> getExams(){return exams;} public List<Attempt> getAttempts(){return attempts;}
}
