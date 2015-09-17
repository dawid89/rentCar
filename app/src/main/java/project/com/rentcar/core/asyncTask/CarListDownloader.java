package project.com.rentcar.core.asyncTask;


import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import project.com.rentcar.core.interfaces.ProcessFinish;
import project.com.rentcar.core.interfaces.ProcessedCarListDownloading;
import project.com.rentcar.core.models.Vehicle;

public class CarListDownloader extends AsyncTask<String, Void, String> {
    private String parsedString = "";
    private Context ctx;
    private ProcessedCarListDownloading processedCarListDownloading;

    public CarListDownloader(Context ctx, ProcessedCarListDownloading processedCarListDownloading) {
        this.ctx = ctx;
        this.processedCarListDownloading = processedCarListDownloading;
    }


    protected String doInBackground(String... urls) {

            String url = "http://192.168.0.2:8080/RentCarServer/resources/luxury?limit=30&accessToken=1442419687320";

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response responses = null;

            try {
                responses = client.newCall(request).execute();
                return responses.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            processedCarListDownloading.onFail();
            return null;
    }


    @Override
    protected void onPostExecute(String json) {
        
        Gson gson = new Gson();
        ArrayList<Vehicle> vehicleList = gson.fromJson(json,  new TypeToken<ArrayList<Vehicle>>() {}.getType());
        processedCarListDownloading.onSucces(vehicleList);

    }
}
