package com.rimi.Hospitals.entity;

/**
 * 护士对象
 *
 * @author chenjin
 * @date 2019/9/27 14:16
 */
public class nurse {
    //护士编号
    private String nurseNumber;
    //护士名称
    private String patientsName;
    //护士性别
    private String gender;
    //护士年龄
    private String age;

    public nurse(String nurseNumber, String patientsName, String gender, String age) {
        this.nurseNumber = nurseNumber;
        this.patientsName = patientsName;
        this.gender = gender;
        this.age = age;
    }

    public nurse() {
    }

    @Override
    public String toString() {
        return "nurse{" +
                "nurseNumber='" + nurseNumber + '\'' +
                ", patientsName='" + patientsName + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getNurseNumber() {
        return nurseNumber;
    }

    public void setNurseNumber(String nurseNumber) {
        this.nurseNumber = nurseNumber;
    }

    public String getPatientsName() {
        return patientsName;
    }

    public void setPatientsName(String patientsName) {
        this.patientsName = patientsName;
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
}
