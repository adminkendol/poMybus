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

public class jadwalAdapter extends RecyclerView.Adapter<jadwalAdapter.JadwalViewHolder> {

    public static class JadwalViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        public TextView start;
        public TextView end;
        public TextView tgl;
        public TextView amount;
        public TextView sisaDay;
        public TextView sisaMnt;

        JadwalViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            start = (TextView)itemView.findViewById(R.id.start);
            end = (TextView)itemView.findViewById(R.id.end);
            tgl = (TextView)itemView.findViewById(R.id.tgl);
            amount = (TextView)itemView.findViewById(R.id.amount);
            sisaDay = (TextView)itemView.findViewById(R.id.sisaDay);
            sisaMnt = (TextView)itemView.findViewById(R.id.sisaMnt);
        }
    }
    List<jadwalModel> jM;

    public jadwalAdapter(List<jadwalModel> jMs){
        this.jM = jMs;
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    @Override
    public JadwalViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.jadwal_item, viewGroup, false);
        JadwalViewHolder jvh = new JadwalViewHolder(v);
        return jvh;
    }
    @Override
    public void onBindViewHolder(JadwalViewHolder jadwalViewHolder, int i) {
        jadwalViewHolder.start.setText(jM.get(i).start);
        jadwalViewHolder.end.setText(jM.get(i).end);
        jadwalViewHolder.tgl.setText(jM.get(i).tanggal);
        jadwalViewHolder.amount.setText(jM.get(i).amount);
        jadwalViewHolder.sisaDay.setText(jM.get(i).sisaDay);
        jadwalViewHolder.sisaMnt.setText(jM.get(i).sisaMnt);
    }

    @Override
    public int getItemCount() {
        return jM.size();
    }
}
