package com.francis.mvvm.ui.profile

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.francis.mvvm.R
import com.francis.mvvm.base.BaseFragment
import com.francis.mvvm.ui.main.MainListener
import com.francis.mvvm.utils.UiUtils
import kotlinx.android.synthetic.main.fragment_profile_landing.*


class ProfileLandingFragment : BaseFragment(), ProfleAdapter.ClickListener, MainListener {

    private var viewModel: ProfileViewModel? = null
    private var actionList: MutableLiveData<ArrayList<ProfileAction>>? = MutableLiveData()
    private var adapter: ProfleAdapter? = null

    private var TAG: String = this::class.java.simpleName
    private lateinit var mContext: Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile_landing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUi()
    }

    private fun setUi() {
        setInstance()
        setValue()
        setAction()
    }

    private fun setInstance() {
        mContext = context!!
        mainActivity?.setListener(this)
        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        adapter = ProfleAdapter(context, this)
        recProfile.layoutManager = LinearLayoutManager(context)
        recProfile.adapter = adapter
    }

    private fun setValue() {
        actionList = viewModel?.getActionList()

    }

    private fun setAction() {
        actionList?.observe(this, Observer {
            setAdpList(it)
        })

    }

    private fun setAdpList(list: ArrayList<ProfileAction>?) {
        if (list != null && list.size > 0) adapter?.setAdapterList(list) else Log.e("Empty", "List")
    }

    override fun onItemClick(position: Int, item: ProfileAction) {
    }

    override fun onDetach() {
        super.onDetach()
        actionList = null

    }

    override fun onBackPressed() {
        onBackPressedBase()
        UiUtils.showToast(mContext, "Back press " + TAG)
    }




}
