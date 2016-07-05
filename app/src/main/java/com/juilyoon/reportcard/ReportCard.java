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

    /** A more human-readable way to get the list of courses. */
    public String[] getListOfCourses() {
        String[] list = new String[courseList.size()];
        for (int i = 0; i < courseList.size(); i++) {
            list[i] = courseList.get(i).getCourseName();
        }
        return list;
    }

    public void addCourse(Course course) {
        courseList.add(course);
    }

    /**
     * Removes the first course with a name matching the string.
     *
     * @param courseName It is trivial to get the list of courses with getListOfCourses()
     * @return boolean: true if course is removed, false otherwise
     */
    public boolean removeCourse(String courseName) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseName().equals(courseName)) {
                courseList.remove(i);
                return true;
            }
        }
        return false;
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

    @Override
    public String toString() {
        return "ReportCard{" +
                "student='" + student + '\'' +
                ", date='" + date + '\'' +
                ", gradeYear=" + gradeYear +
                ", semester=" + semester +
                ", courseList=" + getListOfCourses() +
                ", homeroomTeacher='" + homeroomTeacher + '\'' +
                ", comments='" + comments + '\'' +
                ", absences=" + absences +
                '}';
    }
}
