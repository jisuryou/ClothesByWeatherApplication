package edu.skku.map.clothesbyweatherapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
    private DatabaseReference mPostReference;
    private StorageReference mStorageRef;
    private static final int PICK_IMAGE = 777;
    Uri postImageUri;
    ImageButton postImageBtn;
    EditText memoET;
    String memo = "";
    Button button_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Bundle bundle = getIntent().getExtras();
        final double temp = bundle.getDouble("temp");

        mPostReference = FirebaseDatabase.getInstance().getReference();
        mStorageRef = FirebaseStorage.getInstance().getReference();

        memoET = (EditText) findViewById(R.id.editText_memo);
        postImageBtn = (ImageButton) findViewById(R.id.postimg);
        postImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
            }
        });

        button_add = findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                memo = memoET.getText().toString();

                if(temp<5.0){
                    DatabaseReference pr = mPostReference;
                    String key = pr.child("~4").push().getKey();
                    Image image = new Image(key, postImageUri.getLastPathSegment(), memo);
                    Map<String, Object> imgValues = image.toMap();
                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put("/~4/"+key, imgValues);
                    mPostReference.updateChildren(childUpdates);
                    StorageReference ref = mStorageRef.child("Example Images").child(postImageUri.getLastPathSegment());
                    UploadTask uploadTask = ref.putFile(postImageUri);
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            e.printStackTrace();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(AddActivity.this, "Upload success!", Toast.LENGTH_LONG);
                        }
                    });
                } else if(temp>=5.0 && temp< 9.0){
                    DatabaseReference pr = mPostReference;
                    String key = pr.child("5~8").push().getKey();
                    Image image = new Image(key, postImageUri.getLastPathSegment(), memo);
                    Map<String, Object> imgValues = image.toMap();
                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put("/5~8/"+key, imgValues);
                    mPostReference.updateChildren(childUpdates);
                    StorageReference ref = mStorageRef.child("Example Images").child(postImageUri.getLastPathSegment());
                    UploadTask uploadTask = ref.putFile(postImageUri);
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            e.printStackTrace();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(AddActivity.this, "Upload success!", Toast.LENGTH_LONG);
                        }
                    });
                } else if(temp>=9.0 && temp< 12.0){
                    DatabaseReference pr = mPostReference;
                    String key = pr.child("9~11").push().getKey();
                    Image image = new Image(key, postImageUri.getLastPathSegment(), memo);
                    Map<String, Object> imgValues = image.toMap();
                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put("/9~11/"+key, imgValues);
                    mPostReference.updateChildren(childUpdates);
                    StorageReference ref = mStorageRef.child("Example Images").child(postImageUri.getLastPathSegment());
                    UploadTask uploadTask = ref.putFile(postImageUri);
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            e.printStackTrace();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(AddActivity.this, "Upload success!", Toast.LENGTH_LONG);
                        }
                    });
                } else if(temp>=12.0 && temp< 17.0){
                    DatabaseReference pr = mPostReference;
                    String key = pr.child("12~16").push().getKey();
                    Image image = new Image(key, postImageUri.getLastPathSegment(), memo);
                    Map<String, Object> imgValues = image.toMap();
                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put("/12~16/"+key, imgValues);
                    mPostReference.updateChildren(childUpdates);
                    StorageReference ref = mStorageRef.child("Example Images").child(postImageUri.getLastPathSegment());
                    UploadTask uploadTask = ref.putFile(postImageUri);
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            e.printStackTrace();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(AddActivity.this, "Upload success!", Toast.LENGTH_LONG);
                        }
                    });
                } else if(temp>=17.0 && temp< 20.0){
                    DatabaseReference pr = mPostReference;
                    String key = pr.child("17~19").push().getKey();
                    Image image = new Image(key, postImageUri.getLastPathSegment(), memo);
                    Map<String, Object> imgValues = image.toMap();
                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put("/17~19/"+key, imgValues);
                    mPostReference.updateChildren(childUpdates);
                    StorageReference ref = mStorageRef.child("Example Images").child(postImageUri.getLastPathSegment());
                    UploadTask uploadTask = ref.putFile(postImageUri);
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            e.printStackTrace();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(AddActivity.this, "Upload success!", Toast.LENGTH_LONG);
                        }
                    });
                } else if(temp>=20.0 && temp< 23.0){
                    DatabaseReference pr = mPostReference;
                    String key = pr.child("20~22").push().getKey();
                    Image image = new Image(key, postImageUri.getLastPathSegment(), memo);
                    Map<String, Object> imgValues = image.toMap();
                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put("/20~22/"+key, imgValues);
                    mPostReference.updateChildren(childUpdates);
                    StorageReference ref = mStorageRef.child("Example Images").child(postImageUri.getLastPathSegment());
                    UploadTask uploadTask = ref.putFile(postImageUri);
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            e.printStackTrace();
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(AddActivity.this, "Upload success!", Toast.LENGTH_LONG);
                        }
                    });
                } else{
                    DatabaseReference pr = mPostReference;
                    mStorageRef = FirebaseStorage.getInstance().getReference();
                    String key = pr.child("23~27").push().getKey();
                    StorageReference ref = mStorageRef.child("Example Images").child(postImageUri.getLastPathSegment());
                    UploadTask uploadTask = ref.putFile(postImageUri);
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(AddActivity.this, "Upload success!", Toast.LENGTH_LONG);
                        }
                    });
                    Image image = new Image(key, postImageUri.getLastPathSegment(), memo);
                    Map<String, Object> imgValues = image.toMap();
                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put("/23~27/"+key, imgValues);
                    mPostReference.updateChildren(childUpdates);
                }
                Intent intent = new Intent(AddActivity.this, GalleryActivity.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("temp", temp);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE){
            postImageBtn = (ImageButton) findViewById(R.id.postimg);
            postImageUri = data.getData();
            postImageBtn.setImageURI(data.getData());
            postImageBtn.setScaleType(ImageButton.ScaleType.FIT_XY);
        }
    }
}
