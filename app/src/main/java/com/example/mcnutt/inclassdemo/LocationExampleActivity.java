package com.example.mcnutt.inclassdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.location.LocationManager;
import android.content.Context;
import androidx.appcompat.app.AlertDialog;
import android.provider.Settings;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.location.LocationListener;
import android.location.Location;
import android.widget.TextView;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;

public class LocationExampleActivity extends AppCompatActivity {

    LocationManager locationManager;
    double longitudeNetwork, latitudeNetwork;
    TextView longitudeValueNetwork, latitudeValueNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_example);

        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        longitudeValueNetwork = findViewById(R.id.longitudeValueNetwork);
        latitudeValueNetwork = findViewById(R.id.latitudeValueNetwork);
    }

    private boolean checkLocation() {
        if(!isLocationEnabled()) {
            showAlert();
        }
        return isLocationEnabled();
    }

    private boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    private void showAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(R.string.enable_location)
            .setMessage(getString(R.string.location_message))
            .setPositiveButton(R.string.location_settings, (paramDialogInterface, paramInt) -> {
                Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(myIntent);
            })
            .setNegativeButton(R.string.location_cancel, (paramDialogInterface, paramInt) -> {});
        dialog.show();
    }

    public void toggleNetworkUpdates(View view) {
        if(!checkLocation()) {
            return;
        }
        Button button = (Button) view;
        if(button.getText().equals(getResources().getString(R.string.pause))) {
            locationManager.removeUpdates(locationListenerNetwork);
            button.setText(R.string.resume);
        }
        else {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 60 * 1000, 10, locationListenerNetwork);
                Toast.makeText(this, R.string.network_provider_started_running, Toast.LENGTH_LONG).show();
                button.setText(R.string.pause);
            }
        }
    }

    private final LocationListener locationListenerNetwork = new LocationListener() {
        public void onLocationChanged(Location location) {
            longitudeNetwork = location.getLongitude();
            latitudeNetwork = location.getLatitude();

            runOnUiThread(()-> {
                longitudeValueNetwork.setText(String.format("%s", longitudeNetwork));
                latitudeValueNetwork.setText(String.format("%s", latitudeNetwork));
                Toast.makeText(LocationExampleActivity.this, R.string.network_provider_update, Toast.LENGTH_SHORT).show();
            });
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {}

        @Override
        public void onProviderEnabled(String s) {}

        @Override
        public void onProviderDisabled(String s) {}
    };
}
