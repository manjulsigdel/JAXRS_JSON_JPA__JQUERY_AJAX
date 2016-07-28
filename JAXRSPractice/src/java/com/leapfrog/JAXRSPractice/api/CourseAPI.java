package com.leapfrog.JAXRSPractice.api;

import com.leapfrog.JAXRSPractice.dao.CourseDAO;
import com.leapfrog.JAXRSPractice.dao.impl.CourseDAOImpl;
import com.leapfrog.JAXRSPractice.entity.Course;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * REST Web Service
 *
 * @author Manjul Sigdel
 */
@Path(value = "/course")
public class CourseAPI {

    private CourseDAO courseDAO = new CourseDAOImpl();

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Course> index() {
        return courseDAO.getAll();

    }

    @Path(value = "/{id}")
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Course index1(@PathParam("id") int id) {
        return courseDAO.getByID(id);
    }

    @Path(value = "/save")
    @POST
    @Consumes(value = MediaType.APPLICATION_FORM_URLENCODED)
    public String save(@FormParam("name")String name,@FormParam("fees")int fees,@FormParam("duration")int duration,@FormParam("duration_type")String durationType,@FormParam("status")boolean status){
        Course c = new Course();
        c.setName(name);
        c.setFees(fees);
        c.setDuration(duration);
        c.setDurationType(durationType);
        c.setStatus(status);
        courseDAO.insert(c);
        return "success";
    }
}
