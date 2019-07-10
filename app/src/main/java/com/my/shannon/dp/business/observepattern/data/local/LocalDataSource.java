package com.my.shannon.dp.business.observepattern.data.local;

import com.my.shannon.dp.business.observepattern.ObserveContract;
import com.my.shannon.dp.business.observepattern.data.bean.PaperBean;

import java.util.ArrayList;
import java.util.List;

public class LocalDataSource implements ObserveContract.DataSource {
    @Override
    public List<PaperBean> requestData() {
        List<PaperBean> list = new ArrayList<>();
        PaperBean bean1 = new PaperBean("sorry,no cache news","Sorry");
        list.add(bean1);
        return list;

    }
}
