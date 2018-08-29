package quick.kural.quickstart.activitys.FragmentDialouge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import quick.kural.quickstart.R;


public class GdprFragmentDialougePrivacyandTerms extends DialogFragment {

    int mNum;
    String title;
    AcceptGdprInterface acceptGdprInterface;
    CheckBox cb_accept;
    TextView tv_privacy,tv_terms;


    /**
     * Create a new instance of MyDialogFragment, providing "num"
     * as an argument.
     */
    public static GdprFragmentDialougePrivacyandTerms newInstance(String title, int verifyType) {
        GdprFragmentDialougePrivacyandTerms f = new GdprFragmentDialougePrivacyandTerms();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putInt("verifyType", verifyType);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof GdprFragmentDialougePrivacyandTerms.AcceptGdprInterface) {
            acceptGdprInterface = (GdprFragmentDialougePrivacyandTerms.AcceptGdprInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement AcceptGdprInterfaceInteractionListener");
        }
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("verifyType");
        title = getArguments().getString("title");

     /*   // Pick a style based on the num.
        int style = DialogFragment.STYLE_NORMAL, theme = 0;
        switch ((mNum-1)%6) {
            case 1: style = DialogFragment.STYLE_NO_TITLE; break;
            case 2: style = DialogFragment.STYLE_NO_FRAME; break;
            case 3: style = DialogFragment.STYLE_NO_INPUT; break;
            case 4: style = DialogFragment.STYLE_NORMAL; break;
            case 5: style = DialogFragment.STYLE_NORMAL; break;
            case 6: style = DialogFragment.STYLE_NO_TITLE; break;
            case 7: style = DialogFragment.STYLE_NO_FRAME; break;
            case 8: style = DialogFragment.STYLE_NORMAL; break;
        }
        switch ((mNum-1)%6) {
            case 4: theme = android.R.style.Theme_Holo; break;
            case 5: theme = android.R.style.Theme_Holo_Light_Dialog; break;
            case 6: theme = android.R.style.Theme_Holo_Light; break;
            case 7: theme = android.R.style.Theme_Holo_Light_Panel; break;
            case 8: theme = android.R.style.Theme_Holo_Light; break;
        }
        setStyle(style, theme);*/

        setStyle(DialogFragment.STYLE_NO_FRAME,  android.R.style.Theme_Dialog);




    }

    @Override
    public View onCreateView(LayoutInflater inflater,
           ViewGroup container,Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.gdpr_fragment_privacy_terms, container, false);
        cb_accept = v.findViewById(R.id.checkbox_accept_all);
        tv_privacy = v.findViewById(R.id.tv_gdpr_policy);
        tv_terms = v.findViewById(R.id.tv_gdpr_terms);


        tv_privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(getContext().getResources().getString(R.string.privacy_policy_gdpr));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                getActivity().startActivity(intent);
            }
        });
        tv_terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(getContext().getResources().getString(R.string.termsnConditions_gdpr));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                getActivity().startActivity(intent);
            }
        });


        cb_accept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                acceptGdprInterface.btn_accept_gdpr(true);

            }
        });


        return v;
    }



    public interface AcceptGdprInterface{

    void btn_accept_gdpr(Boolean accepted);

    }

}
