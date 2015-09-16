package project.com.rentcar.core.asyncTask;


import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import project.com.rentcar.core.models.Vehicle;

public class CarListDownloader extends AsyncTask<String, Void, String> {
    private String parsedString = "";
    private Context ctx;

    public CarListDownloader(Context ctx, String parsedString) {
        this.ctx = ctx;
        this.parsedString = parsedString;
    }


    protected String doInBackground(String... urls) {

        try {

            URL url = new URL("http://192.168.0.2:8080/RentCarServer/resources/luxury?limit=30&accessToken=1442419687320");
            URLConnection conn = url.openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();

            Gson gson = new Gson();
            Type vehicleType = new TypeToken<Vehicle>() {}.getType();
            gson.fromJson(url, vehicleType);

            InputStream is = httpConn.getInputStream();
            parsedString = convertinputStreamToString(is);



            return convertinputStreamToString(is);
        } catch (Exception e) {
            e.printStackTrace();

        }

        return "";
    }

    public static String convertinputStreamToString(InputStream ists) throws IOException {
        if (ists != null) {
            StringBuilder sb = new StringBuilder();
            String line;




            try {
                BufferedReader r1 = new BufferedReader(new InputStreamReader(
                        ists, "UTF-8"));
                while ((line = r1.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            } finally {
                ists.close();
            }

            return sb.toString();
        } else {


          return "";
        }
        }



    @Override
    protected void onPostExecute(String s) {

    }
}
