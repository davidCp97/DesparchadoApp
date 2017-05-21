package crimondi.desparchados;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaActivity extends AppCompatActivity implements OnMapReadyCallback {


    GoogleMap map;
    mapa mFirstMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        mFirstMapFragment = mapa.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.mapa_contenedor, mFirstMapFragment).commit();
        //SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);
        mFirstMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
    //    map = googleMap;

     //   LatLng bogota = new LatLng(4.6485233, -74.0637629);
      //  map.getUiSettings().setZoomControlsEnabled(true);
      //  map.moveCamera(CameraUpdateFactory.newLatLngZoom(bogota, 18));
      //  map.setMapType(googleMap.MAP_TYPE_NORMAL);

        LatLng cali = new LatLng(3.4383, -76.5161);
        googleMap.addMarker(new MarkerOptions().position(cali).title("Cali la Sucursal del cielo"));

        CameraPosition cameraPosition = CameraPosition.builder()
                .target(cali)
                .zoom(10)
                .build();
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

       // MarkerOptions ej = new MarkerOptions().title("LOKO").position(bogota).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marcador1));
        //map.addMarker(ej);
        // map.addMarker(new MarkerOptions().position(bogota).title("Marker in Sydney"));
        //map.moveCamera(CameraUpdateFactory.newLatLng(bogota));

        //añadido vision
    }
}