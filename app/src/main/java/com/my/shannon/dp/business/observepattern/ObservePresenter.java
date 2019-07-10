package com.my.shannon.dp.business.observepattern;

import com.my.shannon.dp.business.observepattern.data.DataRepository;
import com.my.shannon.dp.business.observepattern.data.bean.PaperBean;
import com.my.shannon.dp.business.observepattern.data.local.LocalDataSource;
import com.my.shannon.dp.business.observepattern.data.remote.RemoteDataSource;

import java.util.List;

public class ObservePresenter implements ObserveContract.Presenter {

    ObserveContract.View mView;
    DataRepository mRepository;

    public ObservePresenter(ObserveContract.View view) {

        mView = view;
        mRepository = new DataRepository(new LocalDataSource(), new RemoteDataSource());
        mView.setPresenter(this);
    }

    @Override
    public void requestData() {
        List<PaperBean> list = mRepository.requestData(true);
        if (null == list || list.size() == 0) {
            mView.onLoadFail();
        } else {
            mView.onLoad(list);
        }
    }
}
