class CadastrarHospedes {

    var nome : String = ""
    var nomeHospede : String = ""
    var idadeHospedes : String = ""

    var diaria : Int = 0
    var valor : Double = 0.0
    var quartoReserva : Int = 0
    var data : String = ""

    var diaria02 : Double = 0.0

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

    fun mostrarQuartos () {
        println("Status dos quartos:")
        for (i in 1..20) {
            if (quartosOcupados.contains(i)) {
                println("$i - ocupado")
            } else {
                println("$i - livre")
            }
        }
    }

    var meia = 0
    var gratuidade = 0
    fun idade (nome : String, _idade : Int) {



        if (_idade <= 6){
            println("${nome} cadastrado com sucesso. ${nome} possui gratuidade.")
            gratuidade += 1
        } else if (_idade >= 60) {
            diaria02 += 50
            println("${nome} cadastrado com sucesso. ${nome} paga meia.")
            meia += 1
        } else {
            diaria02 += 100
            println("${nome} cadastrado com sucesso.")
        }

    }

}