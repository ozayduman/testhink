package com.ozayduman.testhink.hard2testcode;

public class TaskV4 {

    private String title;

    /*
     * cost of construction sample
     *
     * doing work in constructor
     */
    public TaskV4(String title) {
        this.title = title;
        Util.longRunningJob();
    }

    public String getTitle() {
        return title;
    }
}
