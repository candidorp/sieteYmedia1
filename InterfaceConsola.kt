import recursos.Carta
import kotlin.collections.forEach

class InterfaceConsola{
    var sieteYmedia = SieteYmedia()
    val cartasJugador = sieteYmedia.cartasJugador
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

    fun mostrarCartas(turno: String, cartas: List<Carta>) {
        if(turno.lowercase() == "jugador"){
            println()
            print("Estas son tus cartas jugador: ")
            cartas.forEach { print("$it")}
            println()
        }else{
            println()
            print("Estas son mis cartas: ")
            cartas.forEach { print("$it")}
            println()
        }
    }

    fun preguntarDecision(): Char{
        println("\n¿Pides [C]arta o te [P]lantas?")
        return readln().trim().uppercase()[0]
    }

    fun mostrarValorCartas(turno: String, cartas:List<Carta>){
        if(turno.lowercase() == "jugador"){
            print("Este el valor de tus cartas:")
            print(sieteYmedia.valorCartas(cartas))
            println()
        }else{
            println()
            print("Este el valor de mis cartas:")
            print(sieteYmedia.valorCartas(cartas))
            println()
        }
    }

    fun mensajeGanadorJugador(){
        println()
        println("Ganaste jugador!!! ...por primera y ultima vez, te lo aseguro. Exijo la revancha!!!!")
    }

    fun mensajePerdedorJugador(){
        println()
        println("Jugador, te has pasado, gana la banca")
    }

    fun mensajeMinimoCartas(){
        println("Como mínimo recibes una carta")
        println()
    }

    fun mensajeTurnoBanca(){
        println("\nTurno de banca ...")
    }

    fun mensajeGanadorBanca(){
        println("Ten en cuenta que a largo plazo la banca siempre gana, como ahora por ejemplo...")
    }

    fun mensajePierdeBanca(){
        println("Me pase, ganas tu")
    }

    fun mensajeTurnoJugador(){
        println("\nTurno del jugador ...")
    }
}
