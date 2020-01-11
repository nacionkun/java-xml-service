package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    //@Test
    public void TestReadBreakfast() {
        App testApp = new App();
        testApp.ReadBreakfastMenu();
    }

    @Test
    public void TestReadPerson() {
        App testApp = new App();
        testApp.ReadPerson();
    }
}
