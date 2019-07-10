package com.my.shannon.dp.business.observepattern.example;

import com.my.shannon.dp.business.observepattern.pattern.Observer;
import com.my.shannon.dp.business.observepattern.pattern.Subject;

public class PaperReader implements Observer {
    private String thinking = "";

    @Override
    public void update(Subject s) {
        setThinking((PaperSubject) s);
    }

    private void setThinking(PaperSubject subject) {
        thinking = "i read " + subject.getPaper().title;
    }

    public String getThinking() {
        return thinking;
    }

}
