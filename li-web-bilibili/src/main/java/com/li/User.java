package com.li;

public class User {


    public User(int midid, String name) {
        this.midid = midid;
        this.name = name;
    }

    public User(int follower, int following) {
        this.follower = follower;
        this.following = following;
    }

    public User() {
    }

    private int midid;
    private String name;
    private String sign;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "User{" +
                "midid=" + midid +
                ", name='" + name + '\'' +
                ", sign='" + sign + '\'' +
                ", follower=" + follower +
                ", following=" + following +
                '}';
    }

    public User(int midid, String name, String sign, int follower, int following) {
        this.midid = midid;
        this.name = name;
        this.sign = sign;
        this.follower = follower;
        this.following = following;
    }

    private int follower;
    private int following;

    public int getMidid() {
        return midid;
    }

    public void setMidid(int midid) {
        this.midid = midid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public User(int midid, String name, int follower, int following) {
        this.midid = midid;
        this.name = name;
        this.follower = follower;
        this.following = following;
    }
}
