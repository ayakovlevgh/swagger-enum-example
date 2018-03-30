package com.example;

import io.swagger.annotations.Api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(tags = "hello")
@Path("/hello")
public class HelloResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(final TestDto testDto) {
        return Response.ok(testDto).build();
    }

    public static class TestDto {

        private Rank rank;

        public Rank getRank() {
            return rank;
        }

        public void setRank(final Rank rank) {
            this.rank = rank;
        }
    }
}
