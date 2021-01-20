package com.skylar.beer_lifesaver;

import okhttp3.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BeerApi {
    @GET("styles/")
    Call<BeerStyle> getStyles(
            @Query ("name") String name,
            @Query("description") String description
);
}