package com.example.neeta.listviewasgn;

import java.math.BigInteger;

/**
 * Created by Neeta on 04/02/2016.
 */
public class Element {
    private String name;
    private BigInteger phone_no;

    public Element(BigInteger phone_no, String name) {
        this.phone_no = phone_no;
        this.name = name;
    }
}
