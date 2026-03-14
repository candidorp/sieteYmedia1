import recursos.Baraja
import recursos.Carta

class GameController {

    private val baraja = Baraja()
    private val cartasJugador = mutableListOf<Carta>()
    private val cartasBanca = mutableListOf<Carta>()


    init {
        baraja.barajar()
        presentarJuego()
        jugar()
    }

    fun presentarJuego() {
        println("- El usuario es el jugador y el ordenador la banca.")
        println("- No hay en la baraja 8s y 9s. El 10 es la sota, el 11 el caballo y el 12 el Rey.")
        println("- Las figuras valen medio punto y el resto su valor.")
        println("- Primero juega el jugador.")
        println("- El jugador puede pedir cartas o plantarse.")
        println("- Si supera 7.5 pierde.")
        println("- Luego juega la banca, que debe empatar o superar al jugador sin pasarse.")
        println("\nEmpecemos!!!\n")
    }

    fun jugar() {
        turnoJugador()
        turnoBanca()
        println("Adios")
    }

    fun turnoJugador() {
        var opc = 'C'

        println("Como mínimo recibes una carta")

        while (valorCartas(cartasJugador) < 7.5 && opc == 'C') {

            val carta = baraja.darCartas(1).first()
            cartasJugador.add(carta)

            println("Éstas son tus cartas jugador:")
            mostrarCartas(cartasJugador)

            val valor = valorCartas(cartasJugador)
            println("\n\tValor de cartas: $valor")

            if (valor < 7.5) {
                println("\n¿Pides [C]arta o te [P]lantas?")
                opc = readln().trim().uppercase()[0]
            }
        }
    }

    fun turnoBanca() {

        val valorJugador = valorCartas(cartasJugador)

        if (valorJugador > 7.5) {
            println("Jugador, te has pasado, gana la banca")
            return
        }

        println("\nTurno de banca ...")

        while (valorCartas(cartasBanca) < valorJugador) {
            val carta = baraja.darCartas(1).first()
            cartasBanca.add(carta)
        }

        println("Éstas son mis cartas:")
        mostrarCartas(cartasBanca)

        val valor = valorCartas(cartasBanca)
        println("\nValor de mis cartas: $valor")

        if (valor > 7.5)
            println("Me pasé, ganas tú jugador")
        else
            println("Gana la banca")
    }

    fun valorCartas(cartas: List<Carta>): Double =
        cartas.sumOf {
            if (it.numero > 7) 0.5 else it.numero.toDouble()
        }

    fun mostrarCartas(cartas: List<Carta>) {
        cartas.forEach { print("\t$it") }
        println()
    }
}
