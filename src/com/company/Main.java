package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws FileNotFoundException {

      /*Student n1 = new Student("Peter", "Hansen", 18, 1.88, true);
      System.out.println(n1);*/

        Scanner scan = new Scanner(System.in);
        //før adresse er tilføjet
      /*System.out.println("Enter first name");
      String fn = scan.next();
      System.out.println("Enter last name");
      String ln = scan.next();
      System.out.println("Enter age");
      int age = scan.nextInt();
      System.out.println("Enter height in meters");
      double h = scan.nextDouble();
      System.out.println("Enter gender, true for male and false for female");
      boolean g = scan.nextBoolean();
      Student n2 = new Student(fn, ln, age, h, g);
      System.out.println(n2);*/

        //System.out.println(makeStudent(scan));

      /*Student n1 = new Student("Peter", "Hansen", "vej 22", 18, 1.88, true);
      System.out.println(n1);
      System.out.println();

      System.out.println("Would you like to change the address for the student: "+n1.getFirstName()+" "+n1.getLastName()+", 1 for yes and 2 for no");
      int chAnswer = scan.nextInt();
      if(chAnswer == 1){
         changeAddress(scan, n1);
         System.out.println("\nThe student with a new address:\n"+n1);
      }else {
         System.out.println("\nThen the student is unchanged and still:\n"+n1);
      }*/

      /*Student[] students = new Student[10];
      String answer = "y";
      int index = 0;
      while(answer.equals("y")){
         students[index] = makeStudent(scan);
         index++;
         System.out.println("Whant to make another?, y for yes, n for no");
         answer = scan.next();
      }*/
        Student st1 = new Student("Cay", "Larsen", "Stadionvej 6", 33, 1.88, true);
        Student st2 = new Student("Peter", "Bager", "Strøget 4", 55, 1.90, true);


        //printArray(students);

        Student[] student2 = new Student[10];
        student2[0] = st1;
        student2[1] = st2;
        studentToFile(student2);
        //Student[] fstud = createStudentFromFile(student2);
        printArray(student2);

        //student2[3] = makeNewStudent(scan);
        //studentToFile(student2);
        //printArray(createStudentFromFile(student2));

    }

    public static Student[] createStudentFromFile(Student[] s1)throws FileNotFoundException{
        Scanner in = new Scanner(new File("students.txt"));
        int i = 0;
        while(in.hasNextLine()){
            String line = in.nextLine();
            Scanner lineScan = new Scanner(line);
            lineScan.useLocale(Locale.ENGLISH);     // så den forstår komma vs punktum
            String fn = lineScan.next();
            String ln = lineScan.next();
            String ad = lineScan.next();
            int a = lineScan.nextInt();
            double h = lineScan.nextDouble();
            boolean g = lineScan.nextBoolean();
            Student newStudent = new Student(fn, ln, ad, a, h, g);
            s1[i] = newStudent;
            i++;
        }
        return s1;
    }

    public static void studentToFile(Student[] stu1)throws FileNotFoundException{
        PrintStream out = new PrintStream(new File("students.txt"));
        for(int i = 0; i < stu1.length; i++){
            //System.out.println(stu1[i]);
            if(stu1[i] != null){
                String fn = stu1[i].getFirstName();
                String ln = stu1[i].getLastName();
                String ad = stu1[i].getAddress();
                int a = stu1[i].getAge();
                double h = stu1[i].getHeight();
                boolean g = stu1[i].getGender();
                out.println(fn+" "+ln+" "+ad+" "+a+" "+h+" "+g);
            }
        }
    }

    public static void printArray(Student[] st){
        for(int i = 0; i < st.length; i++){
            if(st[i] != null){
                System.out.println(st[i]);
                System.out.println();
            }
        }
    }

    public static Student makeNewStudent(Scanner input){
        System.out.println("Enter first name");
        String fn = input.next();
        System.out.println("Enter last name");
        String ln = input.next();                           // Hvis man bruger en nextLine efter en next
        input.nextLine();                            // <-- "spiser" enter som ligger i bufferen, se forklaring i bunden af koden!!
        System.out.println("Enter address");
        String ad = input.nextLine();
        System.out.println("Enter age");
        int age = input.nextInt();
        System.out.println("Enter height in meters");
        double h = input.nextDouble();
        System.out.println("Enter gender, true for male and false for female");
        boolean g = input.nextBoolean();
        Student n3 = new Student(fn, ln, ad, age, h, g);
        System.out.println("before saving"+n3);


        return n3;
    }

    public static Student changeAddress(Scanner input, Student s){
        System.out.println("What is the new address?");
        input.nextLine();                                  //"spiser" enter som ligger i bufferen, se forklaring i bunden af koden!!
        String tempAddress = input.nextLine();
        s.changeAddress(tempAddress);
        return s;
    }

}
/*That's because the Scanner.nextInt method does not
read the newline character in your input created by
hitting "Enter," and so the call to Scanner.nextLine
returns after reading that newline.

you will encounter the similar behaviour when you
use Scanner.nextLine after Scanner.next() or any
Scanner.nextFoo method (except nextLine itself)*/
