package po.mybus.com.base;

/**
 * Created by Chandra on 12/02/2018.
 */

public class Dummy {
    public String dummyJadwal(){
        String response ="[{\"start\":\"Jakarta Selatan\",\"end\":\"Cibodas Bogor - Jawa Barat\",\"tanggal\":\"05 Desember 2017\",\"amount\":\"IDR 2.300.000\",\"sisaDay\":\"2 Hari\",\"sisaMnt\":\"10:45 menit\"},{\"start\":\"Jakarta Selatan\",\"end\":\"Anyer - Banten\",\"tanggal\":\"06 Desember 2017\",\"amount\":\"IDR 3.200.000\",\"sisaDay\":\"2 Hari\",\"sisaMnt\":\"11:12 menit\"},{\"start\":\"Jakarta Selatan\",\"end\":\"Karawaci - Tangerang Kota\",\"tanggal\":\"08 Desember 2017\",\"amount\":\"IDR 1.600.000\",\"sisaDay\":\"3 Hari\",\"sisaMnt\":\"02:25 menit\"}]";
        return response;
    }
    public String dummyBT(){
        String response ="[{\"nopol\":\"B 1234 BOS\",\"type\":\"Luxury Class - Commuter\",\"seat\":19,\"status\":1,\"reason\":\"\",\"photo\":\"photobus1\"},{\"nopol\":\"B 2534 BUS\",\"type\":\"Standard Class - Medium\",\"seat\":29,\"status\":2,\"reason\":\"Sudah dipesan offline\",\"photo\":\"photobus2\"}]";
        return response;
    }
}
