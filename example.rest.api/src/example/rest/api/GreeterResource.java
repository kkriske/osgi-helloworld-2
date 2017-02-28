package example.rest.api;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.osgi.annotation.versioning.ProviderType;

@Path("/hello")
@ProviderType
public interface GreeterResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	String hello(@QueryParam("name") @DefaultValue("World") String name);

}
