package madwhale.g82.instagram;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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



        findViewById(R.id.fab_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int permissionCheck= ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);
                if(permissionCheck== PackageManager.PERMISSION_GRANTED){
                    Intent cameraIntent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
                    if(cameraIntent.resolveActivity(MainActivity.this.getPackageManager())!=null){
                        startActivityForResult(cameraIntent,1000);
                    }
                }
                else {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},2000);
                    //Toast.makeText(MainActivity.this,"권한이 없다",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 2000 && grantResults.length > 0) {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (cameraIntent.resolveActivity(MainActivity.this.getPackageManager()) != null) {
                startActivityForResult(cameraIntent, 1000);
            }
        }
    }

    /* Main(TimeLineFrag) -> run Camera -> main -> Post */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1000&& resultCode==RESULT_OK){
            Log.d("onActivityResult","Camera Success");
            Intent startIntent = new Intent(MainActivity.this,PostActivity.class);
            startIntent.setData(data.getData());
            startActivity(startIntent);
        }
    }
}