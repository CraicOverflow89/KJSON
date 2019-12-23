package craicoverflow89.kjson

import org.junit.Assert
import org.junit.Test

class KJSONTest {

    @Test
    fun parseString() = with(KJSON.parseString("\"hello world\"")) {
        Assert.assertEquals(true, this.isString())
        Assert.assertEquals("hello world", this.toString())
    }

}