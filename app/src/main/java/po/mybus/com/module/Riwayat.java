package po.mybus.com.module;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import po.mybus.com.MainActivity;
import po.mybus.com.R;
import po.mybus.com.base.Dummy;
import po.mybus.com.models.promoModel;
import po.mybus.com.module.tabs.PromoEnd;
import po.mybus.com.module.tabs.PromoStart;
import po.mybus.com.module.tabs.RiwayatItem;

/**
 * Created by Chandra on 14/02/2018.
 */

public class Riwayat extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView status_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.riwayat_layout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back);
        status_toolbar = (TextView) findViewById(R.id.status_toolbar);
        status_toolbar.setText("Riwayat");
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        Dummy dum = new Dummy();
        String rA =dum.dummyRiwayat();
        JSONArray jsonArray =null;
        try {
            jsonArray = new JSONArray(rA);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for(Integer i=0;i<jsonArray.length();i++){
            try {
                JSONObject jO= jsonArray.getJSONObject(i);
                adapter.addFragment(new RiwayatItem(jO.getString("data")), jO.getString("hari")+"\n"+jO.getString("tgl_short"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //pM.add(new promoModel(jO.getString("title"),jO.getString("description")));

        }

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            Log.d("NAV","BACK");
            Intent intent;
            intent = new Intent(Riwayat.this, MainActivity.class);
            startActivity(intent);
            finish();
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
