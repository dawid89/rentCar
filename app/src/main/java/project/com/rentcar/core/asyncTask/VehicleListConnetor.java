package project.com.rentcar.core.asyncTask;

import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import project.com.rentcar.core.interfaces.ProcessFinish;

public class VehicleListConnetor extends AsyncTask<String, Void, String> {
    public static final String URL = "http://192.168.0.2:8080/RentCarServer/resources/luxury?limit=15&accessToken=1439018505747";


    private ProcessFinish processFinish;

    public VehicleListConnetor(ProcessFinish processFinish) {
        this.processFinish = processFinish;
    }

    @Override
    protected String doInBackground(String... strings) {
        String url = URL;

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

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s == null || s.equals("")) {
            processFinish.onFail();
        } else {
            processFinish.onSucces(s);
        }

    }
}
