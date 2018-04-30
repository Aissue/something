package newInterface.impl;

import newInterface.myInterface;

public class myInterfaceImpl implements myInterface {

    @Override
    public String normal1(String str) {
        return "normal1's impl :"+str;
    }

    @Override
    public String normal2() {
        return "normal2's impl ";
    }

    @Override
    public String test(){
        return "override default test";
    }
}
