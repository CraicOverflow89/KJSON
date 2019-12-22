KJSON Project
=============

Lightweight JSON parsing library for Kotlin.

### Usage

You can parse JSON files and strings easily with the `parseFile` and `parseString` methods;

```
KJSON.parseFile("/path/to/file.json")
// returns a KJSON object (can pass File object instead)

KJSON.parseString("{name:\"James\"}").toMap()
// returns a HashMap object
```  