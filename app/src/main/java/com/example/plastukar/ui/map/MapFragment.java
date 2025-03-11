package com.example.plastukar.ui.map;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.plastukar.data.local.entity.DropOffPoint;
import com.example.plastukar.databinding.FragmentMapBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    private FragmentMapBinding binding;
    private GoogleMap googleMap;
    private final ActivityResultLauncher<String> requestPermissionLauncher =
        registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
            if (isGranted) {
                enableMyLocation();
            }
        });

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMapBinding.inflate(inflater, container, false);
        binding.mapView.onCreate(savedInstanceState);
        binding.mapView.getMapAsync(this);
        return binding.getRoot();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
        checkLocationPermission();
        addDropOffPoints();
    }

    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED) {
            enableMyLocation();
        } else {
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
        }
    }

    private void enableMyLocation() {
        if (googleMap != null) {
            try {
                googleMap.setMyLocationEnabled(true);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
    }

    private void addDropOffPoints() {
        // TODO: Load from database/API
        List<DropOffPoint> points = getDummyDropOffPoints();
        
        for (DropOffPoint point : points) {
            googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(point.getLatitude(), point.getLongitude()))
                .title(point.getName())
                .snippet(point.getAddress()));
        }

        // Center map on first point
        if (!points.isEmpty()) {
            DropOffPoint first = points.get(0);
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(first.getLatitude(), first.getLongitude()), 12f));
        }
    }

    private List<DropOffPoint> getDummyDropOffPoints() {
        List<DropOffPoint> points = new ArrayList<>();
        // Add some dummy points (replace with real data)
        points.add(new DropOffPoint("1", "EcoDrop Center", "123 Green St", -6.2088, 106.8456));
        points.add(new DropOffPoint("2", "Recycling Hub", "456 Earth Ave", -6.2154, 106.8451));
        points.add(new DropOffPoint("3", "Green Point", "789 Nature Rd", -6.2201, 106.8463));
        return points;
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        binding.mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding.mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        binding.mapView.onLowMemory();
    }
}