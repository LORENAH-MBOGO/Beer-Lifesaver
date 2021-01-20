package com.skylar.beer_lifesaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.skylar.beer_lifesaver.BeerService.getStyles;

public class BeerStyleListActivity extends AppCompatActivity {


    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private BeerStyleListAdapter mAdapter;
    public ArrayList<BeerStyle> mBeerStyles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers);
        ButterKnife.bind(this);

        BeerApi client = BeerApi.getClient(BeerApi.class);
        Call<BeerStyle> call = (Call<BeerStyle>) BeerApi.getStyles("name, description", Constants.SANDBOX_KEY);

        call.enqueue(new Callback<BeerStyle>() {
            @Override
            public void onResponse(Call<BeerStyle> call, Response<BeerStyle> response) {
                if (response.isSuccessful()) {
                    mBeerStyles = response.body().getStyles();
                    mAdapter = new BeerStyleListAdapter(BeerStyleListActivity.this, mBeerStyles);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BeerStyleListActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    getStyles();
                }
            }

            @Override
            public void onFailure(Call<BeerStyle> call, Throwable t) {

            }
        });
    }
}