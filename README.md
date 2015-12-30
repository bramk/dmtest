# DM3/4 ServiceFactory test

It seems that DM4 no longer calls #ungetService() for instances before invoking #stop() on a ServiceFactory component :?

```
$ ./gradlew build
---------- Running DM3 test ----------------------
Hello dm3
---------- Running DM4 test ----------------------
Hello DM4
ERROR: [main] Invocation of 'stop' failed. (java.lang.IllegalStateException: All services should be closed)
java.lang.IllegalStateException: All services should be closed
	at servicefactory.api.HelloWorldServiceFactory.stop(HelloWorldServiceFactory.java:17)
...
```