/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.incomeBank.ws.rest;

import com.incomeBank.ws.rest.util.feature.JacksonFeature;
import com.incomeBank.ws.rest.util.mapper.CustomObjectMapperProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.glassfish.jersey.server.wadl.WadlFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class JaxRsActivator extends ResourceConfig {

    public JaxRsActivator() {
        this.property("jersey.config.disableAutoDiscovery", Boolean.valueOf(true));
        this.packages(new String[]{"com.incomeBank.ws.rest", "com.fasterxml.jackson.jaxrs"});
        this.register(RolesAllowedDynamicFeature.class);
        // this.register(JwtDynamicFeature.class);
        this.register(WadlFeature.class);
        register(CustomObjectMapperProvider.class);
        register(JacksonFeature.class);
        // this.register(WebApplicationExceptionMapper.class);
    }

}
