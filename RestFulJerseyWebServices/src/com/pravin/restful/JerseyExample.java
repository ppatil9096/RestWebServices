package com.pravin.restful;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * 
 * @author ppp
 *
 */
@Path("/publish")
public class JerseyExample {

	/**********************************************
	 * ****Dynamic URI with parameter matching*****
	 * ******************************************** Anything between "{" and "}"
	 * braces can be dynamic
	 * 
	 * This method will return Response object
	 * 
	 * @param msgString
	 * @return
	 */
	@GET
	@Path("{message}")
	public Response publishMessag(@PathParam("message") String msgString) {

		String responseString = "Received Dynamic Message :: " + msgString;
		return Response.status(200).entity(responseString).build();
	}

	/**********************************************
	 * **** Default URI Pattern matching*****
	 * ******************************************** If you use "/publish" URI
	 * pattern,this method will be invoked
	 */
	@GET
	public Response displayMessage() {
		String displayMsg = "Default Message";
		return Response.status(200).entity(displayMsg).build();
	}

	/**********************************************
	 * **** Given/Mentioned/Strict URI Pattern matching*****
	 * ******************************************* If you use
	 * "/publish/strictpath" URI pattern,this method will be invoked
	 */
	@GET
	@Path("/strictpath")
	public Response strictPathMsg() {
		return Response.status(200).entity("Strict URL Message").build();
	}

	/*************************************************
	 * **** Regular Expression Default URI Pattern matching***
	 ************************************************
	 * Default method on RegEx
	 **/
	@GET
	@Path("{studentId:[0-9]+}")
	public Response getStudentById(@PathParam("studentId") String studentID) {
		return Response.status(200).entity("Student with ID :: " + studentID).build();
	}

	/*************************************************
	 * **** Regular Expression with given URI Pattern matching***
	 ************************************************
	 **/
	@GET
	@Path("/regex/name/{studentName: [a-zA-Z\\s]+}")
	public Response getStudentByName(@PathParam("studentName") String studentName) {
		return Response.status(200).entity("Student wih Name :: " + studentName).build();
	}

	@GET
	@Path("{branch}/{department}")
	public Response getEmployeeList(@PathParam("branch") String branchName, @PathParam("department") String deptName) {
		return Response.status(200)
				.entity("Total number of employees in the " + deptName + " department from " + branchName + " is 100")
				.build();
	}

	@GET
	@Path("/query")
	public Response getEmployeeQuery(@QueryParam("dept") String dept, @QueryParam("branch") String branch) {
		return Response.status(200)
				.entity("Query parameters are received. 'dept' value is: " + dept + " and branch value is: " + branch)
				.build();
	}

	@GET
	@Path("/query")
	public Response getEmployeeQueryDefault(@DefaultValue("accounts") @QueryParam("dept") String dept,
			@DefaultValue("pune") @QueryParam("bramch") String branch) {
		return Response.status(200)
				.entity("Query parameters are received. 'dept' value is: " + dept + " and branch value is: " + branch)
				.build();
	}

}
