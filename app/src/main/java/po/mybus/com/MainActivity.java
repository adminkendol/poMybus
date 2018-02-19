package po.mybus.com;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import de.hdodenhof.circleimageview.CircleImageView;
import po.mybus.com.navbar.AppBaseActivity;

public class MainActivity extends AppBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.menu);
        setSupportActionBar(toolbar);
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setHomeButtonEnabled(false);
        //actionBar.setIcon(R.drawable.menu);
        //actionBar.setHomeAsUpIndicator(R.drawable.menu);
        //actionBar.setDisplayShowHomeEnabled(true);
        //actionBar.setDisplayHomeAsUpEnabled(true);
        final ToggleButton tb = (ToggleButton) findViewById(R.id.toggleButton);
        final TextView status_toolbar=(TextView) findViewById(R.id.status_toolbar);
        tb.setChecked(true);
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tb.isChecked()){
                    status_toolbar.setText("Status aktif");
                }else {
                    status_toolbar.setText("Status tidak aktif");
                }
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            //You can get
            Log.d("NAV","OPEN");
            bukaMenu();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
