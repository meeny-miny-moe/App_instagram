package madwhale.g82.instagram.recyclerView;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import madwhale.g82.instagram.R;

public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public CheckBox chLike;
    public ImageView ivImg, ivLike, ivShare;
    public TextView tvLikeCount, tvUserName, tvPostText;
    private PostAdapter mAdapter;

    public PostViewHolder(@NonNull View itemView, PostAdapter postAdapter) {
        super(itemView);
        mAdapter=postAdapter;

        ivImg=(ImageView) itemView.findViewById(R.id.iv_img);
        chLike=(CheckBox) itemView.findViewById(R.id.cb_like);
        ivShare=(ImageView) itemView.findViewById(R.id.iv_share);
        tvLikeCount=(TextView) itemView.findViewById(R.id.tv_likecount);
        tvUserName=(TextView) itemView.findViewById(R.id.tv_username);
        tvPostText=(TextView) itemView.findViewById(R.id.tv_posttext);

        chLike.setOnClickListener(this);
        ivShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int position= getBindingAdapterPosition();

        switch (view.getId()){
            case R.id.cb_like:
                mAdapter.onLikeClicked(position);
                break;
            case R.id.iv_share:
                break;
        }
    }
}
