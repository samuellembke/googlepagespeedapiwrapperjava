package com.yoyaba.google.api.wrapper.pagespeed;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.jetbrains.annotations.Nullable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class GooglePagespeed {

    private OkHttpClient httpClient;

    private String API_URL;

    GooglePagespeed(long timeout, TimeUnit timeUnit, String API_URL) {
        httpClient = new OkHttpClient.Builder().connectTimeout(timeout, timeUnit).writeTimeout(timeout, timeUnit).readTimeout(timeout, timeUnit).build();
        this.API_URL = API_URL;
    }

    @Nullable
    public PagespeedResponse execute(PagespeedRequest request) throws IOException {

        String url = API_URL+"?url="+request.url+"&key="+request.key;

        Request httpRequest = new Request.Builder().url(url).build();

        try(Response response = httpClient.newCall(httpRequest).execute()) {
            if(response.isSuccessful()) {
                PagespeedResponse testResponse = parseHttpResponse(request, response);
                return testResponse;
            }
        }
        return null;
    }

    @Nullable
    private PagespeedResponse parseHttpResponse(PagespeedRequest request, Response response) throws IOException {
        PagespeedResponse pagespeedResponse = new PagespeedResponse();

        pagespeedResponse.response = response.body().string();
        return pagespeedResponse;
    }

    public static class Builder {

        private String api_url = "https://www.googleapis.com/pagespeedonline/v5/runPagespeed";

        private long timeout = 240;

        private TimeUnit timeUnit = TimeUnit.SECONDS;

        public Builder timeout(long timeout, TimeUnit timeUnit) {
            this.timeout = timeout;
            this.timeUnit = timeUnit;

            return this;
        }

        public Builder api(String url) {
            this.api_url = url;
            return this;
        }

        public GooglePagespeed build() {
            return new GooglePagespeed(this.timeout, this.timeUnit, this.api_url);
        }
    }


}
