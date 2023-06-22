package com.ikhsan.a10120178_sensor;

/*
 * NIM  : 10120178
 *Nama  : Muhammad Noer Ikhsan Hidayat
 *Kelas : IF5
 *Email : muhammadnoerikhsanh@gmail.com
 * */

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.ikhsan.a10120178_sensor.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class LokasiFragment extends Fragment {

   FusedLocationProviderClient client;

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_lokasi, container, false);

      client = LocationServices.getFusedLocationProviderClient(getActivity());
      if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getActivity(),
              Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

         getCurrentLocation();
      }
      else {
         ActivityCompat.requestPermissions(getActivity(),new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION }, 44);
      }

      return view;
   }


   @SuppressLint("MissingPermission")
   private void getCurrentLocation()
   {

      SupportMapFragment mFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.current_map);

      LocationManager locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);

      if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
         client.getLastLocation().addOnCompleteListener(
                 task -> {
                    Location location = task.getResult();
                    if (location != null) {
                       mFragment.getMapAsync(googleMap -> {
                          LatLng lok = new LatLng(location.getLatitude(),location.getLongitude());
                          MarkerOptions loc = new MarkerOptions().position(lok).title("Lokasi anda saat ini");
                          googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                          googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lok,17));
                          googleMap.addMarker(loc);
                       });
                    }
                    else {
                       LocationRequest locationRequest = new LocationRequest().setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY).setInterval(10000).setFastestInterval(1000).setNumUpdates(1);

                       LocationCallback locationCallback = new LocationCallback() {
                          @Override
                          public void
                          onLocationResult(@NonNull LocationResult locationResult)
                          {
                             mFragment.getMapAsync(googleMap -> {
                                LatLng lok = new LatLng(location.getLatitude(),location.getLongitude());
                                MarkerOptions loc = new MarkerOptions().position(lok).title("Lokasi");
                                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lok,17));
                                googleMap.addMarker(loc);
                             });
                          }
                       };

                       client.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());
                    }
                 });
      }
      else {
         startActivity(
                 new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
      }
   }

}