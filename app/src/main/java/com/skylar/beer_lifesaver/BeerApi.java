package com.skylar.beer_lifesaver;

import java.util.ArrayList;

import okhttp3.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BeerApi {
    @GET("styles/")
    Call getStyles(
            @Query("styles") ArrayList<BeerStyle> styles

    );
}