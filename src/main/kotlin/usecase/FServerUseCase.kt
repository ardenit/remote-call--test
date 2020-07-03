package usecase

import data.DoubleData
import library.startFServer

//Создаём функциональный сервер, представляющий функцию f(x) = x^2

fun main() {
    startFServer(port = 32228) { arg ->
        // Получили объект Data. Знаем, что это на самом деле DoubleData.
        val x = (arg as DoubleData).value
        DoubleData(x * x)
    }
}