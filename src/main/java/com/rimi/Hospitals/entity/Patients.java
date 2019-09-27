package com.rimi.Hospitals.entity;

/**
 * 病人对象
 *
 * @author chenjin
 * @date 2019/9/27 19:31
 */
public class Patients {
    //病历号
    private String medicalRecord;
    //姓名
    private String patientsName;
    //性别
    private String gender;
    //年龄
    private String age;
    //血型
    private String bloodType;
    //诊断
    private String diagnose;
    //医生姓名
    private String doctorName;
    //病房号
    private String room;
    //病历号所属科室
    private String subordinateDepartments;


    public Patients() {
    }

    public Patients(String medicalRecord, String patientsName, String gender, String age, String bloodType, String diagnose, String doctorName, String room, String subordinateDepartments) {
        this.medicalRecord = medicalRecord;
        this.patientsName = patientsName;
        this.gender = gender;
        this.age = age;
        this.bloodType = bloodType;
        this.diagnose = diagnose;
        this.doctorName = doctorName;
        this.room = room;
        this.subordinateDepartments = subordinateDepartments;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "medicalRecord='" + medicalRecord + '\'' +
                ", patientsName='" + patientsName + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", diagnose='" + diagnose + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", room='" + room + '\'' +
                ", subordinateDepartments='" + subordinateDepartments + '\'' +
                '}';
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord;
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

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSubordinateDepartments() {
        return subordinateDepartments;
    }

    public void setSubordinateDepartments(String subordinateDepartments) {
        this.subordinateDepartments = subordinateDepartments;
    }
}
