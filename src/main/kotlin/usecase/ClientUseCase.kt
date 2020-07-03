package usecase

import data.*

fun main() {
    // Ссылка на сервер с функцией - интегрированием
    val serverFunc = RemoteFunction(host = "localhost", port = 3228)
    // Ссылка на сервер с функцией, которую мы интегрируем
    val fServerFunc = RemoteFunction(host = "localhost", port = 32228)
    // Упаковываем аргументы в словарь
    val arg = DataDictionary("a" to DoubleData(0.0), "b" to DoubleData(1.0), "f" to fServerFunc)
    // Вызываем удаленную функцию
    val result: Data = serverFunc(arg)
    // Знаем, что эта функция на самом деле вернула DoubleData
    val unpackedResult: Double = (result as DoubleData).value
    println(unpackedResult)
}