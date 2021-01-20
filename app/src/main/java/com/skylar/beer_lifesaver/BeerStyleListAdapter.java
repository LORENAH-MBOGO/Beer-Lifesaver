package com.skylar.beer_lifesaver;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeerStyleListAdapter extends RecyclerView.Adapter {
    private ArrayList<BeerStyle> mBeerStyles = new ArrayList<>();
    private Context mContext;

    public BeerStyleListAdapter(Context context, ArrayList<BeerStyle> beerStyles) {
        mContext = context;
        mBeerStyles = beerStyles;
    }

    @Override
    public BeerStyleListAdapter.StyleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_style_list_item, parent, false);

        StyleViewHolder viewHolder = new StyleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(BeerStyleListAdapter.StyleViewHolder holder, int position) {
        holder.bindStyle(mBeerStyles.get(position));
    }

    @Override
    public int getItemCount() {
        return mBeerStyles.size();
    }

    public class StyleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.styleImageView)
        ImageView mStyleImageView;
        @BindView(R.id.styleNameTextView)
        TextView mStyleNameTextView;
        @BindView(R.id.descriptionTextView) TextView mDescriptionNameTextView;

        private Context mContext;

        public StyleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindStyle(BeerStyle beerStyle) {
            mStyleNameTextView.setText(beerStyle.getStyleName());
            mDescriptionNameTextView.setText(beerStyle.getDescription());

            //random image generator
            TypedArray imgs = mContext.getResources().obtainTypedArray(R.array.random_images_array);
            Random random = new Random();
            int rndInt = random.nextInt(imgs.length());
            int resID = imgs.getResourceId(rndInt, 0);
            mStyleImageView.setImageResource(resID);

        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, BeerStyleDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("beerStyles", Parcels.wrap(mBeerStyles));
            mContext.startActivity(intent);
        }
    }
}
}
