package edu.upc.eetac.dsa.services;

import edu.upc.eetac.dsa.dao.UserDAO;
import edu.upc.eetac.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/user", description = "Endpoint to User Service")
@Path("/user")
public class UserService {
    private UserDAO userManager;

    public UserService() {
        User testUser1 = new User("Irene","irene1234","irene@upc.com");
        User testUser2 = new User("Adrian", "adrian1234", "adrian@upc.com");

        this.userManager.addUser(testUser1.getName(), testUser1.getPassword(), testUser1.getEmail());
        this.userManager.addUser(testUser2.getName(), testUser2.getPassword(), testUser2.getEmail());
    }

    @Path("basic")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    // sign up NEW user
    @POST
    @ApiOperation(value = "User sign up", notes = "username + password + email")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response= User.class),
            @ApiResponse(code = 402, message = "Username or email already in use", response= User.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/addUser/{username}/{password}/{email}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response userSignUp(@PathParam("username") String username, @PathParam("password") String password, @PathParam("email") String email) {

        User user = new User(username, password, email);
        if (user.getName().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty())
            return Response.status(500).entity(user).build();
        this.userManager.addUser(user.getName(), user.getEmail(), user.getPassword());
        User newUser = userManager.getUserByName(username);
        if(!newUser.getName().equals(user.getName()) || !newUser.getEmail().equals(user.getName()))
            return Response.status(402).entity(user).build();
        return Response.status(200).entity(user).build();
    }

    // get ONE particular user
    @GET
    @ApiOperation(value = "Get a particular User", notes = "username")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("username") String username) {

        User user = userManager.getUserByName(username);
        if (user == null) {
            return Response.status(404).build();
        } else {
            GenericEntity<User> entity = new GenericEntity<User>(user) {};
            return Response.status(200).entity(entity).build();
        }
    }

    // get ALL signed up users
    @GET
    @ApiOperation(value = "Get all signed up Users", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class, responseContainer="List"),
    })
    @Path("/userList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {

        List<User> userList = this.userManager.getAllUsers();
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(userList) {};
        return Response.status(200).entity(entity).build();
    }

    // LOGIN user
    @POST
    @ApiOperation(value = "LogIn User", notes = "Name and Password")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 405, message = "Wrong password"),
            @ApiResponse(code = 500, message = "Invalid inputs")
    })
    @Path("/logIn/{username}/{password}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logInUser(@PathParam("username") String username, @PathParam("password")String password) {

        User user = userManager.getUserByName(username);
        if ((username.isEmpty()) || (password.isEmpty()))
            return Response.status(500).build();
        else if (user == null)
            return Response.status(404).build();
        else {
            if (user.getPassword().equals(password))
                return Response.status(200).entity(user).build();
            else
                return Response.status(405).build();
        }
    }

    // actualize/modify/UPDATE user
    @PUT
    @ApiOperation(value = "Update User information", notes = "userName, password and email")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/update/{oldUsername}/{username}/{password}/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("oldUsername") String oldUsername, @PathParam("username") String username, @PathParam("password") String password, @PathParam("email") String email) {

        User oldUser = userManager.getUserByName(oldUsername);
        if (username.isEmpty() || password.isEmpty() || email.isEmpty())
            return Response.status(500).build();
        else {
            if (oldUser == null) {
                return Response.status(404).build();
            } else {
                userManager.updateUser(oldUsername, username, password, email);
                return Response.status(200).entity(oldUser).build();
            }
        }
    }

    // DELETE user
    @DELETE
    @ApiOperation(value = "Delete a User", notes = "Name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/delete/{username}")
    public Response deleteUser(@PathParam("username") String username) {

        User user = userManager.getUserByName(username);
        if (!user.getId().isEmpty()) {
            userManager.deleteUser(username);
            return Response.status(200).entity(user).build();
        }
        return Response.status(404).build();
    }
}
