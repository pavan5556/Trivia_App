package com.pavan.triviaapp.source.model;

import java.util.List;

public class Options {

    List<String> options;
    boolean ismultiselect;

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public boolean isIsmultiselect() {
        return ismultiselect;
    }

    public void setIsmultiselect(boolean ismultiselect) {
        this.ismultiselect = ismultiselect;
    }
}
