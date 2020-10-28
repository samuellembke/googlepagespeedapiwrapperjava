package com.yoyaba.google.api.wrapper.pagespeed;

import java.io.Serializable;

public class PagespeedResponse implements Serializable {

    protected String response;

    protected PagespeedResponse() { }

    public String getResponse() {
        return response;
    }
}
