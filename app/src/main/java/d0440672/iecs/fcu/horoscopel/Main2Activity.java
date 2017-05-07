package d0440672.iecs.fcu.horoscopel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView show;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        show=(TextView)findViewById(R.id.print_tv);
        back=(Button)findViewById(R.id.back_btn);

        Intent intent=getIntent();//*******************************************************常忽略
        int month=intent.getIntExtra(MainActivity.KEY_MONTH,1);
        int day=intent.getIntExtra(MainActivity.KEY_DAY,1);

        show.setText(month+"/"+day+"? who fucking care!");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
