package com.reva.exam.service;
import com.reva.exam.model.Attempt;
public class ExamResultService implements ResultProcessor {
 public double calculatePercentage(Attempt a){return a.getPercentage();}
 public String getGrade(Attempt a){double p=calculatePercentage(a);if(p>=90)return "A+";if(p>=80)return "A";if(p>=70)return "B";if(p>=60)return "C";if(p>=50)return "D";return "F";}
}
