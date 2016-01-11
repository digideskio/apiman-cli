/*
 * Copyright 2016 Pete Cornish
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apiman.cli.core.api;

import io.apiman.cli.core.api.model.Api;
import io.apiman.cli.core.api.model.ApiConfig;
import retrofit.client.Response;
import retrofit.http.*;

import java.util.List;

/**
 * Support for apiman 1.2.x.
 * 
 * @author Pete Cornish {@literal <outofcoffee@gmail.com>}
 */
public interface ApiApi {
    @POST("/organizations/{orgName}/apis")
    Response create(@Path("orgName") String orgName, @Body Api api);

    @GET("/organizations/{orgName}/apis")
    List<Api> list(@Path("orgName") String orgName);

    @GET("/organizations/{orgName}/apis/{apiName}/versions/{version}")
    Api fetch(@Path("orgName") String orgName, @Path("apiName") String apiName, @Path("version") String version);

    @PUT("/organizations/{orgName}/apis/{apiName}/versions/{version}")
    Response configure(@Path("orgName") String orgName, @Path("apiName") String apiName, @Path("version") String version, @Body ApiConfig config);
}
