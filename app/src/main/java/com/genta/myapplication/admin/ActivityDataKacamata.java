package com.genta.myapplication.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.genta.myapplication.R;
import com.genta.myapplication.adapter.AdapterKacamata;
import com.genta.myapplication.model.modelKacamata;
import com.genta.myapplication.server.BaseURL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityDataKacamata extends AppCompatActivity {

    ProgressDialog pDialog;

    AdapterKacamata adapter;
    ListView list;

    ArrayList<modelKacamata> newsList = new ArrayList<modelKacamata>();
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kacamata);

        getSupportActionBar().setTitle("Data Kacamata");
        mRequestQueue = Volley.newRequestQueue(this);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        list = (ListView) findViewById(R.id.array_list);
        newsList.clear();
        adapter = new AdapterKacamata(ActivityDataKacamata.this, newsList);
        list.setAdapter(adapter);
        getAllKacamata();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(ActivityDataKacamata.this, homeAdmin.class);
        startActivity(i);
        finish();
    }

    private void getAllKacamata() {
        // Pass second argument as "null" for GET requests
        pDialog.setMessage("Loading");
        showDialog();
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, BaseURL.dataKacamata, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        hideDialog();
                        try {
                            boolean status = response.getBoolean("error");
                            if (status == false) {
                                Log.d("data kacamata = ", response.toString());
                                String data = response.getString("data");
                                JSONArray jsonArray = new JSONArray(data);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    final modelKacamata kacamata = new modelKacamata();
                                    final String _id = jsonObject.getString("_id");
                                    final String kodeKacamata = jsonObject.getString("kodeKacamata");
                                    final String merkKacamata = jsonObject.getString("merkKacamata");
                                    final String typeLensa = jsonObject.getString("typeLensa");
                                    final String jenisFrame = jsonObject.getString("jenisFrame");
                                    final String warnaFrame = jsonObject.getString("warnaFrame");
                                    final String hargaKacamata = jsonObject.getString("hargaKacamata");
                                    final String gambar = jsonObject.getString("gambar");
                                    kacamata.setKodeKacamata(kodeKacamata);
                                    kacamata.setMerkKacamata(merkKacamata);
                                    kacamata.setTypeLensa(typeLensa);
                                    kacamata.setJenisFrame(jenisFrame);
                                    kacamata.setWarnaFrame(warnaFrame);
                                    kacamata.setHargaKacamata(hargaKacamata);
                                    kacamata.setGambar(gambar);
                                    kacamata.set_id(_id);

                                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            // TODO Auto-generated method stub
                                            Intent a = new Intent(ActivityDataKacamata.this, EditKacamataDanHapusActivity.class);
                                            a.putExtra("kodeKacamata", newsList.get(position).getKodeKacamata());
                                            a.putExtra("_id", newsList.get(position).get_id());
                                            a.putExtra("merkKacamata", newsList.get(position).getMerkKacamata());
                                            a.putExtra("typeLensa", newsList.get(position).getTypeLensa());
                                            a.putExtra("jenisFrame", newsList.get(position).getJenisFrame());
                                            a.putExtra("warnaFrame", newsList.get(position).getWarnaFrame());
                                            a.putExtra("hargaKacamata", newsList.get(position).getHargaKacamata());
                                            a.putExtra("gambar", newsList.get(position).getGambar());
                                            startActivity(a);
                                        }
                                    });
                                    newsList.add(kacamata);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
                hideDialog();
            }
        });

        /* Add your Requests to the RequestQueue to execute */
        mRequestQueue.add(req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}