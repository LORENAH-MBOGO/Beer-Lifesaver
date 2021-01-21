package com.skylar.beer_lifesaver;

import models.BeerStyle;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BeerApi {
    @GET("styles/")
    Call<BeerStyle> getStyles(
            @Query("key")String key

    );
}