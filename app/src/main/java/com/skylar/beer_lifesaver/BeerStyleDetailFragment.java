package com.skylar.beer_lifesaver;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BeerStyleDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeerStyleDetailFragment extends Fragment {
    @BindView(R.id.styleNameTextView)
    TextView mStyleName;
    @BindView(R.id.saveButton)
    TextView mSaveButton;
    @BindView(R.id.descriptionTextView)
    TextView mDescription;
    @BindView(R.id.abvTextView)
    TextView mABV;
    @BindView(R.id.srmTextView)
    TextView mSRM;
    @BindView(R.id.ibuTextView)
    TextView mIBU;
    @BindView(R.id.infoTextView)
    TextView mInfoIcon;

    private BeerStyle mBeerStyle;

    public BeerStyleDetailFragment() {
    }

    public static BeerStyleDetailFragment newInstance(BeerStyle beerStyle) {
        BeerStyleDetailFragment styleFragment = new BeerStyleDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("beerStyle", Parcels.wrap(beerStyle));
        styleFragment.setArguments(args);
        return styleFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeerStyle = Parcels.unwrap(getArguments().getParcelable("beerStyle"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beer_style_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
