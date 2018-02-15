package po.mybus.com.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import po.mybus.com.R;
import po.mybus.com.models.jadwalModel;
import po.mybus.com.models.promoModel;

/**
 * Created by Chandra on 11/02/2018.
 */

public class promoAdapter extends RecyclerView.Adapter<promoAdapter.PromoViewHolder> {

    public static class PromoViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        public TextView title;
        public TextView descriptiom;

        PromoViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            title = (TextView)itemView.findViewById(R.id.title);
            descriptiom = (TextView)itemView.findViewById(R.id.description);
        }
    }
    List<promoModel> pM;

    public promoAdapter(List<promoModel> pMs){
        this.pM = pMs;
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    @Override
    public PromoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.promo_item, viewGroup, false);
        PromoViewHolder pvh = new PromoViewHolder(v);
        return pvh;
    }
    @Override
    public void onBindViewHolder(PromoViewHolder promoViewHolder, int i) {
        promoViewHolder.title.setText(pM.get(i).title);
        promoViewHolder.descriptiom.setText(pM.get(i).description);
    }

    @Override
    public int getItemCount() {
        return pM.size();
    }
}
