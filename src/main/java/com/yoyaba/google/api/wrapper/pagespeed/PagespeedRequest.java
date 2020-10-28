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

    /**
     * PagespeedRequest Builder.
     * Build a new PagespeedRequest Object.
     */
    public static class Builder {
        private PagespeedRequest request;

        public Builder() {
            this.request = new PagespeedRequest();
        }

        /**
         * Set url to perform the pagespeed test on.
         * @param url URL to perform the pagespeed test on.
         * @return Builder
         */
        public Builder url(String url) {
            this.request.url = url;
            return this;
        }

        /**
         * Set google api key.
         * @param key Google API key.
         * @return Builder
         */
        public Builder key(String key) {
            this.request.key = key;
            return this;
        }

        /**
         * Build a new PagespeedRequest
         * @return PagespeedRequest
         * @throws GooglePagespeedException
         */
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
