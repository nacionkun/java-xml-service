package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * XML Reader/Writer class
 *
 */
public class XMLHandler
{
    /**
     * XStream object to be used for all class methods
     */
    private XStream xStreamObject;

    /**
     * Default constructor
     */
    public void XMLHandler() {
        //empty
    }

    public XMLHandler(Class<?>[] classes) {
        xStreamObject = createXStreamInstance(classes);
    }

    /**
     * For use in debug mode
     * @param args
     */
    public static void main(String[] args) {
        Class<?>[] classes = new Class[] { Person.class, PhoneNumber.class, Food.class };
        XMLHandler xmlHandler = new XMLHandler(classes);
        xmlHandler.ReadPerson();
    }

    private XStream createXStreamInstance(Class<?>[] classes) {
        XStream xs = new XStream();
        XStream.setupDefaultSecurity(xs);
        xs.allowTypes(classes);
        return xs;
    }

    /**
     * Get XStream object
     * @return XStream object
     */
    public XStream getXStreamObject() {
        return xStreamObject;
    }

    /**
     * Read file and return content
     * @param filePath String path of file
     * @return String content of file
     */
    public String readFile(String filePath) {
        String content = "";
        try {
            content = new String (Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException ioe) {
            System.out.println("Error opening the file!: " + ioe.getMessage());
        }

        return content;
    }

//    public void ReadBreakfastMenu() {
//        try {
//            String filePath = "D:/Devops/xmls/breakfast_menu.xml";
//            String content = new String (Files.readAllBytes( Paths.get(filePath) ));
//            XStream xStream = new XStream();
//            Food sampleFood = (Food) xStream.fromXML(content);
//            System.out.println(sampleFood.toString());
//        } catch (Exception e) {
//            System.out.println("Exception found: " + e.getClass().getCanonicalName());
//        }
//    }

    /**
     * Read person.xml file and prints the output
     */
    public void ReadPerson() {
        try {
            String filePath = "D:/Devops/xmls/person.xml";
            String content = readFile(filePath);
            Class<?>[] classes = new Class[] { Person.class, PhoneNumber.class, Food.class };

            XStream xStream = getXStreamObject();
            if (xStream != null) {
                xStream.alias("person", Person.class);
                Person newPerson = (Person) xStream.fromXML(content);

                System.out.println(newPerson.getFirstname());
                System.out.println(newPerson.getLastname());
                System.out.println(newPerson.getPhone().getCode());
                System.out.println(newPerson.getPhone().getNumber());
                System.out.println(newPerson.getFax().getCode());
                System.out.println(newPerson.getFax().getNumber());
            } else {
                System.out.println("XStream object does not exist!");
            }

        } catch (Exception e) {
            System.out.println("Exception found: " + e.getClass().getCanonicalName());
            //e.printStackTrace();
        }
    }

}
