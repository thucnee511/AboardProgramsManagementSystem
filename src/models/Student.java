/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import utilities.DateModifier;

/**
 *
 * @author Administrator
 */
public class Student implements Comparable<Student> {

    private String id;
    private String name;
    private String major;
    private String email;
    private String phone;
    private String address;
    private String passport;

    public Student(String id, String name, String major, String email, String phone, String passport, String address) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.passport = passport;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void display() {
//        |Student id|Student Name        |Major|Email                         |Phone     |Passport  |Address        |
//        |%-10s|%-20s|%5s|%30s|%10s|%-10s|%-15s|
        String line = String.format("|%-10s|%-20s|%5s|%30s|%10s|%-10s|%-15s|",
                id, name, major, email, phone, passport, address);
        System.out.println(line);
    }

    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        String ret = String.format("%s,%s,%s,%s,%s,%s,%s",
                id, name, major, email, phone, passport, address);
        return ret;
    }
}
