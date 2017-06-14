package bogus.karameikos.swagger.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("family")
public class FamilyResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getone")
    public Person getOne() {
        Person person = new Person();
        person.setName("Max", "Musterman");

        Person child = new Person();
        child.setName("Maxi", "Musterkind");
        person.addChild(child);
        return person;
    }
}
