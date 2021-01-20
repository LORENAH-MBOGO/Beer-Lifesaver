package com.skylar.beer_lifesaver;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeerStyleListActivity extends AppCompatActivity {

    public static final String TAG = BeerStyleListActivity.class.getSimpleName();
    private static final String SANDBOX_KEY = Constants.SANDBOX_KEY;
    @BindView(R.id.errorTextView)
    TextView mErrorTextView;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @BindView(R.id.recyclerView2)
    RecyclerView mRecyclerView;

    private BeerStyleListAdapter mAdapter;
    public ArrayList<BeerStyle> mBeerStyles = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_style_list_item);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String styles = intent.getStringExtra("userInput");
        getBeerStyles(styles);
    }
    private void getBeerStyles(String styles) {
        final BeerStyle beerStyle = new BeerStyle();


        BeerApi client = BeerClient.getClient();

        Call<BeerStyle> call = client.getStyles(SANDBOX_KEY);

        call.enqueue(new Callback<BeerStyle>() {

            @Override
            public void onResponse(Call<BeerStyle> call, Response<BeerStyle> response) {
                hideProgressBar();
                Log.d("error123", String.valueOf(response.body()));

                if (response.isSuccessful()) {
                    List<Datum> styleList = response.body().getData();
                    Toast.makeText(BeerStyleListActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    mAdapter = new BeerStyleListAdapter(getApplicationContext(), mBeerStyles);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BeerStyleListActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
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
