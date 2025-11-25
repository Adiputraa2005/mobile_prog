package id.ac.binus.project_mobileprog;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class listrumah_adapter extends ArrayAdapter<Rumah> {
    private Context context;
    private int resource;

    public listrumah_adapter(@NonNull Context context, int resource, ArrayList<Rumah> list_item_rumah) {
        super(context, resource, list_item_rumah);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int image = getItem(position).getGambar();
        String namaRumah = getItem(position).getNama_rumah();
        String hargaRumah = getItem(position).getHarga_rumah();
        String lokasiRumah = getItem(position).getLokasi_rumah();
        String tipeRumah = getItem(position).getTipe_rumah();
        String ukuranRumah = getItem(position).getUkuran_rumah();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.gambar_rumah);
        TextView textView = (TextView) convertView.findViewById(R.id.txttipe_rumah);
        TextView textView1 = (TextView) convertView.findViewById(R.id.txtNama_rumah);
        TextView textView2 = (TextView) convertView.findViewById(R.id.txtHarga_rumah);
        TextView textView3 = (TextView) convertView.findViewById(R.id.txtUkuran_rumah);
        TextView textView4 = (TextView) convertView.findViewById(R.id.txtlokasi_rumah);
        Button btnAgent = convertView.findViewById(R.id.btn_Agent1);
        Button btnBrosur = convertView.findViewById(R.id.btn_Brosur1);

        imageView.setImageResource(image);
        textView.setText(tipeRumah);
        textView1.setText(namaRumah);
        textView2.setText(hargaRumah);
        textView3.setText(ukuranRumah);
        textView4.setText(lokasiRumah);

        btnBrosur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Brosur_activity.class);
                context.startActivity(intent);
            }
        });
        btnAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Agent_activity.class);
                context.startActivity(intent);
            }
        });


        return convertView;
    }
}
