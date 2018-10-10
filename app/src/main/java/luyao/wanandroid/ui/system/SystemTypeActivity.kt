package luyao.wanandroid.ui.system

import android.support.v4.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_system_detail.*
import luyao.wanandroid.R
import luyao.wanandroid.base.BaseActivity
import luyao.wanandroid.bean.SystemParent

/**
 * Created by Lu
 * on 2018/3/27 20:42
 */
class SystemTypeActivity : BaseActivity() {

    companion object {
        const val ARTICLE_LIST = "article_list"
    }

    private val systemParent: SystemParent by lazy { intent.getSerializableExtra(ARTICLE_LIST) as SystemParent }

    override fun getLayoutResId() = R.layout.activity_system_detail

    override fun initView() {
        mToolbar.run {
            title = systemParent.name
            setNavigationIcon(R.drawable.arrow_back)
        }

        initViewPager()
    }


    override fun initData() {
        mToolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun initViewPager() {
        viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int) = SystemTypeFragment.newInstance(systemParent.children[position].id)

            override fun getCount() = systemParent.children.size

            override fun getPageTitle(position: Int) = systemParent.children[position].name

        }
        tabLayout.setupWithViewPager(viewPager)
    }
}