package com.yoyaba.google.api.wrapper.pagespeed;

import java.io.Serializable;

public class PagespeedResponse implements Serializable {

    protected String response;

    protected PagespeedResponse() { }

    /**
     * Returns Google Pagespeed response in json (String format)
     * @return Google Pagespeed response in json (String format)
     */
    public String getResponse() {
        return response;
    }
}
