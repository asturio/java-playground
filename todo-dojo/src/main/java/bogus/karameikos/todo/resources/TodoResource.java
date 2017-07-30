package bogus.karameikos.todo.resources;

import bogus.karameikos.todo.model.Todo;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Path("todo")
public class TodoResource {

    private static final Logger logger = Logger.getLogger(TodoResource.class.getName());
    private static final List<Todo> todoList = new ArrayList<>();
    private static int maxId = 0;
    @Context
    @SuppressWarnings("unused")
    private UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Todo todo) {
        if (todo == null) {
            return Response.serverError().status(Response.Status.NOT_FOUND).build();
        } else {
            synchronized (todoList) {
                todoList.add(todo);
                todo.setId(++maxId);
            }
            final String path = uriInfo.getPath() + "/" + Integer.toString(todo.getId());
            URI todoUri = uriInfo.getAbsolutePath().resolve(path);
            logger.info("todoList = " + todoList);
            return Response.created(todoUri).build();
        }
    }

    @GET
    @Path("size")
    public int count() {
        return todoList.size();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getAll() {
        return todoList;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Todo get(@PathParam("id") int id) {
        // nicht implementiert
        return null;
    }

}
