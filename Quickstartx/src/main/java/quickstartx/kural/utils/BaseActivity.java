package quickstartx.kural.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.text.SpannableString;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import quickstartx.kural.R;

public class BaseActivity extends AppCompatActivity {

    ToastCustom toastCustom;
    ProgressDialog mProgressDialog;
    private int PROGRESS_DIALOG_COUNTER = 0;

    public void showAlert(String message, boolean dismissible){

        final Dialog dialog = new Dialog(this, R.style.Theme_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if(!dismissible){
            dialog.setCancelable(false);}
        dialog.setContentView(R.layout.dialouge_alert);

        TextView text = (TextView) dialog.findViewById(R.id.tv_alert_dialogue_message);
        text.setText(message);

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_alert_dialogue_ok);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    public Activity getViewContext() {
        return BaseActivity.this;
    }

    public void showToast(String title, SpannableString message, int gravity){
        toastCustom = new ToastCustom(this);
        SpannableString ss =  new SpannableString(message);
        toastCustom.ShowToast(title,ss,gravity);
    }

    public void hideSoftKeyboard() {

        if (this.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this
                    .getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(),
                    0);
        }

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    public void showLoadingDialog(boolean iScancellable) {

        if (mProgressDialog == null) {

            mProgressDialog = new ProgressDialog(BaseActivity.this);
            mProgressDialog.setMessage("Please wait...");
            if(!iScancellable){
            mProgressDialog.setCancelable(false);
            mProgressDialog.setIndeterminate(true);}
            try{
                mProgressDialog.show();
            } catch (Exception e){
                e.printStackTrace();
            }
            PROGRESS_DIALOG_COUNTER++;

        } else {
            PROGRESS_DIALOG_COUNTER++;
            try{
                mProgressDialog.show();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    public void hideLoadingDialog() {

        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            PROGRESS_DIALOG_COUNTER--;
            if (PROGRESS_DIALOG_COUNTER == 0){
                try {
                    mProgressDialog.cancel();
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mProgressDialog != null && mProgressDialog.isShowing()){
            try {
                mProgressDialog.cancel();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
