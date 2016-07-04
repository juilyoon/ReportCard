package com.juilyoon.reportcard;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by juil on 16-07-04.
 */
public class ReportCard {
    private String student;
    private String date;
    private int gradeYear;
    private int semester;
    private ArrayList<Course> courseList;
    private String homeroomTeacher;
    private String comments;
    private int absences;

    public ReportCard(String student, int gradeYear, int semester, String homeroomTeacher) {
        this.student = student;
        Calendar today = Calendar.getInstance();
        date = today.YEAR + "/" + (today.MONTH+1);
        this.gradeYear = gradeYear;
        this.semester = semester;
        this.homeroomTeacher = homeroomTeacher;
        courseList = new ArrayList<Course>();
        comments = "";
        absences = 0;
    }

    public String getStudent() {
        return student;
    }

    public String getDate() {
        return date;
    }

    /**
     * Mostly for if the ReportCard was created ahead of time and the date needs to be updated.
     *
     * @param date String int he format yyyy/mm
     */
    public void setDate(String date) {
        this.date = date;
    }

    public int getGradeYear() {
        return gradeYear;
    }

    public int getSemester() {
        return semester;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public int getOveralAverage() {
        int total = 0;
        for (int i=0; i < courseList.size(); i++) {
            total += courseList.get(i).getGradePercent();
        }
        return total/courseList.size();
    }

    public boolean isPass() {
        return (getOveralAverage() >= 50);
    }

    public String getHomeroomTeacher() {
        return homeroomTeacher;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getAbsences() {
        return absences;
    }

    public void setAbsences(int absences) {
        this.absences = absences;
    }
}