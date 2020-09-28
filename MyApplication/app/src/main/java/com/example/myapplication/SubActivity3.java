package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class SubActivity3 extends AppCompatActivity {
    private ImageButton toggleButton;

    boolean hasCameraFlash = false;
    boolean flashOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3);

        toggleButton=findViewById(R.id.toggleButton);
        hasCameraFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        toggleButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(hasCameraFlash){
                    if(flashOn){
                        flashOn = false ;
                        toggleButton.setImageResource(R.drawable.ic_launcher);
                        flashLightOff();
                    }
                    else{
                        flashOn = true;
                        toggleButton.setImageResource(R.drawable.ic_launcher_round);
                        flashLightOn();

                    }
                }
                else {
                    Toast.makeText(SubActivity3.this, "No flash available",Toast.LENGTH_LONG).show();
                }
            }


        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void flashLightOn (){
        CameraManager cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
        assert cameraManager != null;
        String cameraID = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(cameraID, true);
        Toast.makeText(SubActivity3.this, "FlashLight is ON", Toast.LENGTH_SHORT).show();
    }

    private void flashLightOff (){
        CameraManager cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
        assert cameraManager != null;
        String cameraID = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(cameraID, false);
        Toast.makeText(SubActivity3.this, "FlashLight is Off", Toast.LENGTH_SHORT).show();
    }

}
}