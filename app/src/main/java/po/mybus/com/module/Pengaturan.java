package po.mybus.com.module;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Locale;
import java.util.regex.Pattern;

import po.mybus.com.BuildConfig;
import po.mybus.com.MainActivity;
import po.mybus.com.R;
import po.mybus.com.adapters.BtAdapter;
import po.mybus.com.helper.LanguageHelper;
import po.mybus.com.storages.Session;

/**
 * Created by Chandra on 16/02/2018.
 */

public class Pengaturan extends AppCompatActivity {

    private Toolbar toolbar;
	
    private TextView status_toolbar;
	private Vibrator vib;
    private ToggleButton toggleButtonGetarJob;
    private ToggleButton toggleButtonGetarTouch;
    private TextView info_email;
    private TextView info_imei;
    private TextView info_dev;
    private TextView info_ver;
    Session session;
    String pilih;
    String num;
    String lg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pengaturan);
        
		session = new Session(getApplicationContext());
        num = session.getLang();
        Log.d("lang id",num);
        if(num.equals("0")){
            lg = "en";
        }else{
            lg = "in";
        }
        LanguageHelper.setAppLocale(lg, Pengaturan.this);

        
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back);
        
		status_toolbar = (TextView) findViewById(R.id.status_toolbar);
		status_toolbar.setText(R.string.toolbar_pengaturan);
		vib = (Vibrator) getSystemService(this.VIBRATOR_SERVICE);
        toggleButtonGetarJob = (ToggleButton) findViewById(R.id.toggleButtonGetarJob);
        toggleButtonGetarTouch = (ToggleButton) findViewById(R.id.toggleButtonGetarTouch);

        toggleButtonGetarJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButtonGetarJob.isChecked()) {
                    vib.vibrate(3000); // 5000 miliseconds = 5 seconds
                }
            }
        });
        toggleButtonGetarTouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButtonGetarTouch.isChecked()) {
                    vib.vibrate(3000); // 5000 miliseconds = 5 seconds
                }
            }
        });

        Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
        Account[] accounts = AccountManager.get(this).getAccounts();
        String possibleEmail = null;
        for (Account account : accounts) {
            if (emailPattern.matcher(account.name).matches()) {
                possibleEmail = account.name;
            }
        }
        info_email = (TextView) findViewById(R.id.info_email);
        info_email.setText(possibleEmail);
        info_imei = (TextView) findViewById(R.id.info_imei);
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        info_imei.setText(getDeviceID(telephonyManager));

        String androidId = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
        info_dev = (TextView) findViewById(R.id.info_dev);
        info_dev.setText(androidId);
        String versionName = BuildConfig.VERSION_NAME;
        info_ver = (TextView) findViewById(R.id.info_ver);
        info_ver.setText(versionName);

        ImageView locNext = (ImageView) findViewById(R.id.locNext);
        locNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(
                        new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        });

        ImageView ringNext = (ImageView) findViewById(R.id.ringNext);
        ringNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_NOTIFICATION);
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "Select Tone");
                //intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, (Uri) null);
                startActivityForResult(intent, 5);
            }
        });

        ImageView langNext = (ImageView) findViewById(R.id.langNext);
        langNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLang();
            }
        });
    }
    private void dialogLang(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setTitle("Choose an animal");
        final String[] info = {"English", "Indonesia"};
        int checkedItem = 1; // cow
        Log.d("num",num);
        if(num.isEmpty()){
            checkedItem = 1;
        }else{
            checkedItem = Integer.parseInt(num);
        }
        builder.setSingleChoiceItems(info, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("SELECTED",info[which]);
                pilih = String.valueOf(which);
            }
        });
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                session.setLang(pilih);
                if(pilih.equals("0")){
					lg = "en";
				}else{
					lg = "in";
				}
				LanguageHelper.setAppLocale(lg, Pengaturan.this);
				recreate();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    /*public String getDeviceIMEI() {
        String deviceUniqueIdentifier = null;
        TelephonyManager tm = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        if (null != tm) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                //return TODO;
                deviceUniqueIdentifier = tm.getDeviceId();
            }

        }
        if (null == deviceUniqueIdentifier || 0 == deviceUniqueIdentifier.length()) {
            deviceUniqueIdentifier = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        return deviceUniqueIdentifier;
    }*/
    String getDeviceID(TelephonyManager phonyManager) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return "Error Permission";
        }
        String id = phonyManager.getDeviceId();
        if (id == null){
            id = "not available";
        }
        int phoneType = phonyManager.getPhoneType();
        switch(phoneType){
            case TelephonyManager.PHONE_TYPE_NONE:
                return "NONE: " + id;
            case TelephonyManager.PHONE_TYPE_GSM:
                //return "GSM: IMEI=" + id;
                return id;
            case TelephonyManager.PHONE_TYPE_CDMA:
                return "CDMA: MEID/ESN=" + id;
                /*
                *  for API Level 11 or above
                *  case TelephonyManager.PHONE_TYPE_SIP:
                *   return "SIP";
                */
            default:
                return "UNKNOWN: ID=" + id;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            Log.d("NAV","BACK");
            Intent intent;
            intent = new Intent(Pengaturan.this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
