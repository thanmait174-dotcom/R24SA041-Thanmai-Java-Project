package com.reva.exam.app;
import com.reva.exam.model.*; import com.reva.exam.service.*; import com.reva.exam.util.InputUtil; import java.util.*;

public class Main {
 private static final ExamService service=new ExamService(); private static final PersistenceService persistence=new PersistenceService();
 private static final InputUtil input=new InputUtil(); private static final ResultProcessor resultProcessor=new ExamResultService();
 private static final String STUDENT_FILE="data/students.txt", ATTEMPT_FILE="data/attempts.txt";

 public static void main(String[] args){seedExams();loadData();run();saveData();}
 private static void loadData(){persistence.loadStudents(STUDENT_FILE).forEach(service::registerStudent);service.getAttempts().addAll(persistence.loadAttempts(ATTEMPT_FILE,service.getExams(),service.getStudents()));}
 private static void saveData(){persistence.saveStudents(STUDENT_FILE,service.getStudents());persistence.saveAttempts(ATTEMPT_FILE,service.getAttempts());}

 private static void seedExams(){
  if(!service.getExams().isEmpty())return;
  Exam java=new Exam("JAVA-OOP-SEM5","Java Programming - OOP & Core Concepts","REVA University",50,"Java Programming");
  add(java,new String[][]{
   {"Which keyword is used to inherit a class in Java?","extends","implements","inherits","super","0","Inheritance"},
   {"Which concept binds data and methods into a single unit?","Abstraction","Encapsulation","Inheritance","Polymorphism","1","Encapsulation"},
   {"Which method is the entry point of a Java application?","start()","run()","main()","execute()","2","Java Basics"},
   {"Which keyword refers to the current object?","self","this","current","object","1","Classes"},
   {"Which type can contain a fixed set of named constants?","enum","array","class","record","0","Enums"},
   {"Which feature allows the same method name with different parameters?","Overriding","Overloading","Hiding","Casting","1","Polymorphism"},
   {"Which keyword calls a parent class constructor?","parent","base","super","this","2","Inheritance"},
   {"Which access modifier provides the widest member access?","private","protected","public","default","2","Encapsulation"},
   {"Which keyword prevents a class from being inherited?","static","final","sealed","private","1","Classes"},
   {"Which keyword is used when a class adopts an interface?","interface","contract","abstract","implements","3","Interfaces"}});
  Exam python=new Exam("PYTHON-SEM5","Python Programming & Data Science","REVA University",50,"Python Programming");
  add(python,new String[][]{
   {"Which symbol starts a comment in Python?","#","//","/*","--","0","Basics"},
   {"Which data type stores key-value pairs?","list","tuple","dictionary","set","2","Data Types"},
   {"Which keyword defines a function?","func","define","def","function","2","Functions"},
   {"What does len([10,20,30]) return?","2","3","4","30","1","Collections"},
   {"Which library is widely used for numerical arrays?","NumPy","Flask","Tkinter","Requests","0","Libraries"},
   {"Which keyword handles exceptions?","catch","except","error","handle","1","Exceptions"},
   {"What is the result of 7 // 2?","3.5","4","3","2","2","Operators"},
   {"Which structure is immutable?","list","dictionary","set","tuple","3","Collections"}});
  Exam stats=new Exam("STAT-SEM5","Statistics & Probability","REVA University",50,"Statistics");
  add(stats,new String[][]{
   {"Which measure represents the middle value of ordered data?","Mean","Median","Variance","Range","1","Descriptive Statistics"},
   {"What is the probability of a certain event?","0","0.5","1","-1","2","Probability"},
   {"Which measure describes spread around the mean?","Variance","Median","Mode","Frequency","0","Dispersion"},
   {"The most frequently occurring value is the:","Mean","Median","Mode","Range","2","Descriptive Statistics"},
   {"A sample is a:","Entire population","Subset of a population","Parameter","Census","1","Sampling"},
   {"Standard deviation is the square root of:","Mean","Variance","Median","Range","1","Dispersion"},
   {"A correlation coefficient usually lies between:","0 and 1","-1 and 1","-2 and 2","1 and 100","1","Correlation"},
   {"A p-value is commonly used in:","Hypothesis testing","Sorting","Encryption","Compression","0","Inference"}});
  Exam bio=new Exam("BIOINFO-SEM5","Bioinformatics & Molecular Biology","REVA University",50,"Bioinformatics");
  add(bio,new String[][]{
   {"Which database stores nucleotide sequences?","GenBank","PDB","PubChem","UniProt","0","Databases"},
   {"BLAST is mainly used for:","Sequence similarity search","Image editing","Database backup","Compiling Java","0","Sequence Analysis"},
   {"Which database is primarily protein-focused?","UniProt","GenBank","SRA","GEO","0","Databases"},
   {"What does FASTA represent in bioinformatics?","A sequence format","A microscope","A statistic","A programming language","0","Sequence Formats"},
   {"PDB mainly contains structures of:","Proteins and nucleic acids","Only genes","Only cells","Only drugs","0","Structural Bioinformatics"},
   {"RNA-seq is commonly used to study:","Gene expression","Protein folding only","Blood pressure","Taxonomy only","0","Omics"},
   {"A sequence alignment compares:","Biological sequences","Operating systems","Networks","Spreadsheets","0","Sequence Analysis"},
   {"Which tool predicts protein-ligand binding poses?","AutoDock Vina","BLAST","FastQC","Excel","0","Molecular Docking"}});
  Exam db=new Exam("DBMS-SEM5","Database Management Systems","REVA University",50,"DBMS");
  add(db,new String[][]{
   {"Which language is used to query relational databases?","HTML","SQL","CSS","XML","1","SQL"},
   {"A primary key must be:","Duplicate","Unique","Optional","Encrypted","1","Keys"},
   {"Which command retrieves rows?","SELECT","INSERT","DELETE","DROP","0","SQL"},
   {"Which normal form removes repeating groups?","1NF","2NF","3NF","BCNF","0","Normalization"},
   {"Which command adds a new row?","UPDATE","INSERT","ALTER","CREATE","1","SQL"},
   {"Which clause filters rows?","ORDER BY","GROUP BY","WHERE","JOIN","2","SQL"},
   {"A foreign key refers to a key in:","Another related table","A compiler","An array","A file only","0","Relationships"},
   {"Which is a transaction property?","ACID","HTML","FIFO","GUI","0","Transactions"}});
  Exam ds=new Exam("DS-SEM5","Data Structures & Algorithms","REVA University",50,"Data Structures");
  add(ds,new String[][]{
   {"Which structure follows LIFO?","Queue","Stack","Tree","Graph","1","Stacks"},
   {"Which structure follows FIFO?","Stack","Queue","Heap","Tree","1","Queues"},
   {"Binary search requires data to be:","Random","Sorted","Encrypted","Duplicated","1","Searching"},
   {"Which structure uses nodes and links?","Linked list","Array only","Integer","String","0","Linked Lists"},
   {"Worst-case binary search time is:","O(n)","O(log n)","O(n²)","O(1)","1","Searching"},
   {"Which algorithm repeatedly selects the minimum element?","Selection sort","Merge sort","Binary search","DFS","0","Sorting"},
   {"A tree with at most two children per node is:","Binary tree","Graph","Heap only","Queue","0","Trees"},
   {"DFS commonly uses a:","Stack","Queue","Hash table only","Array only","0","Graphs"}});
  service.addExam(java);service.addExam(python);service.addExam(stats);service.addExam(bio);service.addExam(db);service.addExam(ds);
 }
 private static void add(Exam e,String[][] qs){int n=1;for(String[] x:qs)e.addQuestion(new Question(n++,x[0],new String[]{x[1],x[2],x[3],x[4]},Integer.parseInt(x[5]),x[6]));}

