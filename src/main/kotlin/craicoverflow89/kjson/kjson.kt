package craicoverflow89.kjson

import craicoverflow89.kjson.parser.KJSONLexer
import craicoverflow89.kjson.parser.KJSONParser
import java.io.File
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream

class KJSON(private val data: KJSONData) {

    companion object {

        private fun parse(value: String): KJSON {
            val lexer = KJSONLexer(ANTLRInputStream(value))
            val parser = KJSONParser(CommonTokenStream(lexer))
            return parser.json().result
        }

        fun parseFile(file: File) = parse(file.readText())
        fun parseFile(file: String) = parse(File(file).readText())
        fun parseString(value: String) = parse(value)

    }

    fun isArray() = data is KJSONArray

    fun isDouble() = data is KJSONDouble

    fun isInt() = data is KJSONInteger

    fun isMap() = data is KJSONMap

    fun isString() = data is KJSONString

    fun toArrayList() = (data as KJSONArray).toArrayList()

    fun toDouble() = (data as KJSONDouble).toDouble()

    fun toHashMap() = (data as KJSONMap).toHashMap()

    fun toInt() = (data as KJSONInteger).toInt()

    fun toList() = (data as KJSONArray).toList()

    fun toMap() = (data as KJSONMap).toMap()

    override fun toString() = (data as KJSONString).toString()

}

interface KJSONData

class KJSONArray(private val data: ArrayList<KJSONData>): KJSONData {

    fun toArrayList() = data

    fun toList() = data.toList()

}

class KJSONDouble(private val data: Double): KJSONData {

    fun toDouble() = data.toDouble()

}

class KJSONInteger(private val data: Int): KJSONData {

    fun toInt() = data.toInt()

}

class KJSONMap(private var data: List<KJSONMapPair>): KJSONData {

    fun toHashMap() = HashMap<String, Any>().apply {
        data.forEach {
            put(it.key, it.value)
        }
    }

    fun toMap() = toHashMap().toMap()

}

class KJSONMapPair(val key: String, val value: KJSONData)

class KJSONString(private val data: String): KJSONData {

    override fun toString() = data

}