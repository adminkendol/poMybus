package po.mybus.com.module.tabs;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import po.mybus.com.R;
import po.mybus.com.adapters.RiwayatAdapter;
import po.mybus.com.adapters.jadwalAdapter;
import po.mybus.com.adapters.promoAdapter;
import po.mybus.com.base.Dummy;
import po.mybus.com.models.jadwalModel;
import po.mybus.com.models.promoModel;

/**
 * Created by Chandra on 14/02/2018.
 */

@SuppressLint("ValidFragment")
public class RiwayatItem extends Fragment {

    private List<jadwalModel> rM;
    private RecyclerView rv;
    private String rA;
    private String data;

    @SuppressLint("ValidFragment")
    public RiwayatItem(String data){
        this.data=data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.riwayat,container,false);
        rv=(RecyclerView) view.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        JSONArray datas = null;
        try {
            datas= new JSONArray(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            initializeData(datas);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        initializeAdapter();

        return view;
    }

    private void initializeData(JSONArray datas) throws JSONException {
        rM = new ArrayList<>();

        for(Integer i=0;i<datas.length();i++){
            JSONObject jO= datas.getJSONObject(i);
            rM.add(new jadwalModel(jO.getString("start"),jO.getString("end"),jO.getString("tanggal"),jO.getString("amount"),"",""));
        }
    }

    private void initializeAdapter(){
        RiwayatAdapter adapter = new RiwayatAdapter(rM);
        rv.setAdapter(adapter);
    }

}
