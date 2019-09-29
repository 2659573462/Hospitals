package com.rimi.Hospitals.entity;

/**
 * 科室对象
 *
 * @author chenjin
 * @date 2019/9/28 12:59
 */
public class thesectiontable {
    //科室名称
    private String departmentOf;
    //联系电话
    private String  phone;
    //科室地址
    private String sectionOfficeAddress;
    //科室主任
    private String officesDirector;


    public thesectiontable(String departmentOf, String phone, String sectionOfficeAddress, String officesDirector) {
        this.departmentOf = departmentOf;
        this.phone = phone;
        this.sectionOfficeAddress = sectionOfficeAddress;
        this.officesDirector = officesDirector;
    }

    @Override
    public String toString() {
        return "thesectiontable{" +
                "departmentOf='" + departmentOf + '\'' +
                ", phone='" + phone + '\'' +
                ", sectionOfficeAddress='" + sectionOfficeAddress + '\'' +
                ", officesDirector='" + officesDirector + '\'' +
                '}';
    }

    public thesectiontable() {
    }

    public String getDepartmentOf() {
        return departmentOf;
    }

    public void setDepartmentOf(String departmentOf) {
        this.departmentOf = departmentOf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSectionOfficeAddress() {
        return sectionOfficeAddress;
    }

    public void setSectionOfficeAddress(String sectionOfficeAddress) {
        this.sectionOfficeAddress = sectionOfficeAddress;
    }

    public String getOfficesDirector() {
        return officesDirector;
    }

    public void setOfficesDirector(String officesDirector) {
        this.officesDirector = officesDirector;
    }
}
