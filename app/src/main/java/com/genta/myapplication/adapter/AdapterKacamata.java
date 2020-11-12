package com.genta.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.genta.myapplication.R;
import com.genta.myapplication.server.BaseURL;
import com.genta.myapplication.model.modelKacamata;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterKacamata extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<modelKacamata> item;

    public AdapterKacamata(Activity activity, List<modelKacamata> item) {
        this.activity = activity;
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.content_kacamata, null);


        TextView kodeKacamata = (TextView) convertView.findViewById(R.id.txtkodeKacamata);
        TextView merkKacamata     = (TextView) convertView.findViewById(R.id.txtMerkKacamata);
        TextView hargaKacamata         = (TextView) convertView.findViewById(R.id.txthargaKacamata);
        ImageView gambarBarang         = (ImageView) convertView.findViewById(R.id.gambarBarang);



        kodeKacamata.setText(item.get(position).getKodeKacamata());
        merkKacamata.setText(item.get(position).getMerkKacamata());
        hargaKacamata.setText("Rp." + item.get(position).getHargaKacamata());
        Picasso.get().load(BaseURL.baseUrl + "gambar/" + item.get(position).getGambar())
                .resize(40, 40)
                .centerCrop()
                .into(gambarBarang);
        return convertView;
    }

}