 private static void run(){boolean running=true;while(running){header();System.out.println(
 "1. Register Student\n2. View Student Records\n3. Start Examination\n4. View Previous Attempts\n5. View Detailed Result\n6. Search Student\n7. Overall Analytics\n8. Subject / Exam Information\n9. Student Performance Profile\n10. Question Performance\n11. Subject-wise Analytics\n12. Student Academic Transcript\n0. Exit");
  int c=input.readInt("Select an option: ",0,12);switch(c){case 1->register();case 2->students();case 3->exam();case 4->attempts();case 5->detail();case 6->search();case 7->analytics();case 8->info();case 9->profile();case 10->questionPerformance();case 11->subjectAnalytics();case 12->transcript();case 0->{running=false;System.out.println("\nData saved successfully. Goodbye.");}}}}
 private static void header(){System.out.println("\n==============================================================\n             REVA SMART EXAMINATION SYSTEM\n==============================================================\n        Multi-Subject Assessment & Performance Portal\n--------------------------------------------------------------");}

 private static void register(){System.out.println("\nREGISTER NEW STUDENT\n--------------------------------------------------------------");String srn=input.readRequired("SRN: ");if(service.findStudent(srn)!=null){System.out.println("A student with this SRN already exists.");return;}String n=input.readRequired("Full Name: ");String email=input.readEmail("Email: ");String phone=input.readRequired("Phone: ");String program=input.readRequired("Program: ");service.registerStudent(new Student(srn,n,email,program,phone));saveData();System.out.println("\nStudent registered successfully. Student ID: "+srn);}
 private static void students(){System.out.println("\nSTUDENT RECORDS\n--------------------------------------------------------------------------------");if(service.getStudents().isEmpty()){System.out.println("No student records available.");return;}System.out.printf("%-12s %-22s %-28s %-15s %-20s%n","SRN","NAME","EMAIL","PHONE","PROGRAM");System.out.println("--------------------------------------------------------------------------------");for(Student s:service.getStudents())System.out.printf("%-12s %-22s %-28s %-15s %-20s%n",s.getSrn(),s.getName(),s.getEmail(),s.getPhone(),s.getProgram());System.out.println("\nTotal Students: "+service.getStudents().size());}
 private static Student selectStudent(String title){if(service.getStudents().isEmpty()){System.out.println("\nNo students registered. Register a student first.");return null;}System.out.println("\n"+title+"\n--------------------------------------------------------------");for(int i=0;i<service.getStudents().size();i++){Student s=service.getStudents().get(i);System.out.printf("%d. %s | %s | %s%n",i+1,s.getName(),s.getSrn(),s.getProgram());}return service.getStudents().get(input.readInt("Select student: ",1,service.getStudents().size())-1);}
 private static Exam selectExam(){System.out.println("\nAVAILABLE SUBJECTS / EXAMS\n--------------------------------------------------------------");for(int i=0;i<service.getExams().size();i++){Exam e=service.getExams().get(i);System.out.printf("%d. %-24s | %2d Questions | Pass %d%%%n",i+1,e.getSubject(),e.getQuestions().size(),e.getPassMark());}return service.getExams().get(input.readInt("Select subject: ",1,service.getExams().size())-1);}

