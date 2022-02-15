package sp.com.cleverclean.ui;

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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import sp.com.cleverclean.GPSTracker;
import sp.com.cleverclean.MyDatabaseHelper;
import sp.com.cleverclean.R;



public class AddFragment extends Fragment {
    private EditText BinName;
    private EditText BinAddress;
    private Button BinImage;
    private Button buttonSave;

    private TextView location;
    private double latitude = 0.0d;
    private double longitude = 0.0d;
    private double myLatitude;
    private double myLongitude;
    private Button getLocation;
    private byte[] bArray;
    private Bitmap bitmap = null;
    private Uri imageUri;

    private String name, addr, timeStamp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_addbin, container, false);
        BinName = view.findViewById(R.id.BinNo);
        BinAddress = view.findViewById(R.id.BinLocation);
        BinImage = view.findViewById(R.id.imagebutton);
        buttonSave = view.findViewById(R.id.save);
        location = view.findViewById(R.id.location);
        getLocation = view.findViewById(R.id.getLocation);
        return view;


    }
}