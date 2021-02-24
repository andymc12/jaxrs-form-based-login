package io.openliberty.jaxrs.formbasedlogin;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/notSecuredHello")
@Produces(MediaType.TEXT_PLAIN)
public class NotSecuredResource {

    @Context
    SecurityContext securityContext;

    @GET
    public String notSecuredHello() {
        String name = securityContext.getUserPrincipal() == null ? "null" : securityContext.getUserPrincipal().getName();
        return "Hello (not-secured) " + name;
    }
}
