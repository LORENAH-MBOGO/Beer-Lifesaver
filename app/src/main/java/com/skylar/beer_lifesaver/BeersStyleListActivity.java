package com.skylar.beer_lifesaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class BeersStyleListActivity extends AppCompatActivity {
    public static final String TAG = BeersStyleListActivity.class.getSimpleName();
    private BeerStyleListAdapter mAdapter;
    public ArrayList<BeerStyle> mBeerStyles = new ArrayList<>();
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers_style_list);
        ButterKnife.bind(this);
        private void getBeerStyles(String styles) {
            final BeerService beerService = new BeerService();
            beerService.findBeerStyles(styles, new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) {
                    mBeerStyles = beerService.processResults(response);
                    if (mBeerStyles.size() == 0 ) {
                        Intent intent = new Intent(BeersStyleListActivity.this, BadEntryActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                    }
                    Log.v(TAG, Integer.toString(mBeerStyles.size()));

                    BeersStyleListActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new BeerStyleListAdapter(getApplicationContext(), mBeerStyles);

                            mRecyclerView.setAdapter(mAdapter);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BeersStyleListActivity.this);
                            mRecyclerView.setLayoutManager(layoutManager);
                            mRecyclerView.setHasFixedSize(true);
                        }
                    });
    }
}