package quickstartx.kural.utils;


import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import quickstartx.kural.R;

/**
 * Created by kural on 28/3/17.
 */
public class ToastCustom {

    private Activity _activity;
    Toast customtoast;
    Context context;
    public ToastCustom(Activity _activity){
        this._activity = _activity;
    }
    float margin_horizantal = 250;
    float margin_vertiac = 50;

    public void ShowToast(String title, SpannableString message, int gravity){

        context=_activity.getApplicationContext();
        LayoutInflater inflater=_activity.getLayoutInflater();
        View customToastroot =inflater.inflate(R.layout.toast_custom, null);
        customtoast=new Toast(context);
        customtoast.setView(customToastroot);
        TextView textTitle = (TextView) customToastroot.findViewById(R.id.tv_toast_title);
        textTitle.setText(title);
        TextView text = (TextView) customToastroot.findViewById(R.id.tv_toast_msg);
        text.setText(message);

        switch (gravity){
            case 1:
                //top
                customtoast.setGravity( Gravity.TOP,0, -150);
                //customtoast.setMargin(margin_horizantal,margin_vertiac);
                customtoast.setDuration(Toast.LENGTH_LONG);

            break;
            case 2:
            // center
                customtoast.setGravity( Gravity.CENTER_VERTICAL,250,150);
                //customtoast.setMargin(margin_horizantal,margin_vertiac);
                customtoast.setDuration(Toast.LENGTH_LONG);

                break;
            default:
                //bottom
                customtoast.setGravity( Gravity.BOTTOM,630,40 );

                customtoast.setDuration(Toast.LENGTH_LONG);

                break;
        }


        new CountDownTimer(4000, 1000)
        {

            public void onTick(long millisUntilFinished) {customtoast.show();}
            public void onFinish() {customtoast.show();}

        }.start();



    }




}
