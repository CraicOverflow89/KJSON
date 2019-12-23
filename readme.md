KJSON Project
=============

Lightweight JSON parsing library for Kotlin.

### Usage

You can parse JSON files and strings easily with the `parseFile` and `parseString` methods;

```
KJSON.parseFile("/path/to/file.json")
// returns a KJSON object (can pass File object instead)

KJSON.parseString("{name:\"James\"}").toMap()
// returns a Map object
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

| Method      | Returns                |
| ----------- | ---------------------- |
| toArrayList | ArrayList<KJSON>       |
| toDouble    | double                 |
| toInt       | int                    |
| toList      | List<KJSON>            |
| toMap       | HashMap<String, KJSON> |
| toString    | String                 |