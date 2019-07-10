package com.my.shannon.dp.business.observepattern.data.remote;

import com.my.shannon.dp.business.observepattern.ObserveContract;
import com.my.shannon.dp.business.observepattern.data.bean.PaperBean;

import java.util.ArrayList;
import java.util.List;

public class RemoteDataSource implements ObserveContract.DataSource {

    @Override
    public List<PaperBean> requestData() {
        List<PaperBean> list = new ArrayList<>();
        PaperBean bean1 = new PaperBean("big news","ShenZhen Paper");
        PaperBean bean2 = new PaperBean("my news","RenMing Paper");
        PaperBean bean3 = new PaperBean("nothing news","Zaker Paper");
        PaperBean bean4 = new PaperBean("other news","TouTiao Paper");
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        return list;
    }
}
