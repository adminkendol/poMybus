package po.mybus.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import po.mybus.com.module.Order;

/**
 * Created by Chandra on 17/02/2018.
 */

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button) findViewById(R.id.email_sign_in_button);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(RegisterActivity.this, Order.class));

            }
        });
    }


}
