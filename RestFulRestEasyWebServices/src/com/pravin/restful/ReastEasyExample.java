package com.pravin.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/publish")
public class ReastEasyExample {
	@GET
	@Path("{message}")
	public Response publishMessage(@PathParam("message") String msgStr) {
		String responseStr = "Response Message :: " + msgStr;
		return Response.status(200).entity(responseStr).build();
	}
}
