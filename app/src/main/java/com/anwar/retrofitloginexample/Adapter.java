package com.anwar.retrofitloginexample;
/**
 * Anwar Chowdhury
 * Date:5/2/2020
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Users> users;
    Context context;

    public Adapter(Context context, List<Users> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(users.get(position).getName());
        holder.email.setText(users.get(position).getEmail());
        holder.request.setText(users.get(position).getRequest ());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name, email,request;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            request = itemView.findViewById(R.id.txv_request);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {


            Intent i = new Intent(context, PasschangeActivity.class);

            i.putExtra("id", users.get(getAdapterPosition()).getId());
            i.putExtra("name", users.get(getAdapterPosition()).getName());
            i.putExtra("email", users.get(getAdapterPosition()).getEmail());
            i.putExtra("mobile", users.get(getAdapterPosition()).getMobile ());
            i.putExtra("address", users.get(getAdapterPosition()).getAddress ());
            i.putExtra("maplink", users.get(getAdapterPosition()).getMaplink ());
            i.putExtra("city", users.get(getAdapterPosition()).getCity ());
            i.putExtra("country", users.get(getAdapterPosition()).getCountry ());
            i.putExtra("zip", users.get(getAdapterPosition()).getZip ());
            i.putExtra("password", users.get(getAdapterPosition()).getPassword ());

            context.startActivity(i);





        }
    }
}
