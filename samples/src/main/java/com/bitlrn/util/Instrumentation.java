package com.bitlrn.util;

public class Instrumentation {
    private String name;
    private int iteration;
    public Instrumentation(){
    }
    public void increment(){
        ++iteration;
    }
    public int getIterationCount(){
        return iteration;
    }
    public void reset(String newName){
        this.name = newName;
        iteration = 0;
    }
}
