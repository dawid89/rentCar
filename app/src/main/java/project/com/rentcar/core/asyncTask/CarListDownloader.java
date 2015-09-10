package project.com.rentcar.core.asyncTask;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;

public class CarListDownloader extends AsyncTask<String, Void, InputStream> {

    String url = "http://192.168.0.2:8080/RentCarServer/resources/luxury?limit=30&accessToken=1441813653607";
    Context ctx;

    public CarListDownloader(Context ctx, String url) {
        this.ctx = ctx;
        this.url = url;
    }


    protected InputStream doInBackground(String... urls) {

        DefaultHttpClient client = new DefaultHttpClient();

        HttpGet getRequest = new HttpGet(url);

        try {

            HttpResponse getResponse = client.execute(getRequest);
            final int statusCode = getResponse.getStatusLine().getStatusCode();

            if (statusCode != HttpStatus.SC_OK) {
                Log.w(getClass().getSimpleName(), "Error " + statusCode + " for URL " + url);
                return null;
            }

            HttpEntity getResponseEntity = getResponse.getEntity();
            return getResponseEntity.getContent();

        } catch (ClientProtocolException e) {
            Log.e("Error: ", Log.getStackTraceString(e));
        } catch (IOException e) {
            Log.e("Error: ", Log.getStackTraceString(e));
        } catch (IllegalStateException e) {
            Log.e("Error: ", Log.getStackTraceString(e));
        }

        return null;

    }

    private void feedGsonWithHTTP(InputStream source) {
//        try {
//            Gson gson = new Gson();
//            Reader reader = new InputStreamReader(source);
//             LuxCarListAdapter response = gson.fromJson(reader,
//             LuxCarListAdapter.class);
//             List<Vehicle> results = response.getView(url,ctx);
//             Vehicle vehicle = results.get(0);
//             String string = vehicle.getMake();
//        } catch (Exception e) {
//            Log.e("Error", Log.getStackTraceString(e));
//        }
//        Toast.makeText(ctx, "ok", Toast.LENGTH_LONG).show();

    }

    protected void onPostExecute(InputStream result) {
        feedGsonWithHTTP(result);
    }
}