package com.mycompany.interfaces;

/**
 * Created by Fei Chen on 3/11/2017.
 */
public class L2Interface extends BaseInterface
{
    public L2Interface(String name)
    {
        super(name, InterfaceType.INTERFACE_TYPE_L2);
    }

    protected L2Interface(String name, InterfaceType type)
    {
        super(name, type);
    }
}
