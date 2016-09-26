Compare bean generation tools
-----------------------------

Repository used to compare various bean generation tools.
Relates to talk
[CON8257](https://oracle.rainfocus.com/scripts/catalog/oow16.jsp?event=javaone&search=getter&search.event=javaone) at JavaOne 2016, however it is generally useful for comparing generation tool.

A _bean_ is intended to be a data object with getters, `equals`, `hashCode` and `toString` generated, see the original [JavaBean](http://blog.joda.org/2014/11/the-javabeans-specification.html) specification.
A _mutable bean_ has setters to allow the data to be mutated.
However, most of the projects here generate _immutable beans_, which have builders and/or withers instead of setters.
In Java 8, I personally recommend develpopers to start moving to immutable data objects throughout their system.

This project compares the following projects:

* [AutoValue](https://github.com/google/auto/tree/master/value)
* [Immutables](http://immutables.org)
* [Joda-Beans](http://www.joda.org/joda-beans/)
* [Lombok](https://projectlombok.org/)
* [POJOmatic](http://www.pojomatic.org/)
* [VALJOGen](http://valjogen.41concepts.com/)
* One-off IDE generation by Eclipse and IntelliJ

Many other code generation tools exist for Java. This list is not exhaustive:

* [Derive4J](https://github.com/derive4j/derive4j) - algebraic data types


Installing
----------

To install this project in Eclipse and get it to compile, you need:

* The M2E Maven plugin
* The M2E APT plugin ([update site]( http://download.jboss.org/jbosstools/updates/m2e-extensions/m2e-apt))
* Go to preferences and change "Maven/Annotation Processing" to "Automatically configure"
* Refresh the project using right-click "Maven/Update project"


Pull requests
-------------

Feel free to raise a Pull Request if there is another bean-generation project that I have missed.


