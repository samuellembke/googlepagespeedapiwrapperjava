# Google Pagespeed API Java Wrapper

##### This is a java wrapper for the google pagespeed api

```java
GooglePagespeed pagespeed = new GooglePagespeed.Builder().build();

PagespeedRequest request = new PagespeedRequest.Builder()
                        .key("API-KEY")
                        .url("https://example.com").build();

PagespeedResponse response = pagespeed.execute(request);

JSONObject jsonObject = new JSONObject(response.getResponse());

```