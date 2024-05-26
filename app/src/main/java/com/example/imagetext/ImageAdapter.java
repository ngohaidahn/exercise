package com.example.imagetext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Image> mListImage;


    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Image> list) {
        this.mListImage = list;
        notifyDataSetChanged();
    }




    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Image image = mListImage.get(position);
        if (image == null) {
            return;
        }
        Glide.with(mContext).load(mListImage.get(position).getResourceImage())
                .centerCrop()
                .placeholder(R.drawable.loading)
                .error(R.drawable.cross)
                .into(holder.imgResourceImage);
//        holder.imgResourceImage.setImageResource(image.getResourceImage());

        holder.tvNumber.setText(Integer.toString(image.getNumber()));
        holder.imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.tvNumber.setText(Integer.toString(image.getPlus()));
            }
        });
        holder.imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.tvNumber.setText(Integer.toString(image.getMinus()));
            }
        });


    }



    @Override
    public int getItemCount() {
        if (mListImage != null) {
            return mListImage.size();
        }
        return 0;
    }

    void odd(Image image) {
        //so le trong tat ca cap so random
        int currentNumber = image.getNumber();
            if (currentNumber %2 !=0){
                currentNumber =mListImage.size();
            }
    }


    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgResourceImage;
        private TextView tvNumber;

        private ImageView imgPlus;
        private ImageView imgMinus;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imgResourceImage = itemView.findViewById(R.id.img_icon);
            tvNumber = itemView.findViewById(R.id.tv_number);
            imgPlus = itemView.findViewById(R.id.imgPlus);
            imgMinus = itemView.findViewById(R.id.imgMinus);
        }


    }
}
