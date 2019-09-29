package com.rimi.Hospitals.entity;

/**
 * 药品对象
 *
 * @author chenjin
 * @date 2019/9/28 1:15
 */
public class drug {
    //批文号
    private String approvalnumber;
    //药名
    private String drugname;
    //用法
    private String instruction;
    //主要医治
    private String directionsforuse;
    //生产企业
    private String manufacturingenterprise;
    //有效期
    private String periodofvalidity;

    public drug(String approvalnumber, String drugname, String instruction, String directionsforuse, String manufacturingenterprise, String periodofvalidity) {
        this.approvalnumber = approvalnumber;
        this.drugname = drugname;
        this.instruction = instruction;
        this.directionsforuse = directionsforuse;
        this.manufacturingenterprise = manufacturingenterprise;
        this.periodofvalidity = periodofvalidity;
    }

    public drug() {
    }

    @Override
    public String toString() {
        return "grup{" +
                "approvalnumber='" + approvalnumber + '\'' +
                ", drugname='" + drugname + '\'' +
                ", instruction='" + instruction + '\'' +
                ", directionsforuse='" + directionsforuse + '\'' +
                ", manufacturingenterprise='" + manufacturingenterprise + '\'' +
                ", periodofvalidity='" + periodofvalidity + '\'' +
                '}';
    }

    public String getApprovalnumber() {
        return approvalnumber;
    }

    public void setApprovalnumber(String approvalnumber) {
        this.approvalnumber = approvalnumber;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getDirectionsforuse() {
        return directionsforuse;
    }

    public void setDirectionsforuse(String directionsforuse) {
        this.directionsforuse = directionsforuse;
    }

    public String getManufacturingenterprise() {
        return manufacturingenterprise;
    }

    public void setManufacturingenterprise(String manufacturingenterprise) {
        this.manufacturingenterprise = manufacturingenterprise;
    }

    public String getPeriodofvalidity() {
        return periodofvalidity;
    }

    public void setPeriodofvalidity(String periodofvalidity) {
        this.periodofvalidity = periodofvalidity;
    }
}
