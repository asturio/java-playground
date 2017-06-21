package bogus.karameikos.swagger.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
    private String firstName;
    private String lastName;
    private List<Person> children;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public List<Person> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Person child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
    }
}
