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
    private ArrayList<Vehicle> vehicles;
    private LayoutInflater inflater;
    private Context context;

    public LuxCarListAdapter(Context context,ArrayList<Vehicle>vehicles){
        this.vehicles = vehicles;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }



    @Override
    public int getCount() {
        return vehicles.size();
    }

    @Override
    public Object getItem(int position) {
        return vehicles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.car_list_row, null);
            holder = new ViewHolder();
            holder.car_tile_title_tv= (TextView)convertView.findViewById(R.id.car_tile_title_tv);
            holder.car_tile_available_indicator_iv = (ImageView)convertView.findViewById(R.id.car_tile_available_indicator_iv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();

        }


        return null;
    }

    public class ViewHolder {
        TextView car_tile_title_tv;
        ImageView car_tile_available_indicator_iv;
    }
}
