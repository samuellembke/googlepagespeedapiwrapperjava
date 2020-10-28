# Google Pagespeed API Java Wrapper

##### This is a java wrapper for the google pagespeed api


* GooglePagespeed Object
    * Builder
        * You can specify a custom api key and network timeout.
* PagespeedRequest Object
    * Builder
        * You can specify the api key for the specific request, and the url to run the pagespeed test on
* PagespeedResponse Object
    * getResponse > String json response from google API Server
>


* For response documentation click [here](https://developers.google.com/speed/docs/insights/v5/reference/pagespeedapi/runpagespeed#response)
###### Installing with maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.samuellembke</groupId>
        <artifactId>googlepagespeedapiwrapperjava</artifactId>
        <version>a01d5109b0d23531f7934ec6f05a5493d4677b36</version>
    </dependency>
</dependencies>
```

###### Usage
```java
GooglePagespeed pagespeed = new GooglePagespeed.Builder().build();

PagespeedRequest request = new PagespeedRequest.Builder()
                        .key("API-KEY")
                        .url("https://example.com").build();

PagespeedResponse response = pagespeed.execute(request);

JSONObject jsonObject = new JSONObject(response.getResponse());

```