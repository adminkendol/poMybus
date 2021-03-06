package po.mybus.com;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import po.mybus.com.module.Order;
import po.mybus.com.helper.LanguageHelper;
import po.mybus.com.storages.Session;
import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
	Session session;
    String num;
    String lg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
		reload();
		session = new Session(getApplicationContext());
		num = session.getLang();
        Log.d("lang id",num);
        if(num.equals("0")){
            lg = "en";
        }else{
            lg = "in";
        }
        LanguageHelper.setAppLocale(lg, LoginActivity.this);
		
	}
	@Override
	public void onResume(){
		super.onResume();
		setContentView(R.layout.activity_login);
		reload();
	}
	/*@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// refresh your views here
		setContentView(R.layout.activity_login);
		super.onConfigurationChanged(newConfig);
	}*/
	protected void reload(){
		Button button = (Button) findViewById(R.id.email_sign_in_button);
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
			// TODO Auto-generated method stub
				startActivity(new Intent(LoginActivity.this, Order.class));
				finish();
			}
		});
		TextView daftar = (TextView) findViewById(R.id.daftar);
		daftar.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
				finish();
			}
		});
	}
	
}