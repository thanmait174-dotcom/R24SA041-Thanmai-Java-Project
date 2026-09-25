package com.reva.exam.model;
public abstract class Person {
 private String name; private String email;
 protected Person(){this("Unknown","Not provided");}
 protected Person(String name,String email){this.name=name;this.email=email;}
 public String getName(){return name;} public void setName(String name){this.name=name;}
 public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
 public abstract String getRole();
 public String getDisplayName(){return name.trim().toUpperCase();}
 @Override public String toString(){return name+" <"+email+">";}
}
