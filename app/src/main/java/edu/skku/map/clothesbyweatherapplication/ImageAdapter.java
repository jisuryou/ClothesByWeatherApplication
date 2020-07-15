package edu.skku.map.clothesbyweatherapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private StorageReference mStorageRef;
    private ArrayList<Image> imgs;
    private Context context;

    public ImageAdapter(Context context, ArrayList<Image> imgs) {
        this.context = context;
        this.imgs = imgs;
    }

    public int getCount() {
        return imgs.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        mStorageRef = FirebaseStorage.getInstance().getReference();
        final ImageView imageView;
        final Image img = imgs.get(position);
        final long ONE_MEGABYTE = 1024*1024;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView = (ImageView) convertView;
        }

        StorageReference ref = mStorageRef.child("Example Images").child(img.imguri);
        ref.getBytes(ONE_MEGABYTE).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        }).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                imageView.setImageBitmap(bitmap);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(imageView.getContext(), img.memo, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return imageView;
    }

}
