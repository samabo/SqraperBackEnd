package com.qien.sqraper.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.qien.sqraper.api.SqraperEndpoint;
import com.qien.sqraper.api.StudentEndpoint;
import com.qien.sqraper.api.VacatureEndpoint;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(StudentEndpoint.class);
		register(VacatureEndpoint.class);
		register(SqraperEndpoint.class);
	}

}