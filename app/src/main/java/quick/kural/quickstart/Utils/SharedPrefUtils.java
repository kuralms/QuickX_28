package quick.kural.quickstart.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kural on 23/3/18.
 */

public class SharedPrefUtils {
    public static String AppPreference = "AppPreference";
    public static String RegisterSuccess = "RegisterSuccess" ;
    public static String OtpVerify = "OtpVerify";

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("APP_PREF", Context.MODE_PRIVATE);
    }

    public static void storeApiKey(Context context, String apiKey) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString("API_KEY", apiKey);
        editor.commit();
    }

    public static String getApiKey(Context context) {
        return getSharedPreferences(context).getString("API_KEY", null);
    }

}
