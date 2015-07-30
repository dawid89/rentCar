package project.com.rentcar.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import project.com.rentcar.R;
import project.com.rentcar.core.asyncTask.LoginConnetor;
import project.com.rentcar.core.interfaces.ProcessFinish;


public class LoginActivity extends ActionBarActivity  {

    private EditText username;
    private EditText password;
    private Button button;
    private ProcessFinish processFinish;
    private Context context;
    private Activity act;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = (Button) findViewById(R.id.logButton);
        username = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        context = this;


        processFinish = new ProcessFinish() {
            @Override
            public void onSucces(String string) {
                Toast.makeText(context,"Succes",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFail() {
                Toast.makeText(context,"Fail",Toast.LENGTH_SHORT).show();
            }
        };


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = username.getText().toString();
                String pass = md5(password.getText().toString());
                new LoginConnetor(processFinish).execute(login,pass);


            }
        });



    }

    private String md5(String pass){
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(pass.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
}
