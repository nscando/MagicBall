// Aswer values
const val RESPUESTA_AFIRMATIVA = "✅"
const val RESPUESTA_NEGATIVA = "❌"
const val RESPUESTA_DUDOSA = "\uD83E\uDD14"

//Join answers with values
val respuestas = mapOf(
    "Sí" to RESPUESTA_AFIRMATIVA,
    "Es cierto" to RESPUESTA_AFIRMATIVA,
    "Totalmente" to RESPUESTA_AFIRMATIVA,
    "Sin duda" to RESPUESTA_AFIRMATIVA,
    "Pregunta en otro momento" to RESPUESTA_DUDOSA,
    "No puedo decirte en este momento" to RESPUESTA_DUDOSA,
    "Puede que si o puede que no" to RESPUESTA_DUDOSA,
    "No va a suceder" to RESPUESTA_NEGATIVA,
    "No cuentes con ello" to RESPUESTA_NEGATIVA,
    "Definitivamente no" to RESPUESTA_NEGATIVA,
    "No lo creo" to RESPUESTA_NEGATIVA,
)

fun main(args: Array<String>) {

    while (true) {

        println("Hola soy tu Bola 8 Magica, creada en Kotlin. ¿Cual de estas opciones deseas realizar?")
        println("1. Realizar una Pregunta")
        println("2. Revisar todas la respuestas")
        println("3. Salir")

        val valorIngresado = readLine()

        when (valorIngresado) {
            "1" -> realizarPregunta()
            "2" -> mostrarRespuestas()
            "3" -> {
                salir()
                break
            }
            else -> mostrarError()
        }
        println()
    }

}

fun mostrarError() {
    println("Vaya, parece que elegiste una opcion no valida, intenta de nuevo.")
}

fun salir() {
    println("Hasta luego!")
}

fun mostrarRespuestas() {
    println("Selecciona una opcoion: ")
    println("1. Revisar todas las respuestas")
    println("2. Revisar solo las respuestas Afirmativas")
    println("3. Revisar solo las respuestas Dudosas")
    println("4. Revisar solo las respuestas Negativas")

    val opcioneIngresada = readLine()

    when (opcioneIngresada) {
        "1" -> mostrarRespuestasPorTipo()
        "2" -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_AFIRMATIVA)
        "3" -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_DUDOSA)
        "4" -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_NEGATIVA)
        else -> println("Respuesta no valida. Adios.")
    }

}

fun mostrarRespuestasPorTipo(tipoDeRespuesta: String = "TODOS") {

    val lambdaImprimirRespuesta: (Collection<String>) -> Unit = { lista ->
        println(lista)
    }

    when (tipoDeRespuesta) {
        "TODOS" -> respuestas.keys.forEach { respuesta -> println(respuestas) }

        RESPUESTA_AFIRMATIVA,

        RESPUESTA_NEGATIVA,

        RESPUESTA_DUDOSA -> respuestas.filterValues { values -> values == tipoDeRespuesta }
            .also { listaDeRespuestas -> lambdaImprimirRespuesta(listaDeRespuestas.keys) }
    }


}


fun realizarPregunta() {
    println("Que pregunta deseas realizar?")
    readLine()
    println("Asi que esa era tu pregunta... la respuesta a eso es: ")
    val respuestaGenerada = respuestas.keys.random()
    println(respuestaGenerada)
}
