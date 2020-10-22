package com.dict.emp.entity;

import java.io.Serializable;

public class SalGrade implements Serializable {

    private static final long serialVersionUID = -6226126119022312545L;

    private Integer grade;

    private Integer losal;

    private Integer hisal;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getLosal() {
        return losal;
    }

    public void setLosal(Integer losal) {
        this.losal = losal;
    }

    public Integer getHisal() {
        return hisal;
    }

    public void setHisal(Integer hisal) {
        this.hisal = hisal;
    }

    @Override
    public String toString() {
        return "SalGrade{" +
                "grade=" + grade +
                ", losal=" + losal +
                ", hisal=" + hisal +
                '}';
    }
}
