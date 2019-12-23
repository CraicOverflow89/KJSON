package craicoverflow89.kjson

import org.junit.Assert
import org.junit.Test

class KJSONTest {

    @Test
    fun parseDouble() = with(KJSON.parseString("0.25")) {
        Assert.assertEquals(true, this.isDouble())
        Assert.assertEquals(0.25, this.toDouble(), 0.001)
    }

    @Test
    fun parseInteger() = with(KJSON.parseString("7")) {
        Assert.assertEquals(true, this.isInt())
        Assert.assertEquals(7, this.toInt())
    }

    @Test
    fun parseString() = with(KJSON.parseString("\"hello world\"")) {
        Assert.assertEquals(true, this.isString())
        Assert.assertEquals("hello world", this.toString())
    }

}