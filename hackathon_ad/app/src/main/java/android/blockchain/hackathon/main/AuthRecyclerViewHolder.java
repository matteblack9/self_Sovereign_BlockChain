package android.blockchain.hackathon.main;

import android.blockchain.hackathon.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rlarh on 2018-08-31.
 */

public class AuthRecyclerViewHolder extends RecyclerView.ViewHolder {
    android.support.constraint.ConstraintLayout constraintLayout;
    ImageView imageView;
    TextView authName;
    TextView authDetail;

    public AuthRecyclerViewHolder(View itemView) {
        super(itemView);
        this.constraintLayout = itemView.findViewById(R.id.id_constraintLayout_item_authlist);
        this.imageView = itemView.findViewById(R.id.id_img_auth);
        this.authName = itemView.findViewById(R.id.id_text_authname);
        this.authDetail = itemView.findViewById(R.id.id_text_authdetail);
    }
}
