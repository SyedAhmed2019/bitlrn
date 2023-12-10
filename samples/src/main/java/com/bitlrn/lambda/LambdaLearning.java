package com.bitlrn.lambda;

public class LambdaLearning {
    public static void main(String[] args) {
        MyLambdaInterface lambdaInterface = (i, t) -> System.out.println("first try -" + i + " with " + t);
        lambdaInterface.apply("nice!", "param-2");
        //lambdaInterface.
    }
}
