class CadastrarHospedes {

    var nome : String = ""
    var nomeHospede : String = ""
    var idadeHospedes : Int = 0

    var diaria : Int = 0
    var valor : Double = 0.0
    var quartoReserva : Int = 0
    var data : String = ""

    companion object {
        val quartosOcupados = mutableSetOf<Int>()
    }

    fun calcDiaria () {
        val _valor = diaria * valor
        println("O valor de ${diaria} dias de hospedagem é de R$${_valor}")
    }

    fun quartos () {
        var bool : Boolean = false
        while (bool == false) {
            if (quartoReserva in 1..20) {
                for (i in 1..20) {
                    if (i == quartoReserva) {
                        println("Esse quarto está sendo ocupado. Escolha outro. Os quartos livres são:")

                        quartoReserva = readLine()!!.toInt()
                    } else {
                        bool = true
                    }
                }
            } else {
                println("ERRO: reserva inválida. Tente novamente:")
                quartoReserva = readLine()!!.toInt()
            }
        }
    }

    fun mostrarQuartos() {
        println("Status dos quartos:")
        for (i in 1..20) {
            if (quartosOcupados.contains(i)) {
                println("$i - ocupado")
            } else {
                println("$i - livre")
            }
        }
    }
}