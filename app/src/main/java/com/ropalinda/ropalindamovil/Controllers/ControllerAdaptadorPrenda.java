package com.ropalinda.ropalindamovil.Controllers;


import android.content.Context;
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
        ImageView image_prenda;
        TextView txt_nomPrenda;
        TextView txt_precioPrenda;
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

            viewHolder.image_prenda = convertView.findViewById(R.id.image_prenda);
            viewHolder.txt_nomPrenda = convertView.findViewById(R.id.txt_nomPrenda);
            viewHolder.txt_precioPrenda = convertView.findViewById(R.id.txt_precioPrenda);

            result = convertView;

            convertView.setTag(viewHolder);

        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;

        new DownLoadImageTask(viewHolder.image_prenda).execute(prenda.getImagenPrenda());
        //viewHolder.image_prenda.setImageURI(prenda.getImagenPrenda());
        viewHolder.txt_nomPrenda.setText(prenda.getNombrePrenda());
        int precio = prenda.getPrecioPrenda();
        viewHolder.txt_precioPrenda.setText(format.format(precio));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
