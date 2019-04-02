package quickstartx.kural.activitys.home;

import android.os.Bundle;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import quickstartx.kural.R;
import quickstartx.kural.utils.BaseActivity;

public class TabbedActivity extends BaseActivity
        implements TabOneFragment.onFragmentInteraction,
        TabTwoFragment.onFragmentInteraction,
        TabThreeFragment.onFragmentInteraction{

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @BindView(R.id.tablayout)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.view_pager_tabbed);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        SpannableString sp  = new SpannableString("xxx");
        showToast("Hello",sp,2);

        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));

       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {

               mViewPager.setCurrentItem(tab.getPosition());

           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });

       mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
           tabLayout.getTabAt(position).select();
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });

    }


    @Override
    public void onFragmentItemClick1() {

    }

    @Override
    public void onFragmentItemClick2() {

    }

    @Override
    public void onFragmentItemClick3() {

    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return TabOneFragment.newInstance(position);

                case 1:
                    return TabTwoFragment.newInstance(position);

                case 2:
                    return TabThreeFragment.newInstance(position);

                default:
                    return TabTwoFragment.newInstance(0);
            }

        }

        @Override
        public int getCount() {
            // Show total pages.
            return 3;
        }
    }
}
