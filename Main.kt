fun main() {
    val interfaceConsola = InterfaceConsola()
    val sieteYmedia = SieteYmedia()

    val cartasJugador = sieteYmedia.cartasJugador
    val cartasBanca = sieteYmedia.cartasBanca

    interfaceConsola.presentarJuego()
    interfaceConsola.mensajeMinimoCartas()




    var opc = 'C'

    while (opc == 'C') {

        interfaceConsola.mensajeTurnoJugador()

        sieteYmedia.darCartaJugador()
        val valorCartasJugador = sieteYmedia.valorCartas(cartasJugador)

        interfaceConsola.mostrarCartas("jugador", cartasJugador)
        interfaceConsola.mostrarValorCartas("jugador", valorCartasJugador)

        if (sieteYmedia.valorCartas(cartasJugador) >= 7.5) break

        opc = interfaceConsola.preguntarDecision()
    }

    while (sieteYmedia.valorCartas(cartasBanca) < 7 && sieteYmedia.valorCartas(cartasBanca) <= sieteYmedia.valorCartas(cartasJugador)) {

        if (sieteYmedia.valorCartas(cartasJugador) > 7.5) {
            interfaceConsola.mensajePerdedorJugador()
            break
        } else if (sieteYmedia.valorCartas(cartasJugador) == 7.5) {
            interfaceConsola.mensajeGanadorJugador()
            break
        }

        interfaceConsola.mensajeTurnoBanca()

        sieteYmedia.darCartaBanca()
        val valorCartasBanca = sieteYmedia.valorCartas(cartasBanca)

        interfaceConsola.mostrarCartas("banca", cartasBanca)
        interfaceConsola.mostrarValorCartas("banca", valorCartasBanca)

        if (sieteYmedia.valorCartas(cartasBanca) > 7.5) {
            interfaceConsola.mensajePierdeBanca()
            break
        } else if (sieteYmedia.valorCartas(cartasBanca) == 7.5) {
            interfaceConsola.mensajeGanadorBanca()
            break
        }

        when{
            sieteYmedia.decidirGanador() == "jugador" -> interfaceConsola.mensajeGanadorJugador()
            sieteYmedia.decidirGanador() == "banca" -> interfaceConsola.mensajeGanadorBanca()
            sieteYmedia.decidirGanador() == "empate" -> interfaceConsola.mensajeEmpate()
        }
        break
    }
}

