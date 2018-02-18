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

/**
 * Created by Chandra on 11/02/2018.
 */

public class RiwayatAdapter extends RecyclerView.Adapter<RiwayatAdapter.RiwayatViewHolder> {

    public static class RiwayatViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        public TextView start;
        public TextView end;
        public TextView tgl;
        public TextView amount;

        RiwayatViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            start = (TextView)itemView.findViewById(R.id.start);
            end = (TextView)itemView.findViewById(R.id.end);
            tgl = (TextView)itemView.findViewById(R.id.tgl);
            amount = (TextView)itemView.findViewById(R.id.amount);
        }
    }
    List<jadwalModel> jM;

    public RiwayatAdapter(List<jadwalModel> jMs){
        this.jM = jMs;
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    @Override
    public RiwayatViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.riwayat_item, viewGroup, false);
        RiwayatViewHolder jvh = new RiwayatViewHolder(v);
        return jvh;
    }
    @Override
    public void onBindViewHolder(RiwayatViewHolder riwayatViewHolder, int i) {
        riwayatViewHolder.start.setText(jM.get(i).start);
        riwayatViewHolder.end.setText(jM.get(i).end);
        riwayatViewHolder.tgl.setText(jM.get(i).tanggal);
        riwayatViewHolder.amount.setText(jM.get(i).amount);
    }

    @Override
    public int getItemCount() {
        return jM.size();
    }
}
