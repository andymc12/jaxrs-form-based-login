package io.openliberty.jaxrs.formbasedlogin;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

/**
 *
 */
@Path("/hello")
@Singleton
@Produces(MediaType.TEXT_PLAIN)
public class Resource {

    @Context
    SecurityContext securityContext;

    @PermitAll
    @GET
    public String sayHello() {
        return "Hello " + securityContext.getUserPrincipal().getName();
    }

    @Path("/group1only")
    @RolesAllowed("group1")
    @GET
    public String exclusive() {
        return "Hello group1 member - only members of group1 may access this page.";
    }
}
