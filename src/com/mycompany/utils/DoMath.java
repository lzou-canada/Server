package com.mycompany.utils;

public class DoMath
{
    // define an interface
    public interface IntegerMath
    {
        public int doMathOperation(int a, int b);
    }

    public  int mathOperation (int a1, int a2, int a3, int a4, IntegerMath intMath)
    {
        return intMath.doMathOperation(a2, a4);
    }
}