 private static void exam(){Student s=selectStudent("SELECT CANDIDATE");if(s==null)return;Exam e=selectExam();System.out.println("\n==============================================================\n                    EXAMINATION BRIEF\n==============================================================");System.out.println("Candidate : "+s.getName()+"\nSRN       : "+s.getSrn()+"\nSubject   : "+e.getSubject()+"\nExam      : "+e.getTitle()+"\nQuestions : "+e.getQuestions().size()+"\nPass Mark : "+e.getPassMark()+"%");if(!input.confirm("Start examination?"))return;Attempt a=new Attempt(s,e);for(Question q:e.getQuestions()){System.out.println("\nQ"+q.getNumber()+". "+q.getText());for(int i=0;i<q.getOptions().length;i++)System.out.println("   "+(i+1)+") "+q.getOptions()[i]);a.recordAnswer(q,input.readInt("Your answer (1-"+q.getOptions().length+"): ",1,q.getOptions().length)-1);}service.addAttempt(a);saveData();printResult(a);}

 private static void detail(){if(service.getAttempts().isEmpty()){System.out.println("\nNo previous attempts available.");return;}Student s=selectStudent("SELECT STUDENT");if(s==null)return;List<Attempt> m=service.findAttemptsByStudent(s.getSrn());if(m.isEmpty()){System.out.println("No examination history found.");return;}System.out.println("\nATTEMPT HISTORY FOR "+s.getName().toUpperCase());for(int i=0;i<m.size();i++){Attempt a=m.get(i);System.out.printf("%d. %s | %-20s | %d/%d | %.2f%% | %s%n",i+1,a.getDateTime(),a.getExam().getSubject(),a.getScore(),a.getExam().getQuestions().size(),a.getPercentage(),a.getStatus());}printResult(m.get(input.readInt("Select attempt: ",1,m.size())-1));}

