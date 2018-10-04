package quick.kural.quickstart.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import quick.kural.quickstart.R;
import quick.kural.quickstart.Retrofit.Objects.Obj_vp_data;

import quick.kural.quickstart.Retrofit.Objects.spacex.RespSpaceX;
import quick.kural.quickstart.Utils.GlideApp;

public class GridAdapterSpacex extends RecyclerView.Adapter<GridAdapterSpacex.ViewHolder> {
   private RecylerGridInterface rvInterface_main;
   private List<RespSpaceX> mValues;
   private Context context_main;


        public GridAdapterSpacex(Context context,
                                 RecylerGridInterface rvInterface,
                                 List<RespSpaceX> items){
        mValues = items;
        rvInterface_main = rvInterface;
        context_main=context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.adapter_spacex, parent, false);
        return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RespSpaceX mItem = mValues.get(position);


        GlideApp.with(context_main)
        .load(mItem.getLinks().getMissionPatch())
        .circleCrop()
        //.placeholder(R.drawable.logo)
        .into(holder.imageView);

        holder.tv_heading.setText(mItem.getMissionName());



        holder.mView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        if (null != rvInterface_main) {
        // Notify the active callbacks interface (the activity, if it
            // is attached to one) that an item has been selected.
        rvInterface_main.recyclerItemClicked(position);



        }
        }
        });



        }


    class ViewHolder extends RecyclerView.ViewHolder {

            View mView;
            ImageView imageView;
            TextView tv_heading;
            ViewHolder(View view) {
            super(view);
            mView = view;
            imageView = mView.findViewById(R.id.imageView_vp_main);
            tv_heading = mView.findViewById(R.id.textView_vp_heading);

    }



    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public interface RecylerGridInterface{

         void recyclerItemClicked(int positionOfClick);

    }


}