package com.ropalinda.ropalindamovil.Controllers.Prendas;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.ropalinda.ropalindamovil.Entities.CompatibleGarment;
import com.ropalinda.ropalindamovil.R;
import com.ropalinda.ropalindamovil.Utils.DownLoadImageTask;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ControllerCompatibleGarmentAdapter extends RecyclerView.Adapter<ControllerCompatibleGarmentAdapter.ViewHolder>{

    /*Context context;
        int layoutResourceId;
        ArrayList<CompatibleGarment> data;
        private int lastPosition = -1;
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
        boolean selected = true;*/
    private List<CompatibleGarment> listCompatibleGarments;
    private Context context;
    private NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);

    public ControllerCompatibleGarmentAdapter(List<CompatibleGarment> listItems, Context context) {
        this.listCompatibleGarments = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_prenda_compatible,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        CompatibleGarment listCompatibleGarment = listCompatibleGarments.get(i);

        new DownLoadImageTask(viewHolder.previewImage).execute(listCompatibleGarment.getPreviewImage());

        viewHolder.previewImage.setImageURI(Uri.parse(listCompatibleGarment.getPreviewImage()));
        viewHolder.name.setText(listCompatibleGarment.getName());
        int price = listCompatibleGarment.getPrice();
        viewHolder.price.setText(format.format(price));
    }

    @Override
    public int getItemCount() {
        return listCompatibleGarments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView previewImage;
        TextView name;
        TextView price;
        CheckBox checkbox_add;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            previewImage = itemView.findViewById(R.id.image_compatible_garment);
            name = itemView.findViewById(R.id.txt_name_compatible_garment);
            price = itemView.findViewById(R.id.txt_price_compatible_garment);
            checkbox_add = itemView.findViewById(R.id.checkbox_add_compatible_garment);
        }
    }

    /*class ViewHolder{
        ImageView previewImage;
        TextView name;
        TextView price;
        CheckBox checkbox_add;
    }

    public ControllerCompatibleGarmentAdapter(Context context, int layoutResourceId, ArrayList<CompatibleGarment> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final CompatibleGarment compatibleGarment = getItem(position);
        final ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            convertView = inflater.inflate(layoutResourceId, parent, false);

            viewHolder.previewImage = convertView.findViewById(R.id.image_compatible_garment);
            viewHolder.name = convertView.findViewById(R.id.txt_name_compatible_garment);
            viewHolder.price = convertView.findViewById(R.id.txt_price_compatible_garment);
            viewHolder.checkbox_add = convertView.findViewById(R.id.checkbox_add_compatible_garment);

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

        new DownLoadImageTask(viewHolder.previewImage).execute(compatibleGarment.getPreviewImage()/*prenda.data.previewImage);*/
        //viewHolder.image_prenda.setImageURI(prenda.getImagenPrenda());
        //viewHolder.name.setText(compatibleGarment.getName()/*prenda.data.name*/);
        /*int precio = compatibleGarment.getPrice();
        viewHolder.price.setText(format.format(precio));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected)
                    viewHolder.checkbox_add.setActivated(true);
                else
                    viewHolder.checkbox_add.setActivated(false);

                selected= !selected;
            }
        });

        return convertView;
    }*/
}
