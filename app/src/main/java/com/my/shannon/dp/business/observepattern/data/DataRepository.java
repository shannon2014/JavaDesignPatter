package com.my.shannon.dp.business.observepattern.data;

import com.my.shannon.dp.business.observepattern.data.bean.PaperBean;
import com.my.shannon.dp.business.observepattern.data.local.LocalDataSource;
import com.my.shannon.dp.business.observepattern.data.remote.RemoteDataSource;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class DataRepository {
    private LocalDataSource mLocal;
    private RemoteDataSource mRemote;

    public DataRepository(LocalDataSource localData, RemoteDataSource remoteData) {
        this.mLocal = localData;
        this.mRemote = remoteData;
    }

    public List<PaperBean> requestData(boolean refresh){
        if(refresh){
            return mRemote.requestData();
        }else {
            return mLocal.requestData();
        }
    }

}
