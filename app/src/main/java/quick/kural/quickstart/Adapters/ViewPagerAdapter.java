package quick.kural.quickstart.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import quick.kural.quickstart.R;

public class ViewPagerAdapter{}/* extends PagerAdapter {



    Context context;
    LayoutInflater mLayoutInflater;




    public ViewPagerAdapter( Context context, String[] text3)
    {


        context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ( object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        TextView txt1, txt2,txt3;
        ImageView image;

        mLayoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = mLayoutInflater.inflate(R.layout.v_pager_adpter,
                container,false);



        (container).addView(itemView);


        return itemView;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        (container).removeView((View) object);

    }

}


*/