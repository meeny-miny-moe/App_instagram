package madwhale.g82.instagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import madwhale.g82.instagram.model.PostItem;
import madwhale.g82.instagram.recyclerView.PostAdapter;

public class MainActivity extends AppCompatActivity {
    //ArrayList<PostItem>arrayList;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<PostItem> listItem = new ArrayList<>();
        RecyclerView rvList = (RecyclerView) findViewById(R.id.rv_list);

            PostItem item= new PostItem(true, 125, "meeny_miny_moe__","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTxafsNIHXaW_crWgnmAYL2fARoPffUcMWTtQ&usqp=CAU","빙글빙글 돌아가는 맷돌");
            listItem.add(item);

            item = new PostItem(true, 300, "undong_hagisilta", "https://www.wetrend.co.kr/data/file2/daily_board/2103/08/1615200571_fa6449540d59f558366558eab90e1e21.jpeg","쏘 핸섬가이~");
            listItem.add(item);

            item=new PostItem(true, 98,"ansta_","https://w.namu.la/s/7f4e13522d99ee82bf7d39b6c8a0f7d378e59f97b9b5973003ded952e7de3de3e9f77da1762cc21f70adf268ad35bece343819f2dfa42f6914a7be02957625a75307d35faacc80a5e3f6a26e0260b49a8f030a7ccae83c1c7215a4a5f6efc20f","리바이 !");
            listItem.add(item);

        PostAdapter adpater = new PostAdapter(this, listItem);
        rvList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvList.setAdapter(adpater);
    }
}