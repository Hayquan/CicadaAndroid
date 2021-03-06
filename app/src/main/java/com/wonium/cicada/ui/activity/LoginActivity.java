/*
 * Copyright (C) 2019 Ethan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wonium.cicada.ui.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wonium.cicada.R;
import com.wonium.cicada.databinding.ActivityLoginBinding;
import com.wonium.cicada.router.PageRouter;
import com.wonium.cicada.base.BaseActivity;

@Route(path = PageRouter.ACTIVITY_LOGIN)
public class LoginActivity extends BaseActivity {
    private ActivityLoginBinding mBinding;

    @Override
    protected int getStatusColor() {
        return getResources().getColor(R.color.black);
    }

    @Override
    public void initWindowAttributes() {
        setAllowFullScreen(true);
        setScreenRotate(false);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void bindLayout(int layoutResId) {
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        mBinding.btnLogin.setOnClickListener(v -> ARouter.getInstance().build(PageRouter.ACTIVITY_MAIN).navigation(getContext()));
        mBinding.tvRegisterAccount.setOnClickListener(v -> ARouter.getInstance().build(PageRouter.ACTIVITY_REGISTER).navigation(getContext()));
    }
}
