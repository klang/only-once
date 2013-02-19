# only-once

A small insecure web service that let you drop a value for later consumption, once.

The key to collect the value on, is selected by the user.

"insecure" because the server is not set up with https to receive the key/value pairs .. and because the server has no way of knowing if the request for the value originates from the intended recipient.

But, it is a proof of concept and it didn't take me long to make (including the time to set up redis, that I ended up NOT using in the final version)

In this version, the server hold the key/value pair in memory until it is collected. The pair will be shown in the browser, once. 

I believe that the service could be set up on heruko [heroku.com] in a few hours. (time mostly spend bending my current development machine [IBM X40 from 2004 running OpenSuse12.1] to play nice with heruko)

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
