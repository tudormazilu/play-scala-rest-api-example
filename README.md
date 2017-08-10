# play-scala-rest-api-example

This is the example project for [Making a REST API in Play](http://developer.lightbend.com/guides/play-rest-api/index.html).

## Appendix

### Running

You need to download and install sbt for this application to run.

Once you have sbt installed, the following at the command prompt will start up Play in development mode:

```
sbt run
```

Play will start up on the HTTP port at http://localhost:9000/.   You don't need to deploy or reload anything -- changing any source code while the server is running will automatically recompile and hot-reload the application on the next HTTP request. 

### Usage

If you call the same URL from the command line, you’ll see JSON. Using httpie, we can execute the command:

```
http --verbose http://localhost:9000/222
```

and get back:

```
GET /v1/posts HTTP/1.1
```

### Testing

In order to run unit and functional tests

```
sbt test
```

### Eclipse

In order to generate artifacts for Eclipse Scala IDE using sbteclipse:

```
sbt eclipse
```

