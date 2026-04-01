import recursos.Baraja
import recursos.Carta

class SieteYmedia{

    val baraja = Baraja()
    val cartasJugador = mutableListOf<Carta>()
    val cartasBanca = mutableListOf<Carta>()

    init {
        baraja.barajar()
    }

    fun valorCartas(cartas: List<Carta>): Double =
        cartas.sumOf {
            if (it.numero > 7) 0.5 else it.numero.toDouble()
        }

    fun darCartaJugador(){
        val carta = baraja.darCartas(1).first()
        cartasJugador.add(carta)
    }

    fun darCartaBanca(){
        val carta = baraja.darCartas(1).first()
        cartasBanca.add(carta)
    }

    fun decidirGanador(): String{
        val valorJugador = valorCartas(cartasJugador)
        val valorBanca = valorCartas(cartasBanca)
        return when{
            valorJugador > valorBanca -> "jugador"
            valorBanca > valorJugador -> "banca"
            valorBanca > 7.5 -> "jugador"
            valorJugador > 7.5 -> "banca"
            else -> "empate"
        }
    }
}
