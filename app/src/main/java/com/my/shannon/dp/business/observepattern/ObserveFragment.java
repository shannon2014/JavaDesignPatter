package com.my.shannon.dp.business.observepattern;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.my.shannon.dp.R;
import com.my.shannon.dp.base.fragment.BaseFragment;
import com.my.shannon.dp.business.observepattern.data.bean.PaperBean;
import com.my.shannon.dp.business.observepattern.example.PaperReader;
import com.my.shannon.dp.business.observepattern.example.PaperSubject;

import java.util.List;

public class ObserveFragment extends BaseFragment implements ObserveContract.View {
    ObserveContract.Presenter mPresenter;
    TextView tvSubject, tvSubjectSwitcher;
    TextView tvReader1, tvSubscribe1;
    TextView tvReader2, tvSubscribe2;
    TextView tvReader3, tvSubscribe3;

    PaperSubject mSubject;
    PaperReader mReader1;
    PaperReader mReader2;
    PaperReader mReader3;

    List<PaperBean> mPaperList;
    int currentPaper = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_observe, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View v) {
        tvSubject = (TextView) v.findViewById(R.id.tv_sub);
        tvSubjectSwitcher = (TextView) v.findViewById(R.id.tv_sub_switch);
        tvSubjectSwitcher.setOnClickListener(listener);

        tvReader1 = (TextView) v.findViewById(R.id.tv_read_1);
        tvSubscribe1 = (TextView) v.findViewById(R.id.tv_subscribe_1);
        tvSubscribe1.setOnClickListener(listener);

        tvReader2 = (TextView) v.findViewById(R.id.tv_read_2);
        tvSubscribe2 = (TextView) v.findViewById(R.id.tv_subscribe_2);
        tvSubscribe2.setOnClickListener(listener);

        tvReader3 = (TextView) v.findViewById(R.id.tv_read_3);
        tvSubscribe3 = (TextView) v.findViewById(R.id.tv_subscribe_3);
        tvSubscribe3.setOnClickListener(listener);

        mSubject = new PaperSubject();
        mReader1 = new PaperReader();
        mReader2 = new PaperReader();
        mReader3 = new PaperReader();

        mPresenter.requestData();
    }


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_sub_switch:
                    currentPaper = (currentPaper + 1) % mPaperList.size();
                    mSubject.setPaper(mPaperList.get(currentPaper));
                    tvSubject.setText(mPaperList.get(currentPaper).title);
                    tvReader1.setText(mReader1.getThinking());
                    tvReader2.setText(mReader2.getThinking());
                    tvReader3.setText(mReader3.getThinking());
                    break;
                case R.id.tv_subscribe_1:
                    if (mSubject.isRegister(mReader1)) {
                        mSubject.unregisterObserver(mReader1);
                    } else {
                        mSubject.registerObserver(mReader1);
                    }
                    break;
                case R.id.tv_subscribe_2:
                    if (mSubject.isRegister(mReader2)) {
                        mSubject.unregisterObserver(mReader2);
                    } else {
                        mSubject.registerObserver(mReader2);
                    }
                    break;
                case R.id.tv_subscribe_3:
                    if (mSubject.isRegister(mReader3)) {
                        mSubject.unregisterObserver(mReader3);
                    } else {
                        mSubject.registerObserver(mReader3);
                    }
                    break;
            }
        }
    };

    @Override
    public void onLoad(List<PaperBean> beanList) {
        mPaperList = beanList;
    }

    @Override
    public void onLoadFail() {
        mPaperList = null;
    }

    @Override
    public void setPresenter(ObserveContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
