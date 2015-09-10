package project.com.rentcar.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import project.com.rentcar.R;
import project.com.rentcar.core.interfaces.Processed;
import project.com.rentcar.core.listAdapters.LuxCarListAdapter;
import project.com.rentcar.core.models.Vehicle;

public class LuxCarListActivity extends ActionBarActivity implements Processed {

    private ArrayList<Vehicle> vehicleslist;
    private LuxCarListAdapter luxCarListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lux_car_list);
        ListView listView = (ListView) findViewById(R.id.carLux_lv);
        vehicleslist = new ArrayList<Vehicle>();
        luxCarListAdapter = new LuxCarListAdapter(this, vehicleslist);
        listView.setAdapter(luxCarListAdapter);
        //new CarListDownloader(this, this).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lux_car_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnSuccess(ArrayList<Vehicle> vehicles) {
        vehicleslist.addAll(vehicles);
        luxCarListAdapter.notifyDataSetChanged();

    }

    @Override
    public void OnFail() {

    }


}
