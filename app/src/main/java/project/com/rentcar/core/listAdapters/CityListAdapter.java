package project.com.rentcar.core.listAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import project.com.rentcar.R;


public class CityListAdapter extends BaseAdapter {
    private ArrayList<String> cityList;
    private LayoutInflater inflater;
    private Context ctx;
    private int lastposition;

    public CityListAdapter(Context ctx, ArrayList<String> cityList) {
        this.cityList = cityList;
        this.ctx = ctx;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return cityList.size();
    }

    @Override
    public String getItem(int position) {
        return cityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView( int position, View convertView, ViewGroup parent) {
        final String city = cityList.get(position);
        ViewHolder holder = null;


        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.city_list_row, null);
            holder.cityNameTv = (TextView) convertView.findViewById(R.id.city_name_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.cityNameTv.setText(city);

        Animation animation = null;
        if (position >= lastposition){
            animation = AnimationUtils.loadAnimation(ctx, R.anim.slide_from_top);
        } else {
            animation = AnimationUtils.loadAnimation(ctx, R.anim.slide_from_bottom);
        }
        animation.setDuration(350);
        convertView.setAnimation(animation);
        lastposition = position;

        return convertView;
    }

    public class ViewHolder {
            TextView cityNameTv;
    }

}


