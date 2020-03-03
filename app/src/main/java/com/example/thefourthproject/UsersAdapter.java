package com.example.thefourthproject;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersAdapterVh> /*implements Filterable*/ {

    private List<UserModel> userModelList;

    private Context context;
    private SelectedUser selectedUser;

    public UsersAdapter(List<UserModel> userModelList, SelectedUser selectedUser) {
        this.userModelList = userModelList;

        this.selectedUser = selectedUser;
    }

    @NonNull
    @Override
    public UsersAdapter.UsersAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UsersAdapterVh(LayoutInflater.from(context).inflate(R.layout.row_users,null));
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.UsersAdapterVh holder, int position) {

        UserModel userModel = userModelList.get(position);
        int username = userModel.getUserName();
        Log.i("myTag", holder.tvPrefix + "xyi");
        holder.tvPrefix.setImageResource(username);
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public interface SelectedUser{

        void selectedUser(UserModel userModel);
    }

    public class UsersAdapterVh extends RecyclerView.ViewHolder {

        ImageView tvPrefix;

        public UsersAdapterVh(@NonNull View itemView) {
            super(itemView);
            tvPrefix = itemView.findViewById(R.id.imageRecycle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedUser.selectedUser(userModelList.get(getAdapterPosition()));
                }
            });


        }
    }
}