package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public void ReadBreakfastMenu() {
        try {
            File breakfastMenuXmlFile = new File("D:\\Devops\\xmls\\breakfast_menu.xml");
            XStream xStream = new XStream();
            Food sampleFood = (Food) xStream.fromXML(breakfastMenuXmlFile);
            System.out.println(sampleFood.toString());
        } catch (Exception e) {
            System.out.println("Exception found: " + e.getClass().getCanonicalName());
        }
    }

    public void ReadPerson() {
        try {
            String filePath = "D:/Devops/xmls/person.xml";
            String content = new String (Files.readAllBytes( Paths.get(filePath) ));
            XStream xs = new XStream();
            xs.alias("person", Person.class);

            Person newPerson = (Person) xs.fromXML(content);

            System.out.println(newPerson.getFirstname());
            System.out.println(newPerson.getLastname());
            System.out.println(newPerson.getPhone().getCode());
            System.out.println(newPerson.getPhone().getNumber());
            System.out.println(newPerson.getFax().getCode());
            System.out.println(newPerson.getFax().getNumber());

        } catch (Exception e) {
            System.out.println("Exception found: " + e.getClass().getCanonicalName());
            System.out.println(e.getStackTrace());
            e.printStackTrace();
        }
    }

}
