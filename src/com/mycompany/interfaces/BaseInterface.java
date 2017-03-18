package com.mycompany.interfaces;

/**
 * Created by Fei Chen on 3/11/2017.
 */
public class BaseInterface
{
    private String name;
    private InterfaceType type;

    BaseInterface(String name, InterfaceType type)
    {
        this.name = name;
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public InterfaceType getType()
    {
        return type;
    }
}
