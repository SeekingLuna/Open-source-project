package com.li.domain;

public class User02 {
    private String name;
    private String sex;

    private Integer age;

    @Override
    public String toString() {
        return "User02{" +
                "name='" + getName() + '\'' +
                ", sex='" + getSex() + '\'' +
                ", age=" + getAge() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
