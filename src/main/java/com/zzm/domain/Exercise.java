package com.zzm.domain;

import java.io.Serializable;

public class Exercise implements Serializable {
    private Integer e_id;
    private Integer type;
    private String question;
    private String realresult;
    private String a;
    private String b;
    private String c;
    private String d;

    public Integer getE_id() {
        return e_id;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRealresult() {
        return realresult;
    }

    public void setRealresult(String realresult) {
        this.realresult = realresult;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "e_id=" + e_id +
                ", type=" + type +
                ", question='" + question + '\'' +
                ", realresult='" + realresult + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}
