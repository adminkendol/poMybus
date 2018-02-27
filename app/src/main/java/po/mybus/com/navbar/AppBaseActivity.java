package po.mybus.com.navbar;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import po.mybus.com.R;
import po.mybus.com.module.Bantuan;
import po.mybus.com.module.BusTersedia;
import po.mybus.com.module.Jadwal;
import po.mybus.com.module.Pengaturan;
import po.mybus.com.module.Promo;
import po.mybus.com.module.Riwayat;

/**
 * Created by Chandra on 09/02/2018.
 */

public abstract class AppBaseActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener {
    private FrameLayout view_stub; //This is the framelayout to keep your content view
    private NavigationView navigation_view; // The new navigation view from Android Design Library. Can inflate menu resources. Easy
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Menu drawerMenu;
    private TextView footer_item_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);// The base layout that contains your navigation drawer.
        view_stub = (FrameLayout) findViewById(R.id.view_stub);
        navigation_view = (NavigationView) findViewById(R.id.navigation_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, 0, 0);
        mDrawerToggle.setDrawerIndicatorEnabled(false); //disable "hamburger to arrow" drawable
        //mDrawerToggle.setHomeAsUpIndicator(R.drawable.menu); //set your own
        //mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);


        drawerMenu = navigation_view.getMenu();
        for(int i = 0; i < drawerMenu.size(); i++) {
            drawerMenu.getItem(i).setOnMenuItemClickListener(this);
        }
        // and so on...
        footer_item_2 = (TextView)findViewById(R.id.footer_item_2);
        footer_item_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                //Intent intentC;
                //intentC = new Intent(AppBaseActivity.this, Pengaturan.class);
                //intentC.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
                startActivity(new Intent(AppBaseActivity.this, Pengaturan.class));
				//startActivity( intentC );
				finish();
            }
        });
    }
    public void bukaMenu(){
        mDrawerLayout.openDrawer(GravityCompat.START);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    /* Override all setContentView methods to put the content view to the FrameLayout view_stub
     * so that, we can make other activity implementations looks like normal activity subclasses.
     */
    @Override
    public void setContentView(int layoutResID) {
        if (view_stub != null) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            View stubView = inflater.inflate(layoutResID, view_stub, false);
            view_stub.addView(stubView, lp);
        }
    }

    @Override
    public void setContentView(View view) {
        if (view_stub != null) {
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            view_stub.addView(view, lp);
        }
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (view_stub != null) {
            view_stub.addView(view, params);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            Log.d("NAV","OPEN");
            return true;
        }
        // Handle your other action bar items...
		int id = item.getItemId();
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                Intent intentA;
                intentA = new Intent(AppBaseActivity.this, BusTersedia.class);
                intentA.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
                this.startActivity( intentA );
                finish();
                break;
            case R.id.item2:
                // do whatever
                mDrawerLayout.closeDrawer(GravityCompat.START);
                Intent intentE;
                intentE = new Intent(AppBaseActivity.this, Riwayat.class);
                intentE.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
                this.startActivity( intentE );
                finish();
                break;
            case R.id.item3:
				mDrawerLayout.closeDrawer(GravityCompat.START);
                Intent intent;
                intent = new Intent(AppBaseActivity.this, Jadwal.class);
                //startActivity(intent);
				intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
				this.startActivity( intent );
                finish();
                break;
            // and so on...
            case R.id.item4:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                Intent intentB;
                intentB = new Intent(AppBaseActivity.this, Promo.class);
                intentB.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
                this.startActivity( intentB );
                finish();
                break;
            case R.id.item5:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                Intent intentD;
                intentD = new Intent(AppBaseActivity.this, Bantuan.class);
                intentD.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
                this.startActivity( intentD );
                finish();
                break;
        }
        return false;
		//item.getItemId() = 0;
    }
    public void exit() {
        @SuppressLint("RestrictedApi")
        ContextThemeWrapper ctw = new ContextThemeWrapper(this, R.style.AppTheme_PopupOverlay);
        AlertDialog.Builder builder = new AlertDialog.Builder(ctw);
        builder.setMessage("Apakah Anda ingin keluar dari aplikasi ?")
                .setCancelable(false)
                .setPositiveButton("Ya", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                android.os.Process.killProcess(android.os.Process.myPid());
                            }
                        })
                .setNegativeButton("Tidak", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int arg1) {
                                // TODO Auto-generated method stub
                                dialog.cancel();
                            }

                        }).show();
    }
    //int backButtonCount = 0;
    public void onBackPressed(){
        exit();
        /*if(backButtonCount >= 1){
            exit();
        }else{
            Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }*/
    }
}
