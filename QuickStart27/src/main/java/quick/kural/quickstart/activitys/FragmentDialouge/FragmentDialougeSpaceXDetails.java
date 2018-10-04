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
import android.widget.ImageButton;
import android.widget.TextView;

import quick.kural.quickstart.R;


public class FragmentDialougeSpaceXDetails extends DialogFragment {

    int mNum;
    String title;
    FragmentSpacexInterface fragmentSpacexInterface;
    ImageButton ib_close;
    TextView tv_wiki,tv_youtube ,tv_misson,tv_rocket;


    /**
     * Create a new instance of MyDialogFragment, providing "num"
     * as an argument.
     */
    public static FragmentDialougeSpaceXDetails newInstance(String title, int verifyType) {
        FragmentDialougeSpaceXDetails f = new FragmentDialougeSpaceXDetails();

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
        if (context instanceof FragmentDialougeSpaceXDetails.FragmentSpacexInterface) {
            fragmentSpacexInterface = (FragmentDialougeSpaceXDetails.FragmentSpacexInterface) context;
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

        setStyle(DialogFragment.STYLE_NO_FRAME,  DialogFragment.STYLE_NO_TITLE);




    }

    @Override
    public View onCreateView(LayoutInflater inflater,
           ViewGroup container,Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_show_spacex_details, container, false);

        tv_wiki = v.findViewById(R.id.tv_fssd_wiki);
        tv_youtube = v.findViewById(R.id.tv_fssd_youtube);
        ib_close = v.findViewById(R.id.ib_fssd_close);


        tv_wiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(getContext().getResources().getString(R.string.privacy_policy_gdpr));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                getActivity().startActivity(intent);
            }
        });
        tv_youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(getContext().getResources().getString(R.string.termsnConditions_gdpr));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                getActivity().startActivity(intent);
            }
        });


     ib_close.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             dismiss();

         }
     });


        return v;
    }



    public interface FragmentSpacexInterface{

    void btn_close();

    }

}
