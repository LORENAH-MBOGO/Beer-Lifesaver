package com.skylar.beer_lifesaver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import retrofit2.Call;

public class BeerStyleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_style_list);

        BeerApi client = BeerApi.getClient();
        Call<BeerStyle> call = (Call<BeerStyle>) client.getStyles("name", "description");
    }
}