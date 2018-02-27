package po.mybus.com;

import android.app.Application;
import android.content.Context;

import po.mybus.com.helper.LocaleHelper;
import po.mybus.com.storages.Session;

public class MainApplication extends Application {
	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
	}
}
