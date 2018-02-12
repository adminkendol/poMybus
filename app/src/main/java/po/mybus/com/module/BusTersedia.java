package po.mybus.com.module;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import po.mybus.com.adapters.BtAdapter;
import po.mybus.com.adapters.jadwalAdapter;
import po.mybus.com.base.Dummy;
import po.mybus.com.models.btModel;
import po.mybus.com.models.jadwalModel;

/**
 * Created by Chandra on 12/02/2018.
 */

public class BusTersedia extends AppCompatActivity {
    private List<btModel> bM;
    private RecyclerView rv;
    private String bA;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_tersedia);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back);
        TextView judul = (TextView)findViewById(R.id.status_toolbar);
        judul.setText("Bus Tersedia");
        rv=(RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        try {
            initializeData();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        initializeAdapter();
    }
    private void initializeData() throws JSONException {
        bM = new ArrayList<>();
        Dummy dum = new Dummy();
        bA =dum.dummyBT();
        JSONArray jsonArray =null;
        try {
            jsonArray = new JSONArray(bA);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for(Integer i=0;i<jsonArray.length();i++){
            JSONObject jO= jsonArray.getJSONObject(i);
            bM.add(new btModel(jO.getString("nopol"),jO.getString("type"),Integer.parseInt(jO.getString("seat")),Integer.parseInt(jO.getString("status")),jO.getString("reason"),jO.getString("photo")));
        }
    }

    private void initializeAdapter(){
        BtAdapter adapter = new BtAdapter(bM);
        rv.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            Log.d("NAV","BACK");
            Intent intent;
            intent = new Intent(BusTersedia.this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
