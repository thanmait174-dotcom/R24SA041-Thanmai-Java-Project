package com.reva.exam.model;
public class Instructor extends Person {
 private String department;
 public Instructor(){this("Exam Cell","examcell@reva.edu.in","Computer Science");}
 public Instructor(String name,String email,String department){super(name,email);this.department=department;}
 public String getDepartment(){return department;} public void setDepartment(String department){this.department=department;}
 @Override public String getRole(){return "Instructor";}
 @Override public String toString(){return super.toString()+" | "+department;}
}
