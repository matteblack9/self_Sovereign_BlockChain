package android.blockchain.hackathon.main;

import android.blockchain.hackathon.R;
import android.blockchain.hackathon.authDetail.AuthDetailActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by rlarh on 2018-08-31.
 */

public class AuthRecyclerViewAdapter extends RecyclerView.Adapter<AuthRecyclerViewHolder> {
    private Context context;
    private ArrayList<AuthRecyclerViewItem> mItems;

    public AuthRecyclerViewAdapter(Context context, ArrayList<AuthRecyclerViewItem> mItems) {
        this.context = context;
        this.mItems = mItems;
    }

    @Override
    public AuthRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_authlist, parent, false);
        return new AuthRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AuthRecyclerViewHolder holder, int position) {
        Glide.with(context).load(mItems.get(position).getImage_path()).into(holder.imageView);
        holder.authName.setText(mItems.get(position).getAuth_name());
        holder.authDetail.setText(mItems.get(position).getAuth_detail());

        final int pos = position;
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AuthDetailActivity.class);
                intent.putExtra("item", mItems.get(pos));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
