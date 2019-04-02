package quickstartx.kural.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import quickstartx.kural.R;


public class RecyclerViewGridAdapter extends RecyclerView.Adapter<RecyclerViewGridAdapter.ViewHolder> {
    private RecylerGridInterface rvInterface_main;
    private List<BaseObject> mValues;
    private Context context_main;


        public RecyclerViewGridAdapter(Context context,
                                       RecylerGridInterface rvInterface,
                                       List<BaseObject> items){
        mValues = items;
        rvInterface_main = rvInterface;
        context_main=context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.adpter_grid, parent, false);
        return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaseObject mItem = mValues.get(position);


        Glide.with(context_main)
        .load(mItem.getImage_address())
        .circleCrop()
        .placeholder(R.drawable.logo)
        .into(holder.imageView);



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