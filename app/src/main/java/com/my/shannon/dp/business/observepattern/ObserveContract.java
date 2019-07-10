package com.my.shannon.dp.business.observepattern;

import com.my.shannon.dp.base.mvp.BasePresenter;
import com.my.shannon.dp.base.mvp.BaseView;
import com.my.shannon.dp.business.observepattern.data.bean.PaperBean;

import java.util.List;

public interface ObserveContract {

    interface View extends BaseView<Presenter> {
        void onLoad(List<PaperBean> beanList);
        void onLoadFail();
    }

    interface Presenter extends BasePresenter {
        void requestData();
    }

    interface DataSource{
        List<PaperBean> requestData();
    }
}

