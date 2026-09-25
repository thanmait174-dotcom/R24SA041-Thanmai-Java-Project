package com.reva.exam.service;
import com.reva.exam.model.*; import java.io.*; import java.nio.file.*; import java.time.LocalDateTime; import java.util.*;

public class PersistenceService {
 public void saveStudents(String path,List<Student> ss){
  ensure(path); try(BufferedWriter w=Files.newBufferedWriter(Path.of(path))){
   for(Student s:ss) w.write(clean(s.getSrn())+"|"+clean(s.getName())+"|"+clean(s.getEmail())+"|"+clean(s.getProgram())+"|"+clean(s.getPhone())); w.newLine();
  }catch(IOException ignored){}
 }
 public List<Student> loadStudents(String path){
  List<Student> out=new ArrayList<>(); Path p=Path.of(path); if(!Files.exists(p))return out;
  try{for(String l:Files.readAllLines(p)){String[] a=l.split("\\|",-1);
   if(a.length>=4)out.add(a.length>=5?new Student(a[0],a[1],a[2],a[3],a[4]):new Student(a[0],a[1],a[2],a[3]));
  }}catch(IOException ignored){} return out;
 }
 public void saveAttempts(String path,List<Attempt> as){
  ensure(path); try(BufferedWriter w=Files.newBufferedWriter(Path.of(path))){for(Attempt a:as){w.write(a.serialize());w.newLine();}}catch(IOException ignored){}
 }
 public List<Attempt> loadAttempts(String path,List<Exam> exams,List<Student> students){
  List<Attempt> out=new ArrayList<>(); Path p=Path.of(path); if(!Files.exists(p))return out;
  try{for(String l:Files.readAllLines(p)){String[] a=l.split("\\|",-1);if(a.length<3)continue;
   Student st=null; for(Student x:students)if(x.getSrn().equalsIgnoreCase(a[0])){st=x;break;} if(st==null)continue;
   Exam ex=null; String tokenData;
   if(a.length>=4){for(Exam x:exams)if(x.getCode().equalsIgnoreCase(a[2])){ex=x;break;} tokenData=a[3];}
   else {ex=exams.get(0); tokenData=a[2];} if(ex==null)continue;
   Attempt at=new Attempt(st,ex,LocalDateTime.parse(a[1]));
   if(!tokenData.isBlank())for(String token:tokenData.split(",")){String[] pair=token.split(":");if(pair.length==2)try{
    int qn=Integer.parseInt(pair[0]), selected=Integer.parseInt(pair[1]); for(Question q:ex.getQuestions())if(q.getNumber()==qn){at.recordAnswer(q,selected);break;}
   }catch(NumberFormatException ignored){}}
   out.add(at);
  }}catch(Exception ignored){} return out;
 }
 private void ensure(String path){try{Path p=Path.of(path).getParent();if(p!=null)Files.createDirectories(p);}catch(IOException ignored){}}
 private String clean(String s){return s==null?"":s.replace("|"," ").replace("\n"," ").trim();}
}
