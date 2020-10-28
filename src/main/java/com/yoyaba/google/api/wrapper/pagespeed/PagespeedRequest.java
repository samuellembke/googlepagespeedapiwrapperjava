package com.yoyaba.google.api.wrapper.pagespeed;


import com.yoyaba.google.api.wrapper.pagespeed.exceptions.GooglePagespeedException;
import com.yoyaba.google.api.wrapper.pagespeed.exceptions.GooglePagespeedURLNotSpecifiedException;
import com.yoyaba.google.api.wrapper.pagespeed.exceptions.GooglePagespeedAPIKeyNotSpecifiedException;

public final class PagespeedRequest {

    protected String url;

    protected String key;

    PagespeedRequest() { }

    PagespeedRequest(String url, String key) {
        this.url = url;
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public String getKey() {
        return key;
    }

    public static class Builder {
        private PagespeedRequest request;

        public Builder() {
            this.request = new PagespeedRequest();
        }

        public Builder url(String url) {
            this.request.url = url;
            return this;
        }

        public Builder key(String key) {
            this.request.key = key;
            return this;
        }

        public PagespeedRequest build() throws GooglePagespeedException {
            if(this.request.url == null) {
                throw new GooglePagespeedURLNotSpecifiedException();
            }
            if(this.request.key == null) {
                throw new GooglePagespeedAPIKeyNotSpecifiedException();
            }
            return this.request;
        }
    }
}
