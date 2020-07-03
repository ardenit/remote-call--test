package data

data class RemoteFunction(internal val host: String, internal val port: Int) : Data, (Data) -> Data {

    override fun invoke(arg: Data): Data {
        // Здесь будет запрос к удаленному серверу
        return DoubleData(1.0)
    }

}