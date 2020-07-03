package data

data class DataList(private val value: List<Data>) : Data, List<Data> by value {

    constructor(vararg values: Data) : this(values.toList())
}

// Можем сделать классы IntDataList, DoubleDataList, etc.