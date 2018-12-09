package com.ropalinda.ropalindamovil.Controllers;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ropalinda.ropalindamovil.Entities.Prenda;
import com.ropalinda.ropalindamovil.R;

import java.io.InputStream;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ControllerAdaptadorPrenda extends ArrayAdapter<Prenda> {

    Context context;
    int layoutResourceId;
    ArrayList<Prenda> data;
    private int lastPosition = -1;
    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);

    class ViewHolder{
        ImageView previewImage;
        TextView name;
        TextView price;
    }

    public ControllerAdaptadorPrenda(Context context, int layoutResourceId, ArrayList<Prenda> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Prenda prenda = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            convertView = inflater.inflate(layoutResourceId, parent, false);

            viewHolder.previewImage = convertView.findViewById(R.id.image_prenda);
            viewHolder.name = convertView.findViewById(R.id.txt_nomPrenda);
            viewHolder.price = convertView.findViewById(R.id.txt_precioPrenda);

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
                context.startActivity(new Intent(context, ControllerDetallePrenda.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        return convertView;

    }

    private class DownLoadImageTask extends AsyncTask<String,Void,Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                logo = BitmapFactory.decodeStream(is);
            }catch(Exception e){ // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        /*
            onPostExecute(Result result)
                Runs on the UI thread after doInBackground(Params...).
         */
        protected void onPostExecute(Bitmap result){
            imageView.setImageBitmap(result);
        }
    }

}
