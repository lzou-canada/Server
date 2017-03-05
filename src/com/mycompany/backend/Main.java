package com.mycompany.backend;

/**
 * Created by Fei Chen on 2/26/2017.
 */
public class Main
{
    // add B3 to move the master branch
    // add B2 to move the master branch
    // add B1 to move the master branch
    // add line B5 to move the master
    public static void main(String[] args)
    {
        // add line A5 to move the PTS-200
        // add line A4 to move the PTS-200
        // add line B3 to move the master
        // add line A2 to move the PTS-200
        // add line A1 to move the master
        // add line B2 to move the master
        // add line B1 to move the master
        // add one line to the Server module
        // add one line here
        int a = 15;
        int b = 20;

        // add line B5 to further move the master
        // add line B4 to move the master
        // add A2 to move the PTS-200
        // add A1 to move the PTS-200
        for ( int i = 0; i < a; i++ )
        {
            for ( int j = 0; j < b; j++ )
            {
                int lTotalValue = getSum(a, b);
                System.out.println("total value: " + lTotalValue);
            }
        }

        System.out.println("Hello World!");
    }

    private static int getSum(int a, int b)
    {
        return a + b;
    }

}
