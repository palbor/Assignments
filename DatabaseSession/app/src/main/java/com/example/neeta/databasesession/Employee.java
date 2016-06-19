package com.example.neeta.databasesession;

/**
 * Created by Neeta on 19/02/2016.
 */
public class Employee {
    int EMPLOYEEID;;
    String EMPLOYEELNAME, EMPLOYEEFNAME;

    public Employee(int EMPLOYEEID, String EMPLOYEELNAME, String EMPLOYEEFNAME) {
        this.EMPLOYEEID = EMPLOYEEID;
        this.EMPLOYEELNAME = EMPLOYEELNAME;
        this.EMPLOYEEFNAME = EMPLOYEEFNAME;
    }

    public Employee(String EMPLOYEEFNAME, String EMPLOYEELNAME) {
        this.EMPLOYEEFNAME = EMPLOYEEFNAME;
        this.EMPLOYEELNAME = EMPLOYEELNAME;
    }

    public int getEMPLOYEEID() {
        return EMPLOYEEID;
    }

    public void setEMPLOYEEID(int EMPLOYEEID) {
        this.EMPLOYEEID = EMPLOYEEID;
    }

    public String getEMPLOYEELNAME() {
        return EMPLOYEELNAME;
    }

    public void setEMPLOYEELNAME(String EMPLOYEELNAME) {
        this.EMPLOYEELNAME = EMPLOYEELNAME;
    }

    public String getEMPLOYEEFNAME() {
        return EMPLOYEEFNAME;
    }

    public void setEMPLOYEEFNAME(String EMPLOYEEFNAME) {
        this.EMPLOYEEFNAME = EMPLOYEEFNAME;
    }
}
