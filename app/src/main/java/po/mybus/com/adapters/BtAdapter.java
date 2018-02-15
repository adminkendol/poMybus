package po.mybus.com.adapters;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.InputStream;
import java.util.List;

import po.mybus.com.R;
import po.mybus.com.models.btModel;
import po.mybus.com.models.jadwalModel;
import po.mybus.com.module.BusTersedia;

/**
 * Created by Chandra on 11/02/2018.
 */

public class BtAdapter extends RecyclerView.Adapter<BtAdapter.BtViewHolder> {
    Context context;
    String pilih;
    public static class BtViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        public ImageView photo;
        public TextView nopol;
        public TextView type;
        public TextView seat;
        public TextView reason;
        public ToggleButton tb;
        BtViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            photo=(ImageView)itemView.findViewById(R.id.photo);
            nopol = (TextView)itemView.findViewById(R.id.nopol);
            type = (TextView)itemView.findViewById(R.id.type);
            seat = (TextView)itemView.findViewById(R.id.seat);
            reason = (TextView)itemView.findViewById(R.id.reason);
            tb = (ToggleButton)itemView.findViewById(R.id.toggleButton);
        }
    }
    List<btModel> bM;

    public BtAdapter(List<btModel> bMs){
        this.bM = bMs;
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    @Override
    public BtViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bt_item, viewGroup, false);
        BtViewHolder jvh = new BtViewHolder(v);
        context = viewGroup.getContext();
        return jvh;
    }
    @Override
    public void onBindViewHolder(final BtViewHolder btViewHolder, int i) {
        int id = context.getResources().getIdentifier(bM.get(i).photo, "drawable", context.getPackageName());
        btViewHolder.photo.setImageResource(id);
        btViewHolder.nopol.setText(bM.get(i).nopol);
        btViewHolder.type.setText(bM.get(i).type);
        btViewHolder.seat.setText(String.valueOf(bM.get(i).seat)+" seat");
        btViewHolder.reason.setText("- "+bM.get(i).reason);
        if(bM.get(i).status.equals(1)){
            btViewHolder.tb.setChecked(true);
        }else{
            btViewHolder.tb.setChecked(false);
        }

        btViewHolder.tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!btViewHolder.tb.isChecked()){
                    dialogFitur(btViewHolder);
                }else {
                    btViewHolder.reason.setText("");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return bM.size();
    }

    private void dialogFitur(final BtViewHolder btViewHolder){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //builder.setTitle("Choose an animal");
        final String[] info = {"Armada dalam perbaikan", "Sudah dipesan offline","Tidak ada pengemudi","Lainnya"};
        final int checkedItem = 1; // cow
        pilih = info[1];
        builder.setSingleChoiceItems(info, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // user checked an item
                Log.d("SELECTED",info[which]);
                pilih = info[which];
            }
        });
        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // user clicked OK
                //Log.d("SELECTED",info[checkedItem]);
                btViewHolder.reason.setText(pilih);
            }
        });
        //builder.setNegativeButton("Cancel", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
