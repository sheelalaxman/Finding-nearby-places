package com.example.laxman.findnearbyplaces

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.laxman.findnearbyplaces.bean.ResultsItem
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        var from_single = intent.getBooleanExtra(
            "from_single", false
        )
        if (from_single) {
            var lati = intent.getDoubleExtra("lati", 0.0)
            var longi = intent.getDoubleExtra("longi", 0.0)
            var places_list = intent.getSerializableExtra("places_list") as MutableList<ResultsItem>
            val sydney = LatLng(-lati, longi)
            mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        } else {
           /* for (place in places_list!!) {
                var moptions = MarkerOptions()
                moptions.position(
                    LatLng(
                        place.geometry.location.lat,
                        place.geometry.location.lng
                    )
                )
                mMap.addMarker(moptions)
            }*/
            Toast.makeText(this,"need to be done",Toast.LENGTH_LONG).show()

        }
    }
}