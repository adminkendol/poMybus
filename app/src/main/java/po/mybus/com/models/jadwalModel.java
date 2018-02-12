package po.mybus.com.models;

/**
 * Created by chandra on 11/02/2018.
 */

public class jadwalModel {
    public String start;
    public String end;
    public String tanggal;
    public String amount;
    public String sisaDay;
    public String sisaMnt;

    public jadwalModel(String start, String end, String tanggal, String amount, String sisaDay, String sisaMnt){
        this.start=start;
        this.end=end;
        this.tanggal=tanggal;
        this.amount=amount;
        this.sisaDay=sisaDay;
        this.sisaMnt=sisaMnt;
    }
}