 private static void profile(){Student s=selectStudent("STUDENT PERFORMANCE PROFILE");if(s==null)return;List<Attempt> list=service.findAttemptsByStudent(s.getSrn());System.out.println("\n==============================================================\n                  STUDENT PERFORMANCE\n==============================================================");System.out.println("Name        : "+s.getName()+"\nSRN         : "+s.getSrn()+"\nEmail       : "+s.getEmail()+"\nPhone       : "+s.getPhone()+"\nProgram     : "+s.getProgram()+"\nTotal Exams : "+list.size());if(list.isEmpty()){System.out.println("No examination history available.");return;}double avg=0;for(Attempt a:list)avg+=a.getPercentage();System.out.printf("Average     : %.2f%%%n",avg/list.size());System.out.println("\nSUBJECT HISTORY");for(Attempt a:list)System.out.printf("%-22s | %3d/%-3d | %6.2f%% | %s | %s%n",a.getExam().getSubject(),a.getScore(),a.getExam().getQuestions().size(),a.getPercentage(),resultProcessor.getGrade(a),a.getStatus());}

 private static void printResult(Attempt a){System.out.println("\n==============================================================\n                    EXAM RESULT\n==============================================================");System.out.println("Student       : "+a.getStudent().getName()+"\nSRN           : "+a.getStudent().getSrn()+"\nSubject       : "+a.getExam().getSubject()+"\nExam          : "+a.getExam().getTitle()+"\nScore         : "+a.getScore()+"/"+a.getExam().getQuestions().size());System.out.printf("Percentage    : %.2f%%%n",a.getPercentage());System.out.println("Grade         : "+resultProcessor.getGrade(a)+"\nCorrect       : "+a.getCorrectCount()+"\nWrong         : "+a.getWrongCount()+"\nUnanswered    : "+a.getUnansweredCount()+"\nStatus        : "+a.getStatus());System.out.println("\nQUESTION-WISE REVIEW\n--------------------------------------------------------------");for(QuestionResult r:a.getResults()){System.out.println("Q"+r.getQuestion().getNumber()+" ["+(r.isCorrect()?"CORRECT":"WRONG")+"]");System.out.println("Question      : "+r.getQuestion().getText());System.out.println("Your Answer   : "+r.getSelectedAnswerText());System.out.println("Correct Answer: "+r.getCorrectAnswerText());System.out.println("Topic         : "+r.getQuestion().getTopic());System.out.println("--------------------------------------------------------------");}System.out.println("TOPIC PERFORMANCE");for(String x:a.getTopicSummary())System.out.println(x);}

