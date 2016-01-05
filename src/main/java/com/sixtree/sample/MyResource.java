package com.sixtree.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    private static final Logger log = LogManager.getLogger(MyResource.class);

    private static String message = "Original Message";

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        log.info("getMessage");
        return message;
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void updateMessage(@NotNull String string) {
        message = string;
        log.info("updateMessage to "+message);
    }

    @Path("subresource")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSubMessage() {
        log.info("getSubMessage");
        return "Subresource: " + message;
    }
}
