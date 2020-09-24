package org.nick;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/tasks")
public class TaskResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Task> getTasks(@QueryParam("name") String name) {
    if (name == null) {
      return Task.listAll();
    } else {
      return Task.findByName(name);
    }
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public Response saveTask(Task task) {
    task.persist();
    return Response.status(Status.CREATED).entity(task).build();
  }
}
