# Pagespeed API Wrapper JAVA

## Installation

### Using Maven

Add the following to your pom.xml:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
Then add the following to your dependencies:
```xml
<dependency>
    <groupId>com.github.samuellembke</groupId>
    <artifactId>googlepagespeedapiwrapperjava</artifactId>
    <version>1.3.4-RELEASE</version>
</dependency>
```

## Quickstart
You need to create a GooglePagespeed Instance:
```java
GooglePagespeed pagespeed = new GooglePagespeed.Builder().build();

```
You can specify the network timeout for the API request and a custom api server url
```java
GooglePagespeed pagespeed = new GooglePagespeed.Builder()
    .timeout(120, TimeUnit.SECONDS)
    .api("https://api.example.com")
    .build();
```

### PagespeedRequest
You now need to create a PagespeedRequest
```java
PagespeedRequest request = new PagespeedRequest.Builder()
    .key("API-KEY")
    .url("https://example.page.to.test.com")
    .build();
```
### Executing
Now you can execute the request and retrieve a PagespeedResponse
```java
PagespeedResponse response = pagespeed.execute(request);
```

### Retrieving JSON Response
Retrieve the JSON response as string and parse it to JSON using org.json, or the json library of your choice
```java
JSONObject jsonObject = new JSONObject(response.getResponse());
```