package com.skylar.beer_lifesaver;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.BeerInput)
    EditText mBeerInput;
    @BindView(R.id.bSearch)
    Button mFindBeerStyle;
    @BindView(R.id.tLogo)
    TextView mLogo;
    @BindView(R.id.bSaved)
    Button mSaved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ButterKnife.bind(this);
        mFindBeerStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = mBeerInput.getText().toString();
                Intent intent = new Intent(HomeActivity.this, BeerStyleListActivity.class);
                intent.putExtra("beer", userInput);
                startActivity(intent);

//                Toast.makeText(HomeActivity.this, "We are here",Toast.LENGTH_LONG).show();

            }
        });
        mSaved.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

            if (view == mSaved) {
                Intent intent = new Intent(HomeActivity.this, SavedBeerStyeListActivity.class);
                startActivity(intent);
            }

        }

}