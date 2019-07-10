package com.my.shannon.dp.business.observepattern.example;

import com.my.shannon.dp.business.observepattern.data.bean.PaperBean;
import com.my.shannon.dp.business.observepattern.pattern.Observer;
import com.my.shannon.dp.business.observepattern.pattern.Subject;

import java.util.ArrayList;
import java.util.List;

public class PaperSubject implements Subject {
    List<Observer> mList = new ArrayList<>();
    PaperBean paperBean;

    @Override
    public void registerObserver(Observer o) {
        if (null == mList) {
            mList = new ArrayList<>();
        }
        if (mList.contains(o)) {
            mList.remove(o);
        }
        mList.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        if (null == mList || !mList.contains(o)) {
            return;
        }
        mList.remove(o);
    }

    @Override
    public void notifyObserver() {
        if (null == mList || mList.size() == 0) {
            return;
        }
        for (Observer o : mList) {
            o.update(this);
        }
    }

    @Override
    public boolean isRegister(Observer o) {
        if (null == mList || !mList.contains(o)) {
            return false;
        }
        return true;
    }

    public void setPaper(PaperBean bean) {
        paperBean = bean;
        notifyObserver();
    }

    public PaperBean getPaper() {
        return paperBean;
    }
}
