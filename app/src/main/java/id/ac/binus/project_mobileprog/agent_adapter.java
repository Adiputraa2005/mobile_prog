package id.ac.binus.project_mobileprog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class agent_adapter extends ArrayAdapter<Agent> {
private Context context;
private int resource;

    public agent_adapter(@NonNull Context context, int resource, ArrayList<Agent> items) {
        super(context, resource, items);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int image = getItem(position).getGambar();
        String nama = getItem(position).getNama();
        String office = getItem(position).getOffice();
        String phone = getItem(position).getPhone();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.img_item);
        TextView textView = (TextView) convertView.findViewById(R.id.txt_name);
        TextView textView1 = (TextView) convertView.findViewById(R.id.txt_office);
        TextView textView2 = (TextView) convertView.findViewById(R.id.txt_phone);

        imageView.setImageResource(image);
        textView.setText(nama);
        textView1.setText(office);
        textView2.setText(phone);

        return convertView;
    }
}