 private static void attempts(){System.out.println("\nPREVIOUS ATTEMPTS\n------------------------------------------------------------------------------------------------");if(service.getAttempts().isEmpty()){System.out.println("No examination attempts recorded.");return;}System.out.printf("%-12s %-20s %-20s %-18s %-10s %-10s%n","SRN","STUDENT","SUBJECT","DATE/TIME","SCORE","STATUS");for(Attempt a:service.getAttempts())System.out.printf("%-12s %-20s %-20s %-18s %-10s %-10s%n",a.getStudent().getSrn(),a.getStudent().getName(),a.getExam().getSubject(),a.getDateTime(),a.getScore()+"/"+a.getExam().getQuestions().size(),a.getStatus());}
 private static void search(){String q=input.readText("Enter SRN, name or email: ").trim();if(q.isEmpty()){System.out.println("Search cannot be empty.");return;}List<Student> found=service.searchStudents(q);if(found.isEmpty()){System.out.println("No matching student found.");return;}for(Student s:found){System.out.println("\n"+s);List<Attempt> m=service.findAttemptsByStudent(s.getSrn());System.out.println("Attempts: "+m.size());for(Attempt a:m)System.out.printf("  %-20s | %d/%d | %.2f%% | %s%n",a.getExam().getSubject(),a.getScore(),a.getExam().getQuestions().size(),a.getPercentage(),a.getStatus());}}
 private static void analytics(){System.out.println("\nOVERALL ACADEMIC ANALYTICS\n--------------------------------------------------------------\nRegistered students : "+service.getStudents().size()+"\nAvailable subjects  : "+service.getExams().size()+"\nTotal attempts      : "+service.getAttempts().size());if(service.getAttempts().isEmpty())return;double total=0;double high=0,low=101;for(Attempt a:service.getAttempts()){total+=a.getPercentage();high=Math.max(high,a.getPercentage());low=Math.min(low,a.getPercentage());}System.out.printf("Average percentage  : %.2f%%%nHighest percentage  : %.2f%%%nLowest percentage   : %.2f%%%nPass rate           : %.2f%%%n",total/service.getAttempts().size(),high,low,service.passRate());}
 private static void info(){System.out.println("\nSUBJECT / EXAM CATALOG\n================================================================================================");System.out.printf("%-18s %-32s %-12s %-10s %-10s%n","CODE","SUBJECT","QUESTIONS","PASS MARK","ATTEMPTS");for(Exam e:service.getExams()){int n=0;for(Attempt a:service.getAttempts())if(a.getExam().getCode().equals(e.getCode()))n++;System.out.printf("%-18s %-32s %-12d %-10d %-10d%n",e.getCode(),e.getSubject(),e.getQuestions().size(),e.getPassMark(),n);}}
 private static void questionPerformance(){System.out.println("\nQUESTION PERFORMANCE ACROSS ALL SUBJECTS\n==============================================================");if(service.getAttempts().isEmpty()){System.out.println("No attempts available.");return;}for(Exam ex:service.getExams()){Map<Integer,int[]> stats=new LinkedHashMap<>();for(Attempt a:service.getAttempts())if(a.getExam().getCode().equals(ex.getCode()))for(QuestionResult r:a.getResults()){int[] v=stats.computeIfAbsent(r.getQuestion().getNumber(),k->new int[2]);if(r.isCorrect())v[0]++;else v[1]++;}if(stats.isEmpty())continue;System.out.println("\n["+ex.getSubject()+"]");for(Map.Entry<Integer,int[]> en:stats.entrySet()){int total=en.getValue()[0]+en.getValue()[1];System.out.printf("Q%d | %.2f%% correct | Correct: %d | Wrong: %d%n",en.getKey(),en.getValue()[0]*100.0/total,en.getValue()[0],en.getValue()[1]);}}}
 private static void subjectAnalytics(){System.out.println("\nSUBJECT-WISE ANALYTICS\n================================================================================");for(Exam e:service.getExams()){List<Attempt> list=new ArrayList<>();for(Attempt a:service.getAttempts())if(a.getExam().getCode().equals(e.getCode()))list.add(a);if(list.isEmpty()){System.out.printf("%-24s | No attempts yet%n",e.getSubject());continue;}double avg=0;for(Attempt a:list)avg+=a.getPercentage();System.out.printf("%-24s | Attempts: %2d | Average: %6.2f%% | Pass rate: %6.2f%%%n",e.getSubject(),list.size(),avg/list.size(),passRate(list));}}
 private static double passRate(List<Attempt> list){int p=0;for(Attempt a:list)if(a.getStatus()==ResultStatus.PASS)p++;return p*100.0/list.size();}
 private static void transcript(){Student s=selectStudent("SELECT STUDENT FOR TRANSCRIPT");if(s==null)return;List<Attempt> list=service.findAttemptsByStudent(s.getSrn());System.out.println("\n======================================================================\n                    ACADEMIC TRANSCRIPT\n======================================================================");System.out.println("Student : "+s.getName()+" | SRN: "+s.getSrn()+" | Program: "+s.getProgram());if(list.isEmpty()){System.out.println("No completed examinations.");return;}double total=0;for(Attempt a:list){total+=a.getPercentage();System.out.printf("%-22s %-18s %3d/%-3d %6.2f%% %-5s %s%n",a.getExam().getSubject(),a.getExam().getCode(),a.getScore(),a.getExam().getQuestions().size(),a.getPercentage(),resultProcessor.getGrade(a),a.getStatus());}System.out.println("----------------------------------------------------------------------");System.out.printf("Overall Average: %.2f%% | Completed Subjects: %d/%d%n",total/list.size(),list.size(),service.getExams().size());}
}
