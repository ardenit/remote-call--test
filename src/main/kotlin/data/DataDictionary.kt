package data

class DataDictionary(private val dictionary: Map<String, Data>) : Data, Map<String, Data> by dictionary {

    constructor(vararg pairs: Pair<String, Data>) : this(mapOf(*pairs))

    fun getIntData(key: String): IntData = this[key] as IntData
    fun getDoubleData(key: String): DoubleData = this[key] as DoubleData
    fun getStringData(key: String): StringData = this[key] as StringData

    fun getRemoteFunction(key: String): RemoteFunction = this[key] as RemoteFunction

    fun getInt(key: String): Int = getIntData(key).value
    fun getDouble(key: String): Double = getDoubleData(key).value
    fun getString(key: String): String = getStringData(key).value

    fun getDataList(key: String): DataList = this[key] as DataList

    fun getDictionary(key: String): DataDictionary = this[key] as DataDictionary

}

// Можем сделать классы IntDataDictionary, DoubleDataDictionary, etc.