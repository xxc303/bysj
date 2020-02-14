package com.bdu.jiajiao.pojo;

import java.util.Date;

/**
 * @author 123
 * @create 2019/11/22
 * @since 1.0.0
 */
public class Student {

    private int id;
    private String username;
    private String password;
    private String item;//求教科目
    private String idNumber;
    private String area;
    private String address;
    private String phone;
    private String price;
    private String sex;
    private String token;
    private Date createTime;
    private String idRequirement;//身份要求
    private String detailRequirement;//详细要求
    private String school;
    private String grade;
    private String score;
    private String charac;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getArea() {
        return area;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {

        this.price = price;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIdRequirement() {
        return idRequirement;
    }

    public void setIdRequirement(String idRequirement) {
        this.idRequirement = idRequirement;
    }

    public String getDetailRequirement() {
        return detailRequirement;
    }

    public void setDetailRequirement(String detailRequirement) {
        this.detailRequirement = detailRequirement;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCharac() {
        return charac;
    }

    public void setCharac(String charac) {
        this.charac = charac;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", item='" + item + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", price='" + price + '\'' +
                ", sex='" + sex + '\'' +
                ", token='" + token + '\'' +
                ", createTime=" + createTime +
                ", idRequirement='" + idRequirement + '\'' +
                ", detailRequirement='" + detailRequirement + '\'' +
                ", school='" + school + '\'' +
                ", grade='" + grade + '\'' +
                ", score='" + score + '\'' +
                ", charac='" + charac + '\'' +
                '}';
    }
}
