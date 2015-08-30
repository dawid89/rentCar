package project.com.rentcar.core.asyncTask;


import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import project.com.rentcar.core.models.Vehicle;

public class VehicleAsynTask extends AsyncTask<String,Void,Boolean> {

    @Override
    protected Boolean doInBackground(String... urls) {
        try {

            //------------------>>
            HttpGet httppost = new HttpGet(urls[0]);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(httppost);

            // StatusLine stat = response.getStatusLine();
            int status = response.getStatusLine().getStatusCode();

            if (status == 200) {
                HttpEntity entity = response.getEntity();
                String data = EntityUtils.toString(entity);


                JSONObject jsono = new JSONObject(data);
                JSONArray jarray = jsono.getJSONArray("vehicle");

                for (int i = 0; i < jarray.length(); i++) {
                    JSONObject object = jarray.getJSONObject(i);

                    Vehicle vehicle = new Vehicle();

                    vehicle.setMake(object.getString("Make"));
                    vehicle.setModel(object.getString("Model"));
                    vehicle.setYear(object.getInt("Year"));



                }
                return true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
