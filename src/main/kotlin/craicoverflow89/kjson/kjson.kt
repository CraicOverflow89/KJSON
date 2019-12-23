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

    fun toArrayList(): ArrayList<Any> = ArrayList<Any>().apply {
        (data as KJSONArray).toArrayList().forEach {
            add(when(it) {
                is KJSONDouble -> it.toDouble()
                is KJSONInteger -> it.toInt()
                is KJSONString -> it.toString()
                else -> it
            })
        }
    }

    fun toDouble() = (data as KJSONDouble).toDouble()

    fun toHashMap(): HashMap<String, Any> = HashMap<String, Any>().apply {
        (data as KJSONMap).toHashMap().forEach {k, v ->
            put(k, when(v) {
                is KJSONDouble -> v.toDouble()
                is KJSONInteger -> v.toInt()
                is KJSONString -> v.toString()
                else -> v
            })
        }
    }

    fun toInt() = (data as KJSONInteger).toInt()

    fun toList(): List<Any> = ArrayList<Any>().apply {
        (data as KJSONArray).toList().forEach {
            add(when(it) {
                is KJSONDouble -> it.toDouble()
                is KJSONInteger -> it.toInt()
                is KJSONString -> it.toString()
                else -> it
            })
        }
    }.toList()

    fun toMap(): Map<String, Any> = HashMap<String, Any>().apply {
        (data as KJSONMap).toHashMap().forEach {k, v ->
            put(k, when(v) {
                is KJSONDouble -> v.toDouble()
                is KJSONInteger -> v.toInt()
                is KJSONString -> v.toString()
                else -> v
            })
        }
    }.toMap()

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