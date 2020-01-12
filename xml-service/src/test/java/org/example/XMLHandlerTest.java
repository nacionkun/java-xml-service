package org.example;

import org.testng.annotations.Test;

/**
 * Unit test XMLHandler class.
 */
public class XMLHandlerTest
{
    /**
     * Rigorous Test :-)
     */

    @Test(enabled=false)
    public void TestReadBreakfast() {
        //XMLHandler xmlHandler = new XMLHandler();
        //xmlHandler.ReadBreakfastMenu();
    }

    @Test
    public void TestReadPerson() {
        Class<?>[] classes = new Class[] { Person.class, PhoneNumber.class, Food.class };
        XMLHandler xmlHandler = new XMLHandler(classes);
        xmlHandler.ReadPerson();
    }
}
