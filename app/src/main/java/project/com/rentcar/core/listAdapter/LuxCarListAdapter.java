package project.com.rentcar.core.listAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import project.com.rentcar.R;
import project.com.rentcar.core.models.Vehicle;


public class LuxCarListAdapter extends BaseAdapter {
    private ArrayList<Vehicle> vehicleslist;
    private LayoutInflater inflater;
    private Context ctx;

    public LuxCarListAdapter(Context ctx, ArrayList<Vehicle> vehicleslist) {
        this.vehicleslist = vehicleslist;
        this.ctx = ctx;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return vehicleslist.size();
    }

    @Override
    public Vehicle getItem(int position) {
        return vehicleslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView( int position, View convertView, ViewGroup parent) {
        final Vehicle vehicle = vehicleslist.get(position);
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.car_list_row, null);
            holder = new ViewHolder();
            holder.car_tile_title_tv = (TextView) convertView.findViewById(R.id.car_tile_title_tv);
            holder.car_price_tv = (TextView) convertView.findViewById(R.id.car_price_tv);
            holder.car_tile_available_indicator_iv = (ImageView) convertView.findViewById(R.id.car_tile_available_indicator_iv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.car_tile_title_tv.setText(vehicle.getMake()+"\n"+vehicle.getModel());
        holder.car_price_tv.setText(vehicle.getPrice());
        return convertView;
    }




    public class ViewHolder {
            TextView car_tile_title_tv,car_price_tv;
            ImageView car_tile_available_indicator_iv;
    }

}


