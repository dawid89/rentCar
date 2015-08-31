package project.com.rentcar.core.listAdapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import project.com.rentcar.R;
import project.com.rentcar.core.models.Vehicle;
import project.com.rentcar.ui.SelectCateogryActivity;

public class VehicleAdapter extends ArrayAdapter<Vehicle> {
    SelectCateogryActivity ArraylistVehicle;
    int Resource;
    Context context;
    LayoutInflater vi;

    public VehicleAdapter(Context context, int resource, SelectCateogryActivity objects) {
        super(context, resource, (List<Vehicle>) objects);

        ArraylistVehicle = objects;
        Resource = resource;
        this.context = context;
        vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
           convertView = vi.inflate(Resource,null);
            holder = new ViewHolder();

            holder.imageView = (ImageView)convertView.findViewById(R.id.ivImage);
            holder.tvMake = (TextView)convertView.findViewById(R.id.tvMake);
            holder.tvModel = (TextView)convertView.findViewById(R.id.tvModel);
            holder.tvVin = (TextView)convertView.findViewById(R.id.tvVin);
            holder.tvReg = (TextView)convertView.findViewById(R.id.tvRegistration);
            holder.tvYeat = (TextView)convertView.findViewById(R.id.tvYear);
            holder.tvEngine = (TextView)convertView.findViewById(R.id.tvEngine);
            holder.tvColor = (TextView)convertView.findViewById(R.id.tvColor);
            holder.tvDoor = (TextView)convertView.findViewById(R.id.tvDoor);
            holder.tvSeat = (TextView)convertView.findViewById(R.id.tvSeat);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();

        }
        new DownloadImageTask(holder.imageView).execute(ArraylistVehicle.get(position).getImage);
        holder.tvMake.setText(ArraylistVehicle.get(position).getMake);
        holder.tvModel.setText(ArraylistVehicle.get(position).getModel());
        holder.tvVin.setText(ArraylistVehicle.get(position).getVin());
        holder.tvReg.setText(ArraylistVehicle.get(position).getRegistration());
        holder.tvYeat.setText(ArraylistVehicle.get(position).getYear());
      //  holder.tvEngine.setText(ArraylistVehicle.get(position).getEngine());
        holder.tvColor.setText(ArraylistVehicle.get(position).getColor());
        holder.tvDoor.setText(ArraylistVehicle.get(position).getDoorsNumber());
        holder.tvSeat.setText(ArraylistVehicle.get(position).getSeatsNumber());

        return convertView;
    }

    public class ViewHolder {
        public ImageView imageView;
        public TextView tvMake;
        public TextView tvModel;
        public TextView tvYeat;
        public TextView tvReg;
        public TextView tvVin;
        public TextView tvEngine;
        public TextView tvColor;
        public TextView tvDoor;
        public TextView tvSeat;
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }

    }
}


