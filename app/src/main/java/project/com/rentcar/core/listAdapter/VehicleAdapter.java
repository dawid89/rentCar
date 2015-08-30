package project.com.rentcar.core.listAdapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import project.com.rentcar.core.models.Vehicle;

public class VehicleAdapter extends ArrayAdapter<Vehicle> {

    public VehicleAdapter(Context context, int resource, ArrayList<Vehicle> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    public class ViewHolder{
        public ImageView imageView;
        public TextView tvMake;
        public TextView tvMark;
        public TextView tvYeat;
    }
}
