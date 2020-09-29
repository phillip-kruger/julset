# JUL Agent

Allows setting log levels using an Agent.

## Usage

Change logger for all classes in package `com.github.phillipkruger.myapp` to `FINEST`:

```
java -javaagent:target/julset-1.0.0-SNAPSHOT.jar -Djul.com.github.phillipkruger.myapp=FINEST -jar target/julset-test-1.0.0-SNAPSHOT.jar
```

Change only class `com.github.phillipkruger.myapp.MyApplication` to `FINEST`:

```
java -javaagent:target/julset-1.0.0-SNAPSHOT.jar -Djul.com.github.phillipkruger.myapp.MyApplication=FINEST -jar target/julset-test-1.0.0-SNAPSHOT.jar
```