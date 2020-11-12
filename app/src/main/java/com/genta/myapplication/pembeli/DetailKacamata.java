package com.genta.myapplication.pembeli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.genta.myapplication.R;
import com.genta.myapplication.server.BaseURL;
import com.squareup.picasso.Picasso;

public class DetailKacamata extends AppCompatActivity {

    EditText edtKodeKacamata, edtMerkKacamata, edtTypeLensa, edtJenisFrame, edtWarnaFrame, edtHargaKacamata;
    ImageView imgGambarKacamata;

    String strKodeKacamata, strMerkKacamata, strTypeLensa, strJenisFrame, strWarnaFrame, strHargaKacamata, strGambar, _id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kacamata);

        edtKodeKacamata = (EditText) findViewById(R.id.edtKodeKacamata);
        edtMerkKacamata = (EditText) findViewById(R.id.edtmerkKacamata);
        edtTypeLensa = (EditText) findViewById(R.id.edttypeLensa);
        edtJenisFrame = (EditText) findViewById(R.id.edtjenisFrame);
        edtWarnaFrame = (EditText) findViewById(R.id.edtwarnaFrame);
        edtHargaKacamata = (EditText) findViewById(R.id.edthargaKacamata);

        imgGambarKacamata = (ImageView) findViewById(R.id.gambar);

        Intent i = getIntent();
        strKodeKacamata = i.getStringExtra("kodeKacamata");
        strMerkKacamata = i.getStringExtra("merkKacamata");
        strTypeLensa = i.getStringExtra("typeLensa");
        strJenisFrame = i.getStringExtra("jenisFrame");
        strWarnaFrame = i.getStringExtra("warnaFrame");
        strHargaKacamata = i.getStringExtra("hargaKacamata");
        strGambar = i.getStringExtra("gambar");
        _id = i.getStringExtra("_id");

        edtKodeKacamata.setText(strKodeKacamata);
        edtMerkKacamata.setText(strMerkKacamata);
        edtTypeLensa.setText(strTypeLensa);
        edtJenisFrame.setText(strJenisFrame);
        edtWarnaFrame.setText(strWarnaFrame);
        edtHargaKacamata.setText(strHargaKacamata);
        Picasso.get().load(BaseURL.baseUrl + "gambar/" + strGambar)
                .into(imgGambarKacamata);

    }
}