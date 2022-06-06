package edu.upc.eetac.dsa.services;

import edu.upc.eetac.dsa.dao.FAQDAO;
import edu.upc.eetac.dsa.dao.QuestionDAO;
import edu.upc.eetac.dsa.dao.UserDAO;
import edu.upc.eetac.dsa.dao.impl.FAQDAOImpl;
import edu.upc.eetac.dsa.dao.impl.QuestionDAOImpl;
import edu.upc.eetac.dsa.dao.impl.UserDAOImpl;
import edu.upc.eetac.dsa.models.FAQ;
import edu.upc.eetac.dsa.models.Issue;
import edu.upc.eetac.dsa.models.Question;
import edu.upc.eetac.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Api(value = "/techhelp", description = "Endpoint to Technical Help Service")
@Path("/techhelp")
public class TechHelpService {

    private QuestionDAO manager;
    private UserDAO userManager;
    private FAQDAO FAQmanager;

    public TechHelpService() {
        this.manager = QuestionDAOImpl.getInstance();
        this.userManager = UserDAOImpl.getInstance();
        this.FAQmanager = FAQDAOImpl.getInstance();
    }

    // ask a question -> ALBA OK NO BBDD
    @POST
    @ApiOperation(value = "ask question", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response= Question.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/question")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addQuestion(Question q) {

        Question question = new Question(q.getDate(), q.getTitle(), q.getMessage(), q.getSender());
        if (question.getDate().isEmpty() || question.getTitle().isEmpty() || question.getMessage().isEmpty() || question.getSender().isEmpty())
            return Response.status(500).entity(question).build();

        else {
            this.manager.addQuestion(question);
            return Response.status(200).entity(question).build();
        }
    }

    // denounce an issue -> IRENE OK NO BBDD
    @POST
    @ApiOperation(value = "denounce issue", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Error")
    })
    @Path("/issue")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response denuncia(Issue issue) {

        User user = userManager.getUserByName(issue.getInformer());

        if (issue.getDate().isEmpty() || issue.getInformer().isEmpty() || issue.getMessage().isEmpty() ) {
            return Response.status(500).build();
        } else if (user == null) {
            return Response.status(404).build();
        }
        issue.setDate(issue.getDate());
        issue.setInformer(issue.getInformer());
        issue.setMessage(issue.getMessage());

        return Response.status(200).entity(issue).build();
    }

    // GET all FAQ -> ALVARO OK NO BBDD
    @GET
    @ApiOperation(value = "Get all FAQ", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
    })
    @Path("/FAQList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFAQ() {

        ArrayList<FAQ> FAQList = this.FAQmanager.getAllFAQ();
        GenericEntity<ArrayList<FAQ>> entity = new GenericEntity<ArrayList<FAQ>>(FAQList) {};
        return Response.status(201).entity(entity).build();
    }

}
