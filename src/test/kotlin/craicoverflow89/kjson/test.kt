package craicoverflow89.kjson

import org.junit.Assert
import org.junit.Test

class KJSONTest {

    @Test
    fun parseArrayToArrayList() = with(KJSON.parseString("[7, 8, 9]")) {
        Assert.assertEquals(true, this.isArray())
        Assert.assertEquals(arrayListOf(7, 8, 9), this.toArrayList())
    }

    @Test
    fun parseArrayToList() = with(KJSON.parseString("[7, 8, 9]")) {
        Assert.assertEquals(true, this.isArray())
        Assert.assertEquals(listOf(7, 8, 9), this.toList())
    }

    @Test
    fun parseDoubleSigned() = with(KJSON.parseString("-0.25")) {
        Assert.assertEquals(true, this.isDouble())
        Assert.assertEquals(-0.25, this.toDouble(), 0.001)
    }

    @Test
    fun parseDoubleUnsigned() = with(KJSON.parseString("0.25")) {
        Assert.assertEquals(true, this.isDouble())
        Assert.assertEquals(0.25, this.toDouble(), 0.001)
    }

    @Test
    fun parseIntegerSigned() = with(KJSON.parseString("-7")) {
        Assert.assertEquals(true, this.isInt())
        Assert.assertEquals(-7, this.toInt())
    }

    @Test
    fun parseIntegerUnsigned() = with(KJSON.parseString("7")) {
        Assert.assertEquals(true, this.isInt())
        Assert.assertEquals(7, this.toInt())
    }

    @Test
    fun parseMapToHashMap() = with(KJSON.parseString("{\"name\":\"James\"}")) {
        Assert.assertEquals(true, this.isMap())
        val expected = hashMapOf(Pair("name", "James"))
        val actual = this.toHashMap()
        Assert.assertEquals(expected.keys.size, actual.keys.size)
        Assert.assertEquals(expected["name"], actual["name"])
    }

    @Test
    fun parseMapToMap() = with(KJSON.parseString("{\"name\":\"James\"}")) {
        Assert.assertEquals(true, this.isMap())
        val expected = mapOf(Pair("name", "James"))
        val actual = this.toMap()
        Assert.assertEquals(expected.keys.size, actual.keys.size)
        Assert.assertEquals(expected["name"], actual["name"])
    }

    @Test
    fun parseString() = with(KJSON.parseString("\"hello world\"")) {
        Assert.assertEquals(true, this.isString())
        Assert.assertEquals("hello world", this.toString())
    }

}