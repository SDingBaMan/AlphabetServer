package com.sdingba.domain;

import org.apache.taglibs.standard.lang.jstl.NullLiteral;

/**
 * Created by su on 16-6-1.
 */
public class testdomain {

    public testdomain(){

    }

    @Override
    public String toString() {
        StringBuffer aa = new StringBuffer();
        aa.append(getAaa());
//        aa.append(":");
//        aa.append(getBbb());
//        aa.append(":");
//        aa.append(getCcc());
//        aa.append(":");
//        aa.append(getDdd());
        return aa.toString();
    }


    private int aaa;

//    private int bbb;
//
//    private int ccc;
//
//    private int ddd;

//    public int getCcc() {
//        return ccc;
//    }
//
//    public void setCcc(int ccc) {
//        this.ccc = ccc;
//    }
//
//    public int getDdd() {
//        return ddd;
//    }
//
//    public void setDdd(int ddd) {
//        this.ddd = ddd;
//    }
//
//    public int getBbb() {
//        return bbb;
//    }
//
//    public void setBbb(int bbb) {
//        this.bbb = bbb;
//    }
//
    public int getAaa() {
        return aaa;
    }

    public void setAaa(int aaa) {
        this.aaa = aaa;
    }

    public Object[] zdata(){

        return null;
    }
}
