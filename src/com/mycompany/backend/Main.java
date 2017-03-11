package com.mycompany.backend;

import com.mycompany.utils.DoMath;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by Fei Chen on 2/26/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        List<String> lList = new ArrayList<>();
        lList.add("One");
        lList.add("Two");
        lList.add("Three");
        lList.add("Four");
        lList.add("Five");

        lList.stream()
                .filter(i -> i.startsWith("F"))
                .forEach(i -> System.out.println(i.toUpperCase()));
        System.out.println("Done");

        // do some math here
        int a1 = 1;
        int a2 = 2;
        int a3 = 3;
        int a4 = 4;

        DoMath lDoMath = new DoMath();

        // do addition
        int c = lDoMath.mathOperation(a1, a2, a3, a4, new DoMath.IntegerMath() {
            @Override
            public int doMathOperation(int a, int b)
            {
                return a + b;
            }
        });

        // do multiplication
        c = lDoMath.mathOperation(a1, a2, a3, a4, new DoMath.IntegerMath() {
            @Override
            public int doMathOperation(int a, int b)
            {
                return a * b;
            }
        });

        // now use lambda expression for the same functionality

        // This lambda expression is very powerful !!!
        // and very easy to use ...

        // do addition
        DoMath.IntegerMath lAddition = (a, b) -> a + b;

        // do multiplication
        DoMath.IntegerMath lMultiplication = (a, b) -> a * b;

        // do math addition
        c = lDoMath.mathOperation(a1, a2, a3, a4, lAddition);

        // do math multiplication
        c = lDoMath.mathOperation(a1, a2, a3, a4, lMultiplication);

        // It is very easy to define any type of operation a user might want to do
        // do something fancy here
        DoMath.IntegerMath lDoSomeSortOfOperation = (a, b) -> {
            // do something fancy here
            int result = 0;
            for ( int i = a; i < b; i++ )
            {
                result += i;
            }
            return result;
        };

        // do some sort of arbitrary math operation
        c = lDoMath.mathOperation(a1, a2, a3, a4, lDoSomeSortOfOperation);

        System.out.println("Done");
    }

}
