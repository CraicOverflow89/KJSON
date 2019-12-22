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

### Methods

After parsing JSON data, you can perform checks on data type of the `KJSON` object with these methods;

 - **isArray**
 - **isDouble**
 - **isInt**
 - **isMap**
 - **isString**

You can cast the data of the `KJSON` object with the following methods;

 - **toArrayList** returns `ArrayList<KJSON>`
 - **toDouble** returns `double`
 - **toInt** returns `int`
 - **toList** returns `List<KJSON>`
 - **toMap** returns `HashMap<String, KJSON>`
 - **toString** returns `String`