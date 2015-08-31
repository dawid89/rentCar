package project.com.rentcar.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import project.com.rentcar.R;
import project.com.rentcar.core.asyncTask.VehicleAsynTask;
import project.com.rentcar.core.listAdapter.VehicleAdapter;
import project.com.rentcar.core.models.Vehicle;

public class SelectCateogryActivity extends ActionBarActivity {
    private Button luxButton, ecoButton, busButton, truButton, mapButton, aboutButton;
    ListView list;
    VehicleAdapter adapter;
    ArrayList<Vehicle> vehiclelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cateogry);
        luxButton = (Button) findViewById(R.id.luxButton);
        ecoButton = (Button) findViewById(R.id.ecoButton);
        busButton = (Button) findViewById(R.id.busButton);
        truButton = (Button) findViewById(R.id.truckButton);
        mapButton = (Button) findViewById(R.id.mapButton);
        aboutButton = (Button) findViewById(R.id.aboutButton);
        final ListView list = (ListView) findViewById(R.id.list_lv);
        vehiclelist = new ArrayList<Vehicle>();

        new VehicleAsynTask().execute("http://localhost:8080/RentCarServer/resources/luxury?limit=30&accessToken=1440831749586");


        luxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectCateogryActivity.this, VehicleAsynTask.class);
                startActivity(i);


            }
        });
        ecoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        busButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        truButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_cateogry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void add(Vehicle vehicle) {
    }

    public void setAdapter(VehicleAdapter adapter) {
        this.adapter = adapter;
    }

    public void get(int position) {
    }

}
