/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;
import utilities.DateModifier;

/**
 *
 * @author Administrator
 */
public class Program implements Comparable<Program> {

    private String id;
    private String name;
    private String time;
    private Date beginDate;
    private Date endDate;
    private int days;
    private String location;
    private double cost;
    private String content;

    public Program(String id, String name, String time, Date beginDate, Date endDate, int days, String location, double cost, String content) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.days = days;
        this.location = location;
        this.cost = cost;
        this.content = content;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getCost() {
        return cost;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        String ret = String.format("%s,%s,%s,%s,%s,%s,%f,%s",
                id, name, time, DateModifier.toDateString(beginDate, null),
                DateModifier.toDateString(endDate, null), cost, content);
        return ret;
    }

    public void display() {
//      |Program id|    Program name    |Time      |Begin Date| End Date |     Days     |Location                           |Cost    |
//      |%-10s|%-20s|%-10s|%10s|%10s|%14s|%-35s|%6.2f|                 |     Days     |
        String line = String.format("|%-10s|%-20s|%-10s|%10s|%10s|%-14d|%-35s|%6.2f|",
                id, name, time, DateModifier.toDateString(beginDate, null),
                DateModifier.toDateString(endDate, null), days, location, cost);
        System.out.println(line);
    }

    @Override
    public int compareTo(Program o) {
        return this.id.compareTo(o.id);
    }
}
