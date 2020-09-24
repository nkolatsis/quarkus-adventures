package org.nick;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class HelloResource {

    @Inject
	@RestClient
    ReverseService reverseService;

    @GET
    @Path("/{word}")
    @Produces(MediaType.TEXT_PLAIN)
    @Fallback(fallbackMethod = "reverseFallback")
    public String reverse(@PathParam("word") String word) {
        return reverseService.reverse(word);
    }

    private String reverseFallback(String name) {
        return "The fallback method has been invoked.";
    }


    @ConfigProperty(name = "greeting")
    String greeting;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greeting + " friend";
    }
    


}