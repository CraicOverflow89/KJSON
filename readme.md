KJSON Project
=============

Lightweight JSON parsing library for Kotlin.

### Usage

You can parse JSON files and strings easily with the `parseFile` and `parseString` methods;

```
KJSON.parseFile(File("/path/to/file.json"))
// returns a KJSON object represeting content in file.json

KJSON.parseString("{name:\"James\"}").toMap()
// returns a Map object, cast from a KJSON object
```

### Methods

After parsing JSON data, you can perform checks on data type of the `KJSON` object with these methods;

| Method   | Returns |
| -------- | ------- |
| isArray  | boolean |
| isDouble | boolean |
| isInt    | boolean |
| isMap    | boolean |
| isString | boolean |

You can cast the data of the `KJSON` object with the following methods;

| Method      | Returns                                                             |
| ----------- | ------------------------------------------------------------------- |
| toArrayList | ArrayList&lt;T&gt; when types are primitive; ArrayList&lt;KJSON&gt; |
| toDouble    | double                                                              |
| toHashMap   | HashMap<String, T> when types are primitive; HashMap<String, KJSON> |
| toInt       | int                                                                 |
| toList      | List&lt;T&gt; when types are primitive; List&lt;KJSON&gt;           |
| toMap       | Map<String, T> when types are primitive; Map<String, KJSON>         |
| toString    | String                                                              |