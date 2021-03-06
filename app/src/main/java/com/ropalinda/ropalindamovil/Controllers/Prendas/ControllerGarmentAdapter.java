package com.ropalinda.ropalindamovil.Controllers.Prendas;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ropalinda.ropalindamovil.Entities.Garment;
import com.ropalinda.ropalindamovil.R;
import com.ropalinda.ropalindamovil.Utils.DownLoadImageTask;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ControllerGarmentAdapter extends ArrayAdapter<Garment> {

    Context context;
    int layoutResourceId;
    ArrayList<Garment> data;
    private int lastPosition = -1;
    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);

    class ViewHolder{
        ImageView previewImage;
        TextView name;
        TextView price;
    }

    public ControllerGarmentAdapter(Context context, int layoutResourceId, ArrayList<Garment> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Garment prenda = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            convertView = inflater.inflate(layoutResourceId, parent, false);

            viewHolder.previewImage = convertView.findViewById(R.id.image_garment);
            viewHolder.name = convertView.findViewById(R.id.txt_name_garment);
            viewHolder.price = convertView.findViewById(R.id.txt_price_garment);

            result = convertView;

            convertView.setTag(viewHolder);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;

        new DownLoadImageTask(viewHolder.previewImage).execute(prenda.getPreviewImage()/*prenda.data.previewImage*/);
        //viewHolder.image_prenda.setImageURI(prenda.getImagenPrenda());
        viewHolder.name.setText(prenda.getName()/*prenda.data.name*/);
        int precio = prenda.getPrice();
        viewHolder.price.setText(format.format(precio));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ControllerGarmentDetail.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        return convertView;

    }

}
