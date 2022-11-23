package com.address.address_manage.pojo;

public class Address {

    private int id;

    private String cName;

    private int pid;
    private int sid;
    private int shId;
    private int qid;

    public Address(int id, String cName, int pid) {
        this.id = id;
        this.cName = cName;
        this.pid = pid;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cName='" + cName + '\'' +
                ", pid=" + pid +
                '}';
    }


}
