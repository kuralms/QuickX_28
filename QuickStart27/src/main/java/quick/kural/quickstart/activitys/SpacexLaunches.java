package quick.kural.quickstart.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import quick.kural.quickstart.Adapters.GridAdapterSpacex;
import quick.kural.quickstart.Adapters.RecyclerViewGridAdapter;
import quick.kural.quickstart.R;
import quick.kural.quickstart.Retrofit.ApiInterface;
import quick.kural.quickstart.Retrofit.ApiUtils;
import quick.kural.quickstart.Retrofit.Objects.Obj_vp_data;
import quick.kural.quickstart.Retrofit.Objects.spacex.RespSpaceX;
import quick.kural.quickstart.activitys.FragmentDialouge.FragmentDialougeSpaceXDetails;
import quick.kural.quickstart.activitys.FragmentDialouge.GdprFragmentDialougePrivacyandTerms;


public class SpacexLaunches extends BaseActivity
        implements GridAdapterSpacex.RecylerGridInterface,
FragmentDialougeSpaceXDetails.FragmentSpacexInterface{

    @BindView(R.id.shimmer_recycler_view)
    ShimmerRecyclerView recyclerView_launches;

    @BindView(R.id.tb_normal_title)
    TextView tv_title;

    CompositeDisposable disposableSpacexResp = new CompositeDisposable();

    GridAdapterSpacex rv_adapter_launches;
    ApiInterface mAPIService;


    List<RespSpaceX> datas_from_spacex = new ArrayList<>();
    RespSpaceX data_obj;

    FragmentDialougeSpaceXDetails fragmentDialougeSpaceXDetails;
    FragmentTransaction ft;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spacex);
        ButterKnife.bind(this);
        tv_title.setText("SpaceX Launches");
        mAPIService = ApiUtils.getAPIServiceRx(this);




        mtd_call_spacex_api();

        ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("Details dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        fragmentDialougeSpaceXDetails = fragmentDialougeSpaceXDetails.newInstance("Show Details",1);
        fragmentDialougeSpaceXDetails.setCancelable(false);


    }

    private void mtd_update_recycler() {


        recyclerView_launches.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        rv_adapter_launches = new GridAdapterSpacex(getApplicationContext(),SpacexLaunches.this,datas_from_spacex);
        recyclerView_launches.setAdapter(rv_adapter_launches);

      /*  recyclerView_launches.postDelayed(new Runnable() {
            @Override
            public void run() {
                mtd_call_spacex_api();
            }
        }, 100);
*/
    }

    private void mtd_call_spacex_api() {

        disposableSpacexResp.add(mAPIService.rf_spaceXResp()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<RespSpaceX>>() {
                                   @Override
                                   public void onSuccess(List<RespSpaceX> respSpaceXES) {

                                       if(respSpaceXES.size() != 0){

                                           datas_from_spacex = respSpaceXES;
                                           mtd_update_recycler();
                                           rv_adapter_launches.notifyDataSetChanged();

                                       }else {

                                       Toast.makeText(SpacexLaunches.this, "Are sure you are not offline ?", Toast.LENGTH_SHORT).show();
                                       }


                                   }

                                   @Override
                                   public void onError(Throwable e) {

                                   }
                               }));







            /*
            // Using clear will clear all, but can accept new disposable
                    disposables.clear();
            // Using dispose will clear all and set isDisposed = true, so it will not accept any new disposable
                    disposables.dispose();*/


    }

    @Override
    public void recyclerItemClicked(int positionOfClick) {

        fragmentDialougeSpaceXDetails.show(ft, ""+positionOfClick);

    }


    @Override
    public void btn_close() {

    }
}
