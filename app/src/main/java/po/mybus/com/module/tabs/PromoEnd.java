package po.mybus.com.module.tabs;

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
import po.mybus.com.adapters.promoAdapter;
import po.mybus.com.base.Dummy;
import po.mybus.com.models.promoModel;

/**
 * Created by Chandra on 14/02/2018.
 */

public class PromoEnd extends Fragment {

    private List<promoModel> pM;
    private RecyclerView rv;
    private String pA;

    public  PromoEnd(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.promo,container,false);
        rv=(RecyclerView) view.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        try {
            initializeData();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        initializeAdapter();
        return view;
    }

    private void initializeData() throws JSONException {
        pM = new ArrayList<>();
        Dummy dum = new Dummy();
        pA =dum.dummyPromoEnd();
        JSONArray jsonArray =null;
        try {
            jsonArray = new JSONArray(pA);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for(Integer i=0;i<jsonArray.length();i++){
            JSONObject jO= jsonArray.getJSONObject(i);
            pM.add(new promoModel(jO.getString("title"),jO.getString("description")));
        }
    }

    private void initializeAdapter(){
        promoAdapter adapter = new promoAdapter(pM);
        rv.setAdapter(adapter);
    }
}
