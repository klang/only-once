# only-once

A small web service that let you drop a value for later consumption, once.

The key to collect the value on, is selected by the user.

## Usage


```bash 
lein uberjar
java -jar target/only-once-0.1.0-SNAPSHOT-standalone.jar
```

or simply

```bash 
java -jar target/only-once-0.1.0-SNAPSHOT-standalone.jar
```

To drop a value:

`http://localhost:8080`

or

`http://localhost:8080/drop?key=foo&value=barf`

To collect the value again, once:

`http://localhost:8080/foo`

## License

Copyright © 2013 Karsten Lang

Distributed under the Eclipse Public License, the same as Clojure.
