package edu.upc.eetac.dsa.services;

import edu.upc.eetac.dsa.dao.GameDAO;
import edu.upc.eetac.dsa.dao.UserDAO;
import edu.upc.eetac.dsa.dao.impl.GameDAOImpl;
import edu.upc.eetac.dsa.dao.impl.UserDAOImpl;
import edu.upc.eetac.dsa.models.Game;
import edu.upc.eetac.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.beans.IntrospectionException;

@Api(value = "/game", description = "Endpoint to Game Service")
@Path("/game")
public class GameService {
    private GameDAO manager;
    private UserDAO userManager;

    public GameService() {
        this.manager = GameDAOImpl.getInstance();
        this.userManager = UserDAOImpl.getInstance();
    }

    @Path("basic")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    // GET a user's game --> OK
    @GET
    @ApiOperation(value = "Get a user's current game", notes = "if none, creates")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Game.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("getGame/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserGame(@PathParam("username") String username) {

        User user = userManager.getUserByName(username);
        if (user == null) {
            return Response.status(404).build();
        } else {
            Game game = this.manager.getActiveUserGame(username);
            GenericEntity<Game> entity = new GenericEntity<Game>(game) {};
            return Response.status(200).entity(entity).build();
        }
    }

    // SAVE game --> OK
    @PUT
    @ApiOperation(value = "save a user's game", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class)
    })
    @Path("/saveGame")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveGame(Game game) throws IntrospectionException {

        User user = this.userManager.getUserById(game.getUserId());

        this.manager.updateGame(game, user.getName());
        return Response.status(200).entity(game).build();
    }

}
