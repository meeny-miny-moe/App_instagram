package madwhale.g82.instagram.recyclerView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import madwhale.g82.instagram.R;
import madwhale.g82.instagram.model.PostItem;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private Context mContext;
    private ArrayList<PostItem> postItems;

    public PostAdapter(Context context, ArrayList<PostItem> listItem){
        mContext=context;
        postItems=listItem;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View baseView=View.inflate(mContext,R.layout.post_item,null);
        PostViewHolder postViewHolder=new PostViewHolder(baseView,this);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostItem item= postItems.get(position);

        holder.tvUserName.setText(item.getUserName());
        holder.tvPostText.setText(item.getPostText());
        holder.tvLikeCount.setText(String.valueOf(item.getPostLikeCount()));
    }

    @Override
    public int getItemCount() {
        return postItems.size();
    }

    public void onLikeClicked(int position) {
        PostItem item=postItems.get(position);
        Toast.makeText(mContext,position+" : "+item.getPostText(),Toast.LENGTH_SHORT).show();
    }
}
