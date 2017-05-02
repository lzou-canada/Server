package com.mycompany.interfaces;

/**
 * Created by Fei Chen on 3/11/2017.
 */
public class TdmInterface extends BaseInterface
{
    // add one line her for reference
    public TdmInterface(String name)
    {
        // add one line here to test conflict issue
        super(name, InterfaceType.INTERFACE_TYPE_TDM);
    }
}
