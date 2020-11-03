package com.aadil.assingment.ui.summary

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aadil.assingment.R
import com.aadil.assingment.adapter.SummaryAdapter
import com.aadil.assingment.ui.summary.scochers.ScorchersFragment
import com.aadil.assingment.ui.summary.heat.HeatFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.summary_fragment.*


class SummaryFragment : Fragment() {

    companion object {
        fun newInstance() = SummaryFragment()
    }

    private lateinit var viewModel: SummaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.summary_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SummaryViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SummaryAdapter(childFragmentManager)
        adapter.addFragment(ScorchersFragment(),"Scorchers")
        adapter.addFragment(HeatFragment(),"Heat")
        viewpager.adapter = adapter
        tabs.setupWithViewPager(viewpager,true)

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                viewpager.currentItem = tab!!.position
                val fm = requireActivity().supportFragmentManager
                val ft = fm.beginTransaction()
                val count = fm.backStackEntryCount
                if (count >= 1) {
                    requireActivity().supportFragmentManager.popBackStack()
                }
                ft.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
            }

        })
    }


}
