package com.wonium.aclj.ui.activity;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.wonium.aclj.R;
import com.wonium.aclj.databinding.ActivityMainBinding;
import com.wonium.aclj.router.PageRouter;
import com.wonium.aclj.ui.fragment.AccountFragment;
import com.wonium.aclj.ui.fragment.FindFragment;
import com.wonium.aclj.ui.fragment.FriendFragment;
import com.wonium.aclj.ui.fragment.MyFragment;
import com.wonium.aclj.ui.fragment.VideoFragment;
import com.wonium.cicada.ui.BaseActivity;
import com.wonium.cicada.utils.IntentUtil;
import com.wonium.cicada.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * @ClassName: MainActivity
 * @Description: 添加描述
 * @Author: Wonium
 * @E-mail: wonium@qq.com
 * @Blog: https://blog.wonium.com
 * @CreateDate: 2018/11/28 14:14
 * @UpdateUser: 添加更新者
 * @UpdateDate: 2018/11/28 14:14
 * @UpdateDescription: 更新描述
 * @Version:
 */
@Route(path = PageRouter.ACTIVITY_MAIN)
public class MainActivity extends BaseActivity {
    private ActivityMainBinding mBinding;
    private List<Fragment> fragments;

    @Override
    public void initWindowAttributes() {
        setAllowFullScreen(false);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void bindLayout(int layoutResId) {
        mBinding = DataBindingUtil.setContentView(this, layoutResId);
    }

    @Override
    public void initView() {
        // 开启状态栏沉浸
        setStatusBar(true);
        mBinding.setTitle(getString(R.string.app_name));
        initFragment();
    }

    /**
     * 设置状态栏颜色
     * @return
     */
    @Override
    protected int getStatusColor () {
        return getResources().getColor(R.color.black);
    }

    @Override
    public void initListener() {
        mBinding.includeMainContent.bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            int itemId;
            switch (menuItem.getItemId()) {
                case R.id.nav_find:
                    itemId =0;
                    break;
                case R.id.nav_video:
                    itemId=1;
                    break;
                case R.id.nav_my:
                    itemId =2;
                    break;
                case R.id.nav_friend:
                    itemId=3;
                    break;
                case R.id.nav_account:
                    itemId=4;
                    break;
                default:
                    itemId=0;
                    break;
            }
            replaceFragment(lastShowFragment,itemId);
            return true;
        });
    }
    private int lastShowFragment=0;

    private void initFragment() {

        fragments = new ArrayList<>();
        fragments.add(FindFragment.newInstance("FindFragment", "0"));
        fragments.add(VideoFragment.newInstance("VideoFragment", "1"));
        fragments.add(MyFragment.newInstance("MyFragment","2"));
        fragments.add(FriendFragment.newInstance("FriendFragment","3"));
        fragments.add(AccountFragment.newInstance("AccountFragment","4"));
        getSupportFragmentManager()
                .beginTransaction()
                .add(mBinding.includeMainContent.container.getId(),fragments.get(0))
                .show(fragments.get(0))
                .commitAllowingStateLoss();
    }

    private  void replaceFragment(int lastShowFragment,int index){
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments.get(lastShowFragment));
        this.lastShowFragment =index;
        if (!fragments.get(index).isAdded()){
            transaction.add(mBinding.includeMainContent.container.getId(),fragments.get(index));
        }
        transaction.show(fragments.get(index)).commitAllowingStateLoss();
    }



}
