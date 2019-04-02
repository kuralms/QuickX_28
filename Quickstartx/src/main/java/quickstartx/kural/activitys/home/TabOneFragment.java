package quickstartx.kural.activitys.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import quickstartx.kural.R;
import quickstartx.kural.utils.BaseObject;
import quickstartx.kural.utils.RecyclerViewGridAdapter;


public class TabOneFragment extends Fragment implements RecyclerViewGridAdapter.RecylerGridInterface {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private onFragmentInteraction mListener;
    private RecyclerViewGridAdapter recyclerViewGridAdapter;
    private ArrayList<BaseObject> baseObjects = new ArrayList<>();
    private BaseObject baseObject;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TabOneFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static TabTwoFragment newInstance(int columnCount) {
        TabTwoFragment fragment = new TabTwoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onStart() {
        super.onStart();



    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_tool);

        Toast.makeText(getContext(), "--", Toast.LENGTH_SHORT).show();

        for (int i = 0; i < 10; i++) {
            baseObject = new BaseObject("https://github.com/bumptech/glide/blob/master/static/glide_logo.png",
                    ""+i,""+"--------");
            baseObjects.add(baseObject);
        }

        recyclerViewGridAdapter = new RecyclerViewGridAdapter(getContext(),this,baseObjects);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onFragmentInteraction) {
            mListener = (onFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void recyclerItemClicked(int positionOfClick) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface onFragmentInteraction {
        // TODO: Update argument type and name
        void onFragmentItemClick1();
    }
}
