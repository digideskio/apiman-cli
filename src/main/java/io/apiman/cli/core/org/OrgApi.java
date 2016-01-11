package io.apiman.cli.core.org;

import io.apiman.cli.core.org.model.Org;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * @author Pete
 */
public interface OrgApi {
    @POST("/organizations")
    Response create(@Body Org organisation);

    @GET("/organizations/{orgName}")
    Org fetch(@Path("orgName") String orgName);
}
