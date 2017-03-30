package com.mycompany.backend;

import com.mycompany.interfaces.*;
import com.mycompany.utils.DoMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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

        // added one line here to test the new IntelliJ IDE
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

        // add one line here

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

        // would like to test some Functional interfaces, such as Consumer
        Consumer<? super Object> lMyIntegerConsumer = (a) -> {
            String lObjectType = "The input is a type of ";

            if ( a instanceof String )
            {
                lObjectType += "String";
            }
            else if ( a instanceof Integer )
            {
                lObjectType += "Integer";
            }
            else
            {
                lObjectType += "Object";
            }
            System.out.println(lObjectType + ", it is \"" + a + "\"");
        };

        lMyIntegerConsumer.accept("Whatever it is ...");

        lMyIntegerConsumer.accept(12345);

        System.out.println("Done");

        // test some other things of interest
        List<? super Number> lMyList = new ArrayList<>();

        lMyList.add(new Integer(4));
        lMyList.add(new Integer(5));

        Number lNumber = new Integer(6);
        lMyList.add(lNumber);

        lMyList.add(new Long(9));
        lMyList.add(new Double(3.14));

        lMyList.add(new Float(6.28));

        lMyList.stream()
               .filter(i -> ((Number) i).intValue() >= 5 && ((Number)i).intValue() < 9 )
               .forEach(i -> System.out.println("Element is: " + i));

        Number[] lNumberArray = new Number[10];
        lNumberArray[0] = new Float(3.14);
        lNumberArray[1] = 6.28;

        Arrays.stream(lNumberArray).forEach(i -> System.out.println("Element: " + i));

        List<? super BaseInterface> lInterfaces = new ArrayList<>();

        for ( int i = 0; i < 10; i++ )
        {
            if ( i < 5 )
            {
                lInterfaces.add(new L3Interface("L3 VPN-" + i));
            }
            else if ( i < 8 )
            {
                lInterfaces.add(new L2Interface("L2 Int-" + i));
            }
            else
            {
                lInterfaces.add(new TdmInterface("TDM Int-" + i));
            }
        }

        List<? super BaseInterface> aResultInterfaceList = ProcessInterface(lInterfaces);

        System.out.println("\n========================\n");

        // lambda expression and its aggregate operations are very easy to use

        aResultInterfaceList.stream()
                .filter(i -> {
                    if ( i instanceof BaseInterface )
                    {
                        BaseInterface lBaseInterface = (BaseInterface)i;
                        if ( lBaseInterface.getType() == InterfaceType.INTERFACE_TYPE_TDM )
                        {
                            return true;
                        }
                    }
                    return false;
                })
                .forEach(p -> System.out.println("Interface name (" + ((BaseInterface)p).getName() + ")"));

        System.out.println("Done");

        Long[] lLongList = new Long[10];

        for ( int i = 0; i < 10; i++ )
        {
            lLongList[i] = new Long(i + 1);
        }

        long lSum = Arrays.stream(lLongList).reduce(1L, (r, e) -> r * e);

        Arrays.stream(lLongList)
                .forEach(e -> System.out.println("Integer: " + e));

        System.out.println("\n===================\n");

        Arrays.stream(lLongList)
                .map(e -> e % 3)
                .forEach(e -> System.out.println("Integer: " + e));

        long lSum2 = Arrays
                .stream(lLongList)
                .map(e -> e * 3)
                .filter(e -> e % 2 != 0 )
                .reduce(0L, (r,e) -> r + e);

        String[] lStrings = {"This", "is", "a", "sentence", "."};
        String lResult = Arrays.stream(lStrings)
                .map(e -> e.toUpperCase())
                .reduce("", (r,e) -> {
            if ( !e.endsWith(".") )
            {
                r += " " + e;
            }
            else
            {
                r += e;
            }
            return r;
        });
        System.out.println(lResult);
    }

    public static void Print(String aString, Consumer<String> consumer)
    {
        consumer.accept(aString);
    }

    public static List<? super BaseInterface> ProcessInterface(List<? super BaseInterface> aInInterfaces)
    {
        for ( int i = 0; i < aInInterfaces.size(); i++ )
        {
            BaseInterface lBaseInterface = (BaseInterface) aInInterfaces.get(i);
            System.out.println("Interface: name (" + lBaseInterface.getName() +
                "), type (" + lBaseInterface.getType() + ")");
        }

        for ( int i = 0; i < 10; i++ )
        {
            aInInterfaces.add(new L3Interface("Test_L3VPN-" + i));
        }

        return aInInterfaces;
    }

}
