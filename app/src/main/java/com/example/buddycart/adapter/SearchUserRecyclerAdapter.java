package com.example.buddycart.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buddycart.R;

public class SearchUserRecyclerAdapter {

    class UserModelViewHolder extends RecyclerView.ViewHolder{
        TextView nameText;
        TextView phoneText;
        ImageView profilePic;

        public UserModelViewHolder(@NonNull View itemView){
            super(itemView);
            nameText = itemView.findViewById(R.id.name_text);
            phoneText = itemView.findViewById(R.id.phone_text);
            profilePic = itemView.findViewById(R.id.profile_pic_image_view);
        }
    }
}
