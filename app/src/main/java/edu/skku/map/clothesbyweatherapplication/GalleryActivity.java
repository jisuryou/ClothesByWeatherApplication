package edu.skku.map.clothesbyweatherapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.w3c.dom.Text;

import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GalleryActivity extends Activity {
    private StorageReference mStorageRef;
    private DatabaseReference mPostReference;

    ImageView instimg;

    private GridView imageGrid;
    private ArrayList<Image> imgs;
    private ImageAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Bundle bundle = getIntent().getExtras();
        final double temp = bundle.getDouble("temp");

        instimg = findViewById(R.id.instimg);

        mStorageRef = FirebaseStorage.getInstance().getReference();
        mPostReference = FirebaseDatabase.getInstance().getReference();

        final long ONE_MEGABYTE = 1024*1024;
        if(temp<5.0){
            StorageReference ref = mStorageRef.child("Instruction Images").child("~4.jpeg");
            ref.getBytes(ONE_MEGABYTE).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            }).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    instimg.setImageBitmap(bitmap);
                }
            });
        } else if(temp>=5.0 && temp<9.0){
            StorageReference ref = mStorageRef.child("Instruction Images").child("5~8.jpeg");
            ref.getBytes(ONE_MEGABYTE).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            }).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    instimg.setImageBitmap(bitmap);
                }
            });
        } else if(temp>=9.0 && temp<12.0){
            StorageReference ref = mStorageRef.child("Instruction Images").child("9~11.jpeg");
            ref.getBytes(ONE_MEGABYTE).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            }).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    instimg.setImageBitmap(bitmap);
                }
            });
        } else if(temp>=12.0 && temp<17.0){
            StorageReference ref = mStorageRef.child("Instruction Images").child("12~16.jpeg");
            ref.getBytes(ONE_MEGABYTE).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            }).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    instimg.setImageBitmap(bitmap);
                }
            });
        } else if(temp>=17.0 && temp<20.0){
            StorageReference ref = mStorageRef.child("Instruction Images").child("17~19.jpeg");
            ref.getBytes(ONE_MEGABYTE).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            }).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    instimg.setImageBitmap(bitmap);
                }
            });
        } else if(temp>=20.0 && temp<23.0){
            StorageReference ref = mStorageRef.child("Instruction Images").child("20~22.jpeg");
            ref.getBytes(ONE_MEGABYTE).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            }).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    instimg.setImageBitmap(bitmap);
                }
            });
        } else{
            StorageReference ref = mStorageRef.child("Instruction Images").child("23~27.jpeg");
            ref.getBytes(ONE_MEGABYTE).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            }).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    instimg.setImageBitmap(bitmap);
                }
            });
        }

        imageGrid = (GridView) findViewById(R.id.gridview);
        imgs = new ArrayList<Image>();

        if(temp<5.0){
            DatabaseReference pr = mPostReference.child("~4");
            pr.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                        Image get = postSnapshot.getValue(Image.class);
                        imgs.add(new Image(get.id, get.imguri, get.memo));
                    }
                    adapter = new ImageAdapter(GalleryActivity.this, imgs);
                    adapter.notifyDataSetChanged();
                    imageGrid.setAdapter(adapter);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } else if(temp>=5.0 && temp< 9.0){
            DatabaseReference pr = mPostReference.child("5~8");
            pr.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                        Image get = postSnapshot.getValue(Image.class);
                        imgs.add(new Image(get.id, get.imguri, get.memo));
                    }
                    adapter = new ImageAdapter(GalleryActivity.this, imgs);
                    adapter.notifyDataSetChanged();
                    imageGrid.setAdapter(adapter);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } else if(temp>=9.0 && temp< 12.0){
            DatabaseReference pr = mPostReference.child("9~11");
            pr.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                        Image get = postSnapshot.getValue(Image.class);
                        imgs.add(new Image(get.id, get.imguri, get.memo));
                    }
                    adapter = new ImageAdapter(GalleryActivity.this, imgs);
                    adapter.notifyDataSetChanged();
                    imageGrid.setAdapter(adapter);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } else if(temp>=12.0 && temp< 17.0){
            DatabaseReference pr = mPostReference.child("12~16");
            pr.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    imgs = new ArrayList<Image>();
                    for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                        Image get = postSnapshot.getValue(Image.class);
                        imgs.add(new Image(get.id, get.imguri, get.memo));
                    }
                    adapter = new ImageAdapter(GalleryActivity.this, imgs);
                    adapter.notifyDataSetChanged();
                    imageGrid.setAdapter(adapter);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } else if(temp>=17.0 && temp< 20.0){
            DatabaseReference pr = mPostReference.child("17~19");
            pr.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    imgs = new ArrayList<Image>();
                    for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                        Image get = postSnapshot.getValue(Image.class);
                        imgs.add(new Image(get.id, get.imguri, get.memo));
                    }
                    adapter = new ImageAdapter(GalleryActivity.this, imgs);
                    adapter.notifyDataSetChanged();
                    imageGrid.setAdapter(adapter);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } else if(temp>=20.0 && temp< 23.0){
            DatabaseReference pr = mPostReference.child("20~22");
            pr.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    imgs = new ArrayList<Image>();
                    for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                        Image get = postSnapshot.getValue(Image.class);
                        imgs.add(new Image(get.id, get.imguri, get.memo));
                    }
                    adapter = new ImageAdapter(GalleryActivity.this, imgs);
                    adapter.notifyDataSetChanged();
                    imageGrid.setAdapter(adapter);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } else{
            DatabaseReference pr = mPostReference.child("23~27");
            pr.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    imgs = new ArrayList<Image>();
                    for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                        Image get = postSnapshot.getValue(Image.class);
                        imgs.add(new Image(get.id, get.imguri, get.memo));
                    }
                    adapter = new ImageAdapter(GalleryActivity.this, imgs);
                    adapter.notifyDataSetChanged();
                    imageGrid.setAdapter(adapter);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        Button upload = (Button)findViewById(R.id.upload);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GalleryActivity.this, AddActivity.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("temp", temp);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}