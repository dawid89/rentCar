package project.com.rentcar.core.asyncTask;


import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import project.com.rentcar.R;
import project.com.rentcar.core.interfaces.Processed;
import project.com.rentcar.core.models.Vehicle;

public class CarListDownloader extends AsyncTask<Integer, Void, ArrayList<Vehicle>> {

    private Processed processed;
    private Context ctx;

    public CarListDownloader(Processed processed,Context ctx){
        this.processed = processed;
        this.ctx = ctx;
    }


    @Override
    protected ArrayList<Vehicle> doInBackground(Integer... params) {
        String LuxCarJson = ctx.getString(R.string.LuxCarJson);
        Gson gson = new Gson();
        return gson.fromJson(LuxCarJson, new TypeToken<ArrayList<Vehicle>>() {
        }.getType());
    }

    @Override
    protected void onPostExecute(ArrayList<Vehicle> vehicles) {
        super.onPostExecute(vehicles);
        if (vehicles == null || vehicles.size() == 0) {
            processed.OnFail();
        } else {
            processed.OnSuccess(vehicles);
        }
    }
}
