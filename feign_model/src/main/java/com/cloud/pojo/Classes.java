package com.cloud.pojo;

public class Classes {

    private Integer classId;

    private String className;

    public Classes(Integer classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public Classes() {
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                '}';
    }
}
