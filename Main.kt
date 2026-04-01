fun main() {
    val interfaceConsola = InterfaceConsola()
    val sieteYmedia = SieteYmedia()

    interfaceConsola.sieteYmedia = sieteYmedia

    val cartasJugador = sieteYmedia.cartasJugador
    val cartasBanca = sieteYmedia.cartasBanca

    interfaceConsola.presentarJuego()
    interfaceConsola.mensajeMinimoCartas()



    var game = true

    while (game == true){
        var opc = 'C'
        while(opc == 'C'){

            interfaceConsola.mensajeTurnoJugador()

            sieteYmedia.darCartaJugador()

            interfaceConsola.mostrarCartas("jugador", cartasJugador)
            interfaceConsola.mostrarValorCartas("jugador", cartasJugador)

            if(sieteYmedia.valorCartas(cartasJugador) >= 7.5) break

            opc = interfaceConsola.preguntarDecision()
        }

        while(sieteYmedia.valorCartas(cartasBanca) < 7 && sieteYmedia.valorCartas(cartasBanca) <= sieteYmedia.valorCartas(cartasJugador)){

            if(sieteYmedia.valorCartas(cartasJugador) > 7.5){
                interfaceConsola.mensajePerdedorJugador()
                game = false
                break
            }else if(sieteYmedia.valorCartas(cartasJugador) == 7.5){
                interfaceConsola.mensajeGanadorJugador()
                game = false
                break
            }

            interfaceConsola.mensajeTurnoBanca()

            sieteYmedia.darCartaBanca()

            interfaceConsola.mostrarCartas("banca", cartasBanca)
            interfaceConsola.mostrarValorCartas("banca", cartasBanca)

            if(sieteYmedia.valorCartas(cartasBanca) > 7.5){
                interfaceConsola.mensajePierdeBanca()
                game = false
                break
            }else if(sieteYmedia.valorCartas(cartasBanca) == 7.5){
                interfaceConsola.mensajeGanadorBanca()
                game = false
                break
            }
        }
    }
}
