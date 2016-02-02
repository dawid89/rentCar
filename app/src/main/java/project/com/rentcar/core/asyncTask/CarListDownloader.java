package project.com.rentcar.core.asyncTask;


import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import project.com.rentcar.R;
import project.com.rentcar.core.interfaces.ProcessedCarListDownloading;
import project.com.rentcar.core.models.Vehicle;

public class CarListDownloader extends AsyncTask<Integer, Void, ArrayList<Vehicle>> {
    private String parsedString = "";
    private Context ctx;
    private ProcessedCarListDownloading processedCarListDownloading;


        public CarListDownloader(ProcessedCarListDownloading processedCarListDownloading, Context ctx) {
            this.processedCarListDownloading = processedCarListDownloading;
            this.ctx = ctx;
        }

        @Override
        protected ArrayList<Vehicle> doInBackground(Integer... params) {
            String listCarJson = ctx.getString(R.string.LuxCarJson);
            Gson gson = new Gson();
            return gson.fromJson(listCarJson, new TypeToken<ArrayList<Vehicle>>() {
            }.getType());
        }

        @Override
        protected void onPostExecute(ArrayList<Vehicle> vehicleList) {

            super.onPostExecute(vehicleList);
            if (vehicleList == null || vehicleList.size() == 0) {
                processedCarListDownloading.onFail();
            } else {
                processedCarListDownloading.onSucces(vehicleList);
                return;

            }
        }
    }