# R24SA041 — Thanmai P L

## Java Programming Mini Project — REVA Smart Multi-Subject Examination System

**University:** REVA University  
**Program:** B.Sc. (BSTCs)  
**Semester:** V  
**SRN:** R24SA041  
**Student:** Thanmai P L

## Project Overview

A professional console-based multi-subject examination management system implemented in Java. It manages student profiles, multiple subject examinations, attempts, question-wise evaluation, previous student records, topic performance and academic analytics.

### Included Subjects

1. Java Programming
2. Python Programming
3. Statistics
4. Bioinformatics
5. DBMS
6. Data Structures & Algorithms

Each subject has its own question bank, topics, pass mark and examination code.

## Main Features

- Student registration with SRN, name, email, phone and program
- Persistent previous student records
- Six independent subject examinations
- Subject/exam selection before starting a test
- Question-wise result showing:
  - Full question
  - Student's selected answer
  - Correct answer
  - CORRECT / WRONG status
  - Topic
- Automatic score, percentage, grade and pass/fail status
- Previous attempt history for every student
- Student performance profile
- Academic transcript across completed subjects
- Overall examination analytics
- Subject-wise analytics and pass rates
- Question performance across subjects
- Student search by SRN, name or email
- Exam catalog showing question counts and attempt counts
- Local persistence under `data`
- Input validation and formatted console interface
- Demonstrates Java OOP concepts including inheritance, abstraction, interfaces, constructors, overloading, static members, enums, collections and packages

## Menu

```text
1.  Register Student
2.  View Student Records
3.  Start Examination
4.  View Previous Attempts
5.  View Detailed Result
6.  Search Student
7.  Overall Analytics
8.  Subject / Exam Information
9.  Student Performance Profile
10. Question Performance
11. Subject-wise Analytics
12. Student Academic Transcript
0.  Exit
```

## Project Structure

```text
R24SA041_Thanmai_PL_JavaProject
├── src/com/reva/exam
│   ├── app/Main.java
│   ├── model
│   ├── service
│   └── util
├── data
├── docs
├── bin
├── run.bat
└── README.md
```

## Persistence

The system automatically saves:

- `data/students.txt` — registered student details
- `data/attempts.txt` — previous examination attempts, including the subject/exam code

Existing Java examination records are retained and remain viewable after upgrading to the multi-subject version.

## OOP / Java Concept Traceability

| Requirement | Implementation |
|---|---|
| Encapsulation | Person, Student, Question, Exam, Attempt |
| Data types, constants and scope | Model and application classes |
| Operators and precedence | Score, percentage and pass-score calculations |
| Type conversion | Numeric calculations and parsing |
| Enum | QuestionType, ResultStatus |
| if-else / switch | Validation, grading and menu |
| Loops | Exam, records and analytics |
| Arrays | Question options |
| Collections | Lists and maps of students, exams, attempts and results |
| Console I/O | InputUtil and Main |
| Constructor overloading | Student, Question and Attempt |
| Method overloading | Model constructors |
| Static members | Student and Attempt counters |
| this / super | Model inheritance |
| Inheritance | Person → Student / Instructor |
| Abstract class | Person |
| Interface | ResultProcessor |
| Object methods | toString, equals, hashCode |
| final class / method | Exam |
| Packages | model, service, util, app |
| File handling | PersistenceService |

## Compile and Run

### Windows / PowerShell

```powershell
javac -d bin (Get-ChildItem -Path src -Recurse -Filter *.java).FullName
java -cp bin com.reva.exam.app.Main
```

### Easy Run

Double-click:

```text
run.bat
```

The project has been compiled and tested with the included source code.
