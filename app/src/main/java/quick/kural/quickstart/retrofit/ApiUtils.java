package quick.kural.quickstart.retrofit;

import quick.kural.quickstart.BuildConfig;
import quick.kural.quickstart.R;
import quick.kural.quickstart.SplashActivity;

/**
 * Created by kural on 10/10/17.
 */

public class ApiUtils {


        private ApiUtils() {}

        public static final String BASE_URL = BuildConfig.URL;

        public static ApiInterface getAPIService() {

            return RetroFitClient.getClient(BASE_URL).create(ApiInterface.class);
        }

}
