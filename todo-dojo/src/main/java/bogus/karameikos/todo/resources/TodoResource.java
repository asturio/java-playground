package bogus.karameikos.todo.resources;

import bogus.karameikos.todo.model.Todo;
import bogus.karameikos.todo.model.TodoPseudoDao;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

@Path("todo")
public class TodoResource {

    private static final Logger logger = Logger.getLogger(TodoResource.class.getName());
    private static final TodoPseudoDao dao = new TodoPseudoDao();

    // Just a hack
    static {
        Todo todo = new Todo();
        todo.setName("Todo1");
        todo.setBeschreibung("Test Todo1.");
        dao.add(todo);
        todo.setName("Todo2");
        todo.setBeschreibung("Test Todo2.");
        dao.add(todo);
        todo.setName("Todo3");
        todo.setBeschreibung("Test Todo3.");
        dao.add(todo);
    }

    @Context
    private UriInfo uriInfo = null;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Todo todo) {
        if (todo == null) {
            return Response.serverError().status(Response.Status.NOT_FOUND).build();
        } else {
            dao.add(todo);
            final String path = uriInfo.getPath() + "/" + Integer.toString(todo.getId());
            URI todoUri = uriInfo.getAbsolutePath().resolve(path);
            logger.info("todoList = " + dao);
            return Response.created(todoUri).build();
        }
    }

    @GET
    @Path("size")
    public int count() {
        return dao.size();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getAll() {
        return dao.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Todo get(@PathParam("id") int id) {
        // nicht implementiert
        return null;
    }

}
