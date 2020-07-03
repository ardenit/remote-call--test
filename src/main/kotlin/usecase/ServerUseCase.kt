package usecase

import data.*
import library.startFServer

// Запускаем основной сервер (исполнитель). Его тоже можно представить как функциональный сервер.
// Исполнитель принимает числа a, b и функцию f и ищет интеграл f от a до b самым тривиальным способом.

fun main() {
    startFServer(port = 3228) { data ->
        // Получили объект типа Data. Знаем, что это на самом деле DataDictionary.
        val args = data as DataDictionary
        val a: Double = args.getDouble("a")
        val b: Double = args.getDouble("b")
        val remoteFunction: (Data) -> Data = args.getRemoteFunction("f")
        // Преобразуем функцию (Data) -> Data (знаем, что оба типа - DoubleData) в функцию (Double) -> Double
        val unpackedF: (Double) -> Double = { x ->
            (remoteFunction(DoubleData(x)) as DoubleData).value
        }
        // Запускаем функцию из библиотеки, получаем интеграл, упаковываем его в DoubleData и отправляем
        DoubleData(integrate(a, b, unpackedF))
    }
}


// Представим, что это функция из какой-нибудь библиотеки. Её мы и хотим использовать удалённо.
fun integrate(a: Double, b: Double, f: (Double) -> Double): Double {
    var answer = 0.0
    val steps = 100
    val stepLength = (b - a) / steps.toDouble()
    repeat(steps) { i ->
        val left = a + stepLength * i
        val right = a + stepLength * (i + 1)
        val funcLeft: Double = f(left)
        val funcRight: Double = f(right)
        val funcAverage = (funcLeft + funcRight) / 2.0
        answer += funcAverage * stepLength
    }
    return answer
}