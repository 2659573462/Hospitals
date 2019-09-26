package com.rimi.Hospitals.entity;

/**
 * 医生对象类型
 *
 * @author chenjin
 * @date 2019/9/25 17:00
 */
public class Doctortable {
    //工作证号
    private  String employeescard;
    //姓名
    private  String doctorname;
    //性别
    private  String gender;
    //年龄
    private  String age;
    //所属科室
    private  String subordinatedepartments;
    //学历
    private  String educationbackground;

    public Doctortable() {
    }

    @Override
    public String toString() {
        return "{employeescard+"+employeescard+"," +
                "doctorname+"+doctorname+"," +
                "gender+"+gender+"," +
                "age+"+age+"," +
                "subordinatedepartments+"+subordinatedepartments+"," +
                "educationbackground+"+educationbackground+"}";
    }


    public String getEmployeescard() {
        return employeescard;
    }

    public void setEmployeescard(String employeescard) {
        this.employeescard = employeescard;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSubordinatedepartments() {
        return subordinatedepartments;
    }

    public void setSubordinatedepartments(String subordinatedepartments) {
        this.subordinatedepartments = subordinatedepartments;
    }

    public String getEducationbackground() {
        return educationbackground;
    }

    public void setEducationbackground(String educationbackground) {
        this.educationbackground = educationbackground;
    }
}
