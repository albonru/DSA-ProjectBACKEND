package edu.upc.eetac.dsa.services;

import edu.upc.eetac.dsa.dao.ItemDAO;
import edu.upc.eetac.dsa.dao.ItemDAOImpl;
import edu.upc.eetac.dsa.dao.UserDAO;
import edu.upc.eetac.dsa.dao.UserDAOImpl;
import edu.upc.eetac.dsa.models.Item;
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

@Api(value = "/item", description = "Endpoint to Item Service")
@Path("/item")
public class ItemService {

    private ItemDAO itemManager;
    private UserDAO userManager;

    public ItemService() {
        this.itemManager = ItemDAOImpl.getInstance();
        this.userManager = UserDAOImpl.getInstance();
        Item weapon = new Item("Gun","Ranged weapon",100,"Weapon",7,0);
        Item armor = new Item("Shield","Slightly increases defense",75,"Armor",0,10);
        Item skin = new Item("Luigi","Alter your appearance to look like Luigi",400,"Skin",0,0);

        this.itemManager.addItem(weapon);
        this.itemManager.addItem(armor);
        this.itemManager.addItem(skin);

        this.itemManager.addToStore(weapon.getName());
        this.itemManager.addToStore(armor.getName());
        this.itemManager.addToStore(skin.getName());

        //this.itemManager.addToUser("Irene", "Gun");

    }

    @Path("basic")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    // get ALL items from the store --> FUNCIONA
    @GET
    @ApiOperation(value = "Get all items in store", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Item.class, responseContainer="List"),
    })
    @Path("/storeList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStoreItems() {

        List<Item> storeList = this.itemManager.getStoreList();
        GenericEntity<List<Item>> entity = new GenericEntity<List<Item>>(storeList) {};
        return Response.status(200).entity(entity).build();
    }

    //get ALL items from a user's inventory --> NO FUNCIONA
    @GET
    @ApiOperation(value = "Get a particular User's inventory", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Item.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("inventoryList/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInventoryList(@PathParam("username") String username) {

        User user = userManager.getUserByName(username);
        if (user == null) {
            return Response.status(404).build();
        } else {
            List<Item> storeList = this.itemManager.getInventory(user.getName());
            GenericEntity<List<Item>> entity = new GenericEntity<List<Item>>(storeList) {};
            return Response.status(200).entity(entity).build();
        }
    }

    // buy item from store --> A MEDIAS
    @PUT
    @ApiOperation(value = "Buy an Item", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 402, message = "Not enough coins"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 405, message = "Item not found"),
            @ApiResponse(code = 409, message = "Item is already in possession")
    })
    @Path("/buyItem/{itemName}/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buyItem(@PathParam("item") String item, @PathParam("username") String username) {


        return null;
    }
}
