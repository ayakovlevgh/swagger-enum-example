package com.example;

import com.fasterxml.jackson.databind.SerializationFeature;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import io.swagger.util.Json;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyApplication extends ResourceConfig {

    private static final String PACKAGE = "com.example";

    public JerseyApplication() {
        register(JacksonFeature.class);
        packages(true, PACKAGE);
        initSwagger();
    }

    private void initSwagger() {
        register(ApiListingResource.class);
        register(SwaggerSerializers.class);

        Json.mapper().configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);

        final BeanConfig beanConfig = new BeanConfig();
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage(PACKAGE);
        beanConfig.setScan(true);
    }

}
