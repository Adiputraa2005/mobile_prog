package id.ac.binus.project_mobileprog;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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
        Rumah rumah = getItem(position);
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
        ImageButton btnFavorite = convertView.findViewById(R.id.favourite_button);
        ImageButton btnDelete = convertView.findViewById(R.id.favouriteDEL_button);

        imageView.setImageResource(rumah.getGambar());
        textView.setText(rumah.getTipe_rumah());
        textView1.setText(rumah.getNama_rumah());
        textView2.setText(rumah.getHarga_rumah());
        textView3.setText(rumah.getUkuran_rumah());
        textView4.setText(rumah.getLokasi_rumah());

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

        btnFavorite.setOnClickListener(v -> {
            List<Rumah> favorites = favourite_helper.getFavorites(context);
            for (Rumah r : favorites) {
                if (r.getId() == rumah.getId()) {
                    Toast.makeText(context, "Sudah di favorit", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            favorites.add(rumah);
            favourite_helper.saveFavorites(context, favorites);
            Toast.makeText(context, "Ditambahkan ke Favorit", Toast.LENGTH_SHORT).show();
        });
        btnDelete.setOnClickListener(v -> {
            favourite_helper.removeFavourite(context, rumah.getId());
            remove(rumah);
            notifyDataSetChanged();
            Toast.makeText(context, "Dihapus dari favorit", Toast.LENGTH_SHORT).show();
        });

        return convertView;
    }
}
