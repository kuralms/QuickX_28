package quickstartx.kural.networking;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import quickstartx.kural.utils.SharedPrefUtils;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * Created by kural on 10/10/17.
 */

class RetroFitBuilderReactive {

    private static Retrofit retrofit = null;
    private static int REQUEST_TIMEOUT = 60;
    private static OkHttpClient okHttpClient;

   static Retrofit getRxClient(String apiUrl, Context context) {

    if (okHttpClient == null)
        initOkHttp(context);

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(apiUrl)//.addConverterFactory(StringConverterFactory.create()) ->in case of formdata
                    .client(okHttpClient)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static void initOkHttp(final Context context) {

        EventListener eventListenerC = new EventListener() {
            @Override
            public void callStart(Call call) {
                super.callStart(call);

                Toast.makeText(context, "Started", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void callEnd(Call call) {
                super.callEnd(call);
                Toast.makeText(context, "Finish", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void callFailed(Call call, IOException ioe) {
               super.callFailed(call, ioe);
                Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();

            }
        };

        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);



        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(interceptor);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Content-Type", "application/json");

                // Adding Authorization token (API Key)
                // Requests will be denied without API key
                if (!TextUtils.isEmpty(SharedPrefUtils.getApiKey(context))) {
                    requestBuilder.addHeader("Authorization", SharedPrefUtils.getApiKey(context));
                }

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        okHttpClient = httpClient.build();
    }
}
