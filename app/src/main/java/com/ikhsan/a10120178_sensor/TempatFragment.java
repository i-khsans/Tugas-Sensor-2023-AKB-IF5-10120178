package com.ikhsan.a10120178_sensor;

/*
 * NIM  : 10120178
 *Nama  : Muhammad Noer Ikhsan Hidayat
 *Kelas : IF5
 *Email : muhammadnoerikhsanh@gmail.com
 * */

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ikhsan.a10120178_sensor.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class TempatFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng lokasi1 = new LatLng(-6.949449152027012, 107.62233912719675);
            googleMap.addMarker(new MarkerOptions().position(lokasi1).title("Warung Nasi SPG Moh Toha"));

            LatLng lokasi2 = new LatLng(-6.949408942923806, 107.6212049398032);
            googleMap.addMarker(new MarkerOptions().position(lokasi2).title("Sushi Yay"));

            LatLng lokasi3 = new LatLng(-6.948931110073613, 107.62115251933673);
            googleMap.addMarker(new MarkerOptions().position(lokasi3).title("Ayam Geprek Pangeran"));

            LatLng lokasi4 = new LatLng(-6.95223362405694, 107.62194418694364);
            googleMap.addMarker(new MarkerOptions().position(lokasi4).title("Kebab Turki Merhaba"));

            LatLng lokasi5 = new LatLng(-6.949841190603042, 107.62125557316898);
            googleMap.addMarker(new MarkerOptions().position(lokasi5).title("Martabak Legit Group"));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasi3, 17));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tempat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}