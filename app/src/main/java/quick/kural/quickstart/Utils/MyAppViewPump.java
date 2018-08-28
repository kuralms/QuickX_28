package quick.kural.quickstart.Utils;


import android.app.Application;
import com.squareup.leakcanary.LeakCanary;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.calligraphy3.FontMapper;
import io.github.inflationx.viewpump.ViewPump;
import quick.kural.quickstart.R;
import quick.kural.quickstart.Utils.fontHelper.CustomViewWithTypefaceSupport;
import quick.kural.quickstart.Utils.fontHelper.TextField;


public class MyAppViewPump extends Application {



    private static MyAppViewPump mInstance;




    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("font/Raleway-Regular.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .setFontMapper(new FontMapper() {
                                    @Override
                                    public String map(String font) {
                                        return font;
                                    }
                                })
                                .addCustomViewWithSetTypeface(CustomViewWithTypefaceSupport.class)
                                .addCustomStyle(TextField.class, R.attr.textFieldStyle)
                                .build()))
                .build());
    }



    public static synchronized MyAppViewPump getInstance() {
        return mInstance;
    }



}