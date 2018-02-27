package po.mybus.com.storages;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Chandra on 24/02/2018.
 */

public class Session {
    SharedPreferences.Editor editor;
    Context _context;
    private SharedPreferences pref;
    int PRIVATE_MODE = 0;
    public Session(Context context){
        pref = context.getSharedPreferences("sesdata", Context.MODE_PRIVATE);
        editor = pref.edit();
    }
    public void setLang(String data) {
        editor.putString("lang", data).commit();
        editor.commit();
    }
    public String getLang() {
        String data = pref.getString("lang","");
        return data;
    }
}
