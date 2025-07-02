package PrimeiroDesafio

/*Crie um programa em Kotlin que funcione como uma calculadora com as quatro operações básicas (+, -, *, /),
utilizando funções e tratamento de exceções.
O programa deve:
Ler dois números do usuário, validando entradas inválidas.
Ler o operador, aceitando apenas "+", "-", "*" ou "/".
Realizar a operação com base nos valores e no operador.
Tratar exceções como NumberFormatException e ArithmeticException (como divisão por zero).
Exibir o resultado ou mensagens de erro adequadas, finalizando com uma mensagem de encerramento.*/

fun lerNumero(mensagem: String): Double {
    while (true) {
        println(mensagem)
        val input = readLine()
        try {
            return input!!.toDouble()
        } catch (e: NumberFormatException) {
            println("Erro: Valor inválido. Tente novamente.")
        }
    }
}

fun lerOperador(): String {
    while (true) {
        println("Informe o operador (+, -, *, /):")
        val op = readLine()
        if (op != null && op in listOf("+", "-", "*", "/")) {
            return op
        } else {
            println("Operador inválido. Tente novamente.")
        }
    }
}


fun calculadora(n1: Double, n2: Double, op: String): Double {
    return when (op) {
        "+" -> n1 + n2
        "-" -> n1 - n2
        "*" -> n1 * n2
        "/" -> {
            if (n2 == 0.0) throw ArithmeticException("Divisão por zero")
            n1 / n2
        }
        else -> throw IllegalArgumentException("Operador inválido")
    }
}

fun main() {
    val num1 = lerNumero("Informe o primeiro número:")
    val num2 = lerNumero("Informe o segundo número:")
    val operador = lerOperador()

    try {
        val resultado = calculadora(num1, num2, operador)
        println("Resultado: $resultado")
    } catch (e: ArithmeticException) {
        println("Erro: ${e.message}")
    } catch (e: Exception) {
        println("Erro inesperado: ${e.message}")
    } finally {
        println("Fim da execução.")
    }
}
