package de.sample.gitrepos.client.service;

import java.util.List;
import java.util.Map;

import de.sample.gitrepos.domain.model.Repo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import rx.Single;

public interface RepoApi {

    @GET("users/{user}/repos")
    Single<List<Repo>> requestRepo(@Path("user") String user, @QueryMap Map<String, String> params);
}
