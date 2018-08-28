package quick.kural.quickstart.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import quick.kural.quickstart.activitys.FragmentDialouge.GdprFragmentDialougePrivacyandTerms;
import quick.kural.quickstart.R;

/**
 * Created by kural .
 */

public class RegistrationActivity extends AppCompatActivity
        implements GdprFragmentDialougePrivacyandTerms.AcceptGdprInterface{



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

    }

    @Override
    public void btn_accept_gdpr(Boolean accepted) {

    }


}
