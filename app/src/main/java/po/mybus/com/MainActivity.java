package po.mybus.com;

import android.content.Intent;
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
import po.mybus.com.module.Bantuan;
import po.mybus.com.module.Profile;
import po.mybus.com.helper.LanguageHelper;
import po.mybus.com.storages.Session;
import po.mybus.com.navbar.AppBaseActivity;

public class MainActivity extends AppBaseActivity {
	
	private String st;
	private String stNon;
	private Session session;
    private String num;
    private String lg;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		session = new Session(getApplicationContext());
		num = session.getLang();
        Log.d("lang id",num);
        if(num.equals("0")){
            lg = "en";
			st="Active";
			stNon="Not Active";
        }else{
            lg = "in";
			st="Status aktif";
			stNon="Status tidak aktif";
        }
        LanguageHelper.setAppLocale(lg, MainActivity.this);
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
		status_toolbar.setText(st);
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tb.isChecked()){
					//st = "Status aktif";
					status_toolbar.setText(st);
                }else {
					//st = "Status tidak aktif";
                    status_toolbar.setText(stNon);
                }
            }
        });
		//status_toolbar.setText(st);
        CircleImageView profile_image = (CircleImageView)findViewById(R.id.profile_image);
        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
                finish();
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
