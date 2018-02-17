package po.mybus.com.module;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import po.mybus.com.LoginActivity;
import po.mybus.com.MainActivity;
import po.mybus.com.R;

/**
 * Created by Chandra on 15/02/2018.
 */

public class Order extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        ImageView tutup = (ImageView) findViewById(R.id.tutup);
        final ImageView tombol = (ImageView) findViewById(R.id.tombol);
        tutup.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(Order.this, MainActivity.class));
                finish();

            }
        });
        tombol.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(Order.this, OrderDetail.class));
                finish();

            }
        });
        final int[] imageArray = { R.drawable.order2, R.drawable.order1};
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;
            public void run() {
                tombol.setImageResource(imageArray[i]);
                i++;
                if (i > imageArray.length - 1) {
                    i = 0;
                }
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
