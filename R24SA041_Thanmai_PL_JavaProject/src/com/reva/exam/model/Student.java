package com.reva.exam.model;
import java.util.Objects;
public class Student extends Person {
 private String srn; private String program; private String phone="Not provided"; private static int studentCount;
 public Student(){this("UNKNOWN","Unknown","Not provided","B.Sc. (BSTCs)");}
 public Student(String srn,String name,String email,String program){this(srn,name,email,program,"Not provided");}
 public Student(String srn,String name,String email,String program,String phone){super(name,email);this.srn=srn;this.program=program;this.phone=phone;studentCount++;}
 public String getSrn(){return srn;} public void setSrn(String srn){this.srn=srn;}
 public String getProgram(){return program;} public void setProgram(String program){this.program=program;}
 public String getPhone(){return phone;} public void setPhone(String phone){this.phone=phone;}
 public static int getStudentCount(){return studentCount;}
 @Override public String getRole(){return "Student";}
 public String getProfile(String format){return String.format("%s | %s | %s | %s | %s",srn,getDisplayName(),getEmail(),program,phone);}
 @Override public String toString(){return String.format("%s | %s | %s | %s | %s",srn,getName(),getEmail(),program,phone);}
 @Override public boolean equals(Object obj){if(this==obj)return true;if(!(obj instanceof Student))return false;Student other=(Student)obj;return srn.equalsIgnoreCase(other.srn);}
 @Override public int hashCode(){return Objects.hash(srn.toUpperCase());}
}
