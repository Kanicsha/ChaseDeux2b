package com.example.cheese_chase;
import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import okhttp3.ResponseBody;

public interface ApiService {

   @GET("/obstacleLimit")
    Call<ObstacleLimitResp> getObstacleLimit();

   @GET("/image")
    Call<ResponseBody> getImage(@Query("character") String character);

   @GET("/hitHindrance")
    Call<hitHindranceResponse> getHitHindrance();


}
