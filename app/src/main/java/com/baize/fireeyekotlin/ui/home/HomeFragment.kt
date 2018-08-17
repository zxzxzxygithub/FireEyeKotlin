package com.baize.fireeyekotlin.ui.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.baize.fireeyekotlin.R
import com.baize.fireeyekotlin.base.BaseFragment
import com.baize.fireeyekotlin.databinding.FragmentHomeBinding
import com.baize.fireeyekotlin.utils.showToast
import com.example.xrecyclerview.XRecyclerView
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by 彦泽 on 2018/8/14.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private var mIsFirst = true
    private var mPrepare = false

    override fun setContent(): Int {
        return R.layout.fragment_home
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        mPrepare = true
        loadData()
    }

    private fun initView() {
        xrv_home.layoutManager = LinearLayoutManager(activity)
        xrv_home.setLoadingMoreEnabled(false)
        xrv_home.setLoadingListener(object : XRecyclerView.LoadingListener {
            override fun onRefresh() {
            }

            override fun onLoadMore() {
            }

        })
    }

    override fun loadData() {
        if (!mPrepare or !mIsFirst or isHidden) {
            return
        }
        activity?.showToast("加载数据了")
        mIsFirst = false
        showContentView()
    }

}