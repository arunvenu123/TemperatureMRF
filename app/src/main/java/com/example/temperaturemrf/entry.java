package com.example.temperaturemrf;

public class entry {
    String date;
    String employeeno;
    String bustemp;
    String recordername;
    String intemp;
    String outtemp;

    public entry() {
    }

    public entry(String date, String employeeno, String bustemp, String recordername, String intemp, String outtemp) {
        this.date = date;
        this.employeeno = employeeno;
        this.bustemp = bustemp;
        this.recordername = recordername;
        this.intemp = intemp;
        this.outtemp = outtemp;
    }

    public String getDate() {
        return date;
    }

    public String getEmployeeno() {
        return employeeno;
    }

    public String getBustemp() {
        return bustemp;
    }

    public String getRecordername() {
        return recordername;
    }

    public String getIntemp() {
        return intemp;
    }

    public String getOuttemp() {
        return outtemp;
    }
}


