package com.example.roshani.youtubeparsing;

import com.example.roshani.youtubeparsing.entities.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestInterface {
    @GET("youtube/v3/playlistItems")
    Call<Example> getData(@Query("part") String part,@Query("fields") String fields,@Query("maxResults") String maxResults
            ,@Query("playlistId") String id,@Query("key") String key);

}
