Compare bean generation tools
-----------------------------

Repository used to compare various bean generation tools.
Relates to a [talk](https://m.devoxx.com/events/dvbe25/talks/24578/jodabeans-pojo-code-generation-and-beyond) at Devoxx Belgium 2025,
however it is generally useful for comparing generation tool.

A _bean_ is intended to be a data object with getters, `equals`, `hashCode` and `toString` generated,
see the original [JavaBean](http://blog.joda.org/2014/11/the-javabeans-specification.html) specification.
A _mutable bean_ has setters to allow the data to be mutated.
However, most of the projects here generate _immutable beans_, which have builders and/or withers instead of setters.

This project compares the following projects:

* [AutoValue](https://github.com/google/auto/tree/master/value)
* [Immutables](http://immutables.org)
* [Joda-Beans](http://www.joda.org/joda-beans/)
* [Lombok](https://projectlombok.org/)
* [RecordBuilder](https://github.com/Randgalt/record-builder)
* One-off IDE generation by Eclipse and IntelliJ

See also the [awesome list](https://github.com/gunnarmorling/awesome-annotation-processing) of annotation processors.

Installing
----------

To install this project in IntelliJ and get it to compile, you need:

* The Lombok Maven plugins
* "Annotation Processors" set to "Enable annotation processing"

To install this project in Eclipse and get it to compile, you need:

* The M2E and Lombok Maven plugins
* "Maven/Annotation Processing" set to "Automatically configure"


Pull requests
-------------

Feel free to raise a Pull Request for mistakes, enhancements of other bean-generation tools.
