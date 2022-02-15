package sp.com.cleverclean.ui;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.io.IOException;

import sp.com.cleverclean.GPSTracker;
import sp.com.cleverclean.MyDatabaseHelper;
import sp.com.cleverclean.R;



public class AddFragment extends Fragment implements View.OnClickListener{
    private EditText BinName;
    private EditText BinAddress;
    private Button ImageButton;
    private Button buttonSave;
    private ImageView BinImage;
    private TextView location;
    private double latitude = 0.0d;
    private double longitude = 0.0d;
    private double myLatitude;
    private double myLongitude;
    private Button getLocation;
    private byte[] bArray;
    private Bitmap bitmap = null;
    private Uri imageUri;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_addbin, container, false);
        BinName = view.findViewById(R.id.BinNo);
        BinAddress = view.findViewById(R.id.BinLocation);
        BinImage = view.findViewById(R.id.BinImage);
        ImageButton = view.findViewById(R.id.imagebutton);
        ImageButton.setOnClickListener(this);
        buttonSave = view.findViewById(R.id.save);
        buttonSave.setOnClickListener(this);
        location = view.findViewById(R.id.location);
        getLocation = view.findViewById(R.id.getLocation);
        getLocation.setOnClickListener(this);
        return view;


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imagebutton:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
                break;

        }
    }

        public int PICK_IMAGE = 1; //request code:
        @Override
        public void onActivityResult ( int requestCode, int resultCode, Intent data){
            if (resultCode == RESULT_OK) {
                if (requestCode == PICK_IMAGE) {
                    imageUri = data.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (imageUri != null) {
                        BinImage.setImageURI(imageUri);
                    }
                }
            }
        }

    }