package by.avmiz.service;

import by.avmiz.valueobject.CallVO;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Base interface for interaction with client throw service.
 *
 * @author avmiz created 08.02.2016 at 15:49.
 */
@Path("/callService")
public interface CallService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addCall")
    Response addCall(@Valid CallVO call);
}
