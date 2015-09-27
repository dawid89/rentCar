package project.com.rentcar.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import project.com.rentcar.R;

public class AboutActivity extends ActionBarActivity {
    private TextView aboutT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        aboutT = new TextView(this);

        aboutT=(TextView)findViewById(R.id.aboutText);
        aboutT.setText("About:"+"\n\n\n"+"This is rent car\n company with car for\n rent. Below contact\n number");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
