package com.example.thefourthproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersAdapterVh> {

    private List<UserModel> userModelList;
    private Context context;
    private OnItemCustomClickListener clickListener;

    public UsersAdapter(List<UserModel> userModelList, OnItemCustomClickListener clickListener) {
        this.userModelList = userModelList;
        this.clickListener = clickListener;
    }

    public int getItem(int position) {
        if (position >= 0 && position < userModelList.size()) {
            return userModelList.get(position).getUserName();
        } else return 0;
    }

    @NonNull
    @Override
    public UsersAdapter.UsersAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UsersAdapterVh(LayoutInflater.from(context).inflate(R.layout.row_users, null), clickListener);
    }


    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.UsersAdapterVh holder, int position) {

        UserModel userModel = userModelList.get(position);
        int username = userModel.getUserName();
        holder.tvPrefix.setImageResource(username);
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public interface OnItemCustomClickListener {
        void onItemClicked(int adapterPosition, ImageView tvPrefix);
    }

    public class UsersAdapterVh extends RecyclerView.ViewHolder {
        ImageView tvPrefix;

        public UsersAdapterVh(@NonNull View itemViewfinal, OnItemCustomClickListener clickListener) {
            super(itemViewfinal);
            tvPrefix = itemView.findViewById(R.id.imageRecycle);
            itemView.setOnClickListener(v -> {
                if (clickListener != null) {
                    clickListener.onItemClicked(getAdapterPosition(), tvPrefix);
                }
            });
        }
    }
}