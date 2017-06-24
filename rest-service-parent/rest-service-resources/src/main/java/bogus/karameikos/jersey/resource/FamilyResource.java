package bogus.karameikos.jersey.resource;

import bogus.karameikos.jersey.model.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;

@Path("family")
public class FamilyResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getone")
    public Person getOne() {
        Person person = new Person();
        person.setFirstName("Max");
        person.setLastName("Musterman");

        Person child = new Person();
        child.setFirstName("Maxi");
        child.setLastName("Musterkind");
        person.setChildren(Collections.singletonList(child));
        return person;
    }
}
