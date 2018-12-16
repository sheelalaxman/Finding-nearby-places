package com.example.laxman.findnearbyplaces

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.google.android.gms.location.places.ui.PlacePicker
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loc_pin.setOnClickListener {

            var placepicker = PlacePicker.IntentBuilder()
            startActivityForResult(placepicker.build(this@MainActivity),123)
        }

        sBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tview.text =  progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        } )

        getPlaces.setOnClickListener {


           /* var r = Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create()).
                baseUrl("https://maps.googleapis.com/").
                build()
            var api =   r.create(PlacesAPI::class.java)
            var call = api.getPlaces(
                "${lati.text.toString()},${longi.text.toString()}",
                tview.text.toString(),
                sp1.selectedItem.toString())
            call.enqueue(object: Callback<PlacesBean> {
                override fun onFailure(call: Call<PlacesBean>, t: Throwable) {

                }

                override fun onResponse(call: Call<PlacesBean>, response: Response<PlacesBean>) {
                    var pbean =   response.body()
                   var places_list = pbean!!.results
                    var myAdapter = object : BaseAdapter() {
                        override fun getView(pos: Int, p1: View?, p2: ViewGroup?): View {
                            var inflater = LayoutInflater.from(this@MainActivity)
                            var v = inflater.inflate(R.layout.indiview,null)
                            v.name.text = places_list!!.get(pos).name
                            v.vicinity.text = places_list!!.get(pos).vicinity
                            v.rating.text = places_list!!.get(pos).rating.toString()
                            v.loc.setOnClickListener {
                                var i = Intent(this@MainActivity,
                                    MapsActivity::class.java)
                                i.putExtra("lati",places_list!!.get(pos).
                                    geometry.location.lat)
                                i.putExtra("longi",places_list!!.get(pos).
                                    geometry.location.lng)
                                i.putExtra("our_lati",
                                    lati.text.toString().toDouble())
                                i.putExtra("our_longi",
                                    longi.text.toString().toDouble())
                                i.putExtra("from_single",true)
                                startActivity(i)
                            }
                            return v
                        }
                        override fun getItem(p0: Int): Any = 0
                        override fun getItemId(p0: Int): Long =0
                        override fun getCount(): Int = places_list!!.size
                    }    // BaseAdapter
                    lview.adapter = myAdapter
                }

            })

        }*/

        }
        getLocation()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 123 && resultCode == Activity.RESULT_OK)
        {
            var place = PlacePicker.getPlace(
                this@MainActivity,data)
            lati.text = place.latLng.latitude.toString()
            longi.text = place.latLng.longitude.toString()
        }
    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        var lmanager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        lmanager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
        lmanager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000,1.toFloat(),object :LocationListener{
            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

            }

            override fun onProviderEnabled(provider: String?) {

            }

            override fun onProviderDisabled(provider: String?) {

            }

            override fun onLocationChanged(location: Location?) {
                try {
                    lati.text = location!!.latitude.toString()
                    longi.text= location!!.longitude.toString()
                }
                catch (e : Exception)
                {

                }
            }

        })
    }
}
