package po.mybus.com.models;

/**
 * Created by chandra on 11/02/2018.
 */

public class btModel {
    public String nopol;
    public String type;
    public Integer seat;
    public Integer status;
    public String reason;
    public String photo;

    public btModel(String nopol, String type, Integer seat, Integer status, String reason, String photo){
        this.nopol=nopol;
        this.type=type;
        this.seat=seat;
        this.status=status;
        this.reason=reason;
        this.photo=photo;
    }
}
