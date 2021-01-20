package com.skylar.beer_lifesaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeerStyleListActivity extends AppCompatActivity {

    public static final String TAG = BeerStyleListActivity.class.getSimpleName();
    @BindView(R.id.errorTextView)
    TextView mErrorTextView;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private BeerStyleListAdapter mAdapter;
    public ArrayList<BeerStyle> mBeerStyles = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers);
        ButterKnife.bind(this);

        BeerApi client = BeerClient.getClient();
        Call<BeerStyle> call = (Call<BeerStyle>) client.getStyles(mBeerStyles);

        call.enqueue(new Callback<BeerStyle>() {
            @Override
            public void onResponse(Call<BeerStyle> call, Response<BeerStyle> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    List<Datum> styleList = response.body().getData();
//
                    mAdapter = new BeerStyleListAdapter(getApplicationContext(), mBeerStyles);
                    mRecyclerView.setAdapter(mAdapter);

                    showStyles();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<BeerStyle> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
                hideProgressBar();
                showFailureMessage();
            }
        });
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showStyles() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

}