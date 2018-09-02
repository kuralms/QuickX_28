package quick.kural.quickstart.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import quick.kural.quickstart.R;
import quick.kural.quickstart.Retrofit.Objects.Obj_vp_data;
import quick.kural.quickstart.Utils.GlideApp;

public class ViewPagerAdapter extends PagerAdapter {


    Context context_main;
    LayoutInflater mLayoutInflater;
    ViewpagerInterface vpInterface;
    ArrayList<Obj_vp_data> resp_data_list ;



    public ViewPagerAdapter( Context context,ViewpagerInterface vpInterfaceListner, ArrayList<Obj_vp_data> resp_data_array){

        vpInterface = vpInterfaceListner;
        resp_data_list = resp_data_array;
        context_main = context;
    }

    @Override
    public int getCount() {
        return resp_data_list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ( object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        TextView txt1;
        ImageView image;
        Obj_vp_data resp_data;
        resp_data = resp_data_list.get(position);
        mLayoutInflater = (LayoutInflater) context_main
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = mLayoutInflater.inflate(R.layout.v_pager_adpter,
                container,false);
        (container).addView(itemView);



        txt1 = itemView.findViewById(R.id.textView_vp_heading);
        image = itemView.findViewById(R.id.imageView_vp_main);

        txt1.setText(resp_data.getText());
        GlideApp.with(context_main).load(resp_data.getImage_address()).into(image);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vpInterface.onViewPagerItemClick();
            }
        });



        return itemView;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        (container).removeView((View) object);

    }

    public interface ViewpagerInterface{
         void onViewPagerItemClick();

    }

}


