package madwhale.g82.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.InterruptedByTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class PostActivity extends AppCompatActivity {

    EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Intent intent = getIntent();
        final Uri photoUri = intent.getData();

        ImageView ivPost = (ImageView) findViewById(R.id.iv_post);
        etText = (EditText) findViewById(R.id.et_text);
        findViewById(R.id.btn_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   post(photoUri.toString(),etText.getText().toString());
            }
        });


        Glide.with(this)
                .load(photoUri)
                .centerCrop()
                .transition(withCrossFade())
                .into(ivPost);
    }

    private void post(String uriString, String textString) {
        PostTask postTask = new PostTask();
        PostTask.execute(uriString, textString);
    }

    class PostTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {

            /*Ready for post*/
            Uri imageUri = Uri.parse(strings[0]);
            String text = strings[1];

            //  Bitmap bitmap= getBitmapFromUri(imageUri);
            //  File imageFile=createFileFromBitmap(bitmap);


            /* HTTP POST*/


            return null;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }

}

    private Bitmap getBitmapFromUri(Uri uri) throws IOException {

        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }

    private String makeImageFilePath(){

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd__hhmmss");
        Date date= new Date();
        String strDate=simpleDateFormat.format(date);
        return strDate+".png";
    }
    private File createFileFromBitmap(Bitmap bitmap) throws IOException {

        File newFile= new File(getFilesDir(),makeImageFilePath());
        FileOutputStream fileOutputStream=new FileOutputStream(newFile);
        bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream );
        fileOutputStream.close();

        return newFile;
    }
}