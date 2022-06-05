package edu.upc.eetac.dsa.services;

import edu.upc.eetac.dsa.dao.FAQDAO;
import edu.upc.eetac.dsa.dao.UserDAO;
import edu.upc.eetac.dsa.dao.impl.FAQDAOImpl;
import edu.upc.eetac.dsa.dao.impl.InventoryDAOImpl;
import edu.upc.eetac.dsa.dao.impl.UserDAOImpl;
import edu.upc.eetac.dsa.models.FAQ;
import edu.upc.eetac.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
@Api(value = "/FAQ", description = "Endpoint to FAQ Service")
@Path("/FAQ")
public class FAQService {
    private FAQDAO FAQManager;
    public FAQService() {
        this.FAQManager = FAQDAOImpl.getInstance();
        FAQ testFAQ1 = new FAQ("Pregunta1", "Respuesta1");
        FAQ testFAQ2 = new FAQ("Pregunta2", "Respuesta2");
        FAQManager.addFAQ(testFAQ1);
        FAQManager.addFAQ(testFAQ2);
    }
    @GET
    @ApiOperation(value = "Get all FAQ", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
    })
    @Path("/FAQList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFAQ() {

        ArrayList<FAQ> FAQList = this.FAQManager.getAllFAQ();
        GenericEntity<ArrayList<FAQ>> entity = new GenericEntity<ArrayList<FAQ>>(FAQList) {};
        return Response.status(201).entity(entity).build();
    }
}
