package com.company;

public class Student{
    private String firstName;
    private String lastName;
    private String address;
    private int age;
    private double height;
    private boolean gender;

    public Student(){
        firstName = null;
        lastName = null;
        address = null;
        age = 0;
        height = 0;
        gender = false;
    }

    public Student(String fn, String ln, String ad, int a, double h, boolean g){
        firstName = fn;
        lastName = ln;
        address = ad;
        age = a;
        height = h;
        gender = g;
    }

    //Getters and setters
    public void setFirstName(String fn){
        firstName = fn;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String ln){
        lastName = ln;
    }
    public String getLastName(){
        return lastName;
    }
    public void setAddress(String a){
        address = a;
    }
    public String getAddress(){
        return address;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setHeight(double h){
        height = h;
    }
    public double getHeight(){
        return height;
    }
    public void setGender(boolean g){
        gender = g;
    }
    public boolean getGender(){
        return gender;
    }

    public String toString(){
        String sGender;
        if(gender == true){
            sGender = "Male";
        }else{
            sGender = "female";
        }
        return ("First name: "+getFirstName()+"\nLast name: "+getLastName()+"\nAddress:"+getAddress()+"\nAge: "+getAge()+"\nHeight: "+getHeight()+"\nGender: "+sGender);
    }

    public void changeAddress(String newAddress){
        address = newAddress;
    }
}