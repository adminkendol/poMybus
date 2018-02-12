package po.mybus.com.module;

import android.os.Bundle;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import po.mybus.com.MainActivity;
import po.mybus.com.R;
import po.mybus.com.adapters.jadwalAdapter;
import po.mybus.com.base.Dummy;
import po.mybus.com.models.jadwalModel;

/**
 * Created by Chandra on 11/02/2018.
 */

public class Jadwal extends AppCompatActivity {
    private List<jadwalModel> jM;
    private RecyclerView rv;
    private String jA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jadwal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeAsUpIndicator(R.drawable.back);

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
        jM = new ArrayList<>();
        Dummy dum = new Dummy();
        jA =dum.dummyJadwal();
        JSONArray jsonArray =null;
        try {
            jsonArray = new JSONArray(jA);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for(Integer i=0;i<jsonArray.length();i++){
            JSONObject jO= jsonArray.getJSONObject(i);
            jM.add(new jadwalModel(jO.getString("start"),jO.getString("end"),jO.getString("tanggal"),jO.getString("amount"),jO.getString("sisaDay"),jO.getString("sisaMnt")));
        }
        //jM.add(new jadwalModel("Jakarta Selatan", "Cibodas Bogor - Jawa Barat", "05 Desember 2017","IDR 2.300.000","2 Hari","10:45 menit"));
    }

    private void initializeAdapter(){
        jadwalAdapter adapter = new jadwalAdapter(jM);
        rv.setAdapter(adapter);
    }
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            Log.d("NAV","BACK");
            Intent intent;
            intent = new Intent(Jadwal.this, MainActivity.class);
            startActivity(intent);
			return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
