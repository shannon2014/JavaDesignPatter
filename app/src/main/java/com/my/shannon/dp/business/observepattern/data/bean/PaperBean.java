package com.my.shannon.dp.business.observepattern.data.bean;

import com.my.shannon.dp.base.bean.BaseBean;

public class PaperBean extends BaseBean {
    public String title;
    public String publisher;

    public PaperBean(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }
}
