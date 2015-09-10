package project.com.rentcar.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import project.com.rentcar.R;
import project.com.rentcar.core.listAdapters.CityListAdapter;

public class MapActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        setupList();
    }

    private void setupList() {
        ListView cityListView = (ListView) findViewById(R.id.city_list_lv);
        CityListAdapter cityListAdapter = new CityListAdapter(this, generateFakeCityList());
        cityListView.setAdapter(cityListAdapter);
    }

    private ArrayList<String> generateFakeCityList() {
        ArrayList<String> cityList = new ArrayList<String>();
        cityList.add("Lublin");
        cityList.add("Warszawa");
        cityList.add("Poznań");
        cityList.add("Chełm");
        cityList.add("Gdańsk");
        cityList.add("Wrocław");
        cityList.add("Kraków");
        cityList.add("Konin");
        cityList.add("Krasnystaw");
        cityList.add("Wielun");
        cityList.add("Tarnow");
        cityList.add("Wlodawa");
        cityList.add("Szczecin");
        cityList.add("Olsztyn");
        cityList.add("Poniatowa");
        cityList.add("Gdynia");
        return cityList;
    }
}
