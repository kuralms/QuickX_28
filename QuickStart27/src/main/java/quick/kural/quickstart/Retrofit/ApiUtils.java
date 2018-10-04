package quick.kural.quickstart.Retrofit;

import android.content.Context;

import quick.kural.quickstart.BuildConfig;

/**
 * Created by kural on 10/10/17.
 */

public class ApiUtils {


        private ApiUtils() {}

        public static final String BASE_URL = BuildConfig.URL;

        public static ApiInterface getAPIService() {

            return RetroFitClient.getClient(BASE_URL).create(ApiInterface.class);
        }

        public static ApiInterface getAPIServiceRx(Context context) {

            return RetroFitBuilderReactive.getRxClient(BASE_URL,context)
                    .create(ApiInterface.class);
        }

}
