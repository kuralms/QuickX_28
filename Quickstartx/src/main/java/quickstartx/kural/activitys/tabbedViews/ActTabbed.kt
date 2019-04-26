package quickstartx.kural.activitys.tabbedViews

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager

import quickstartx.kural.R
import quickstartx.kural.activitys.tabbedViews.ui.main.FragmentGrid
import quickstartx.kural.activitys.tabbedViews.ui.main.SectionsPagerAdapter
import quickstartx.kural.activitys.tabbedViews.ui.main.dummy.DummyContent
import quickstartx.kural.utils.BaseActivity

class ActTabbed : BaseActivity(),FragmentGrid.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabbed2)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)



    }
}