package d0440672.iecs.fcu.horoscopel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_MONTH="KEY_MONTH";
    public static final String KEY_DAY="KEY_DAY";
    EditText etday,etmonth;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etmonth=(EditText)findViewById(R.id.month_edit);
        etday=(EditText)findViewById(R.id.day_edit);

        submit=(Button)findViewById(R.id.submit_btn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int day=Integer.parseInt(etday.getText().toString());
                int month=Integer.parseInt(etmonth.getText().toString());

              Intent intent=new Intent();
                intent.setClass(MainActivity.this,Main2Activity.class);
                intent.putExtra(KEY_MONTH,month);
                intent.putExtra(KEY_DAY,day);
               startActivity(intent);
            }
        });

        SharedPreferences pref=getSharedPreferences("PREF_BIRTH",MODE_PRIVATE);
        int pref_month=pref.getInt("PREF_KEY_MONTH",1);
        int pref_day=pref.getInt("PREF_KEY_DAY",1);
        etmonth.setText(""+pref_month);
        etday.setText(""+pref_day);
    }

    public void onStop(){
        super.onStop();

        SharedPreferences pref= getSharedPreferences("PREF_BIRTH",MODE_PRIVATE);

        SharedPreferences.Editor preEdt=pref.edit();

        preEdt.putInt("PREF_KEY_MONTH",Integer.parseInt(etmonth.getText().toString()));
        preEdt.putInt("PREF_KEY_DAY",Integer.parseInt(etday.getText().toString()));
        preEdt.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
