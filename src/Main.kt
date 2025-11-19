import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.zip.DataFormatException

fun main() {

    inicio()

}

fun inicio () {

    var hospede = CadastrarHospedes()
    println("Olá, seja bem-vindo(a) ao Lótus Hotel.\n" +
            "Digite seu nome:")
    hospede.nome = readLine()!!.uppercase()
    println("Digite sua senha:")
    var senha = readLine()!!.toInt()

    while (senha != 2678) {
        println("Acesso negado. Digite sua senha novamente:")
        senha = readLine()!!.toInt()
    }
    println("Acesso liberado!")
    caso(hospede)
}

fun caso (hospede: CadastrarHospedes) {

    println("----- MENU LÓTUS HOTEL -----\n" +
            "Escolha uma opção\n" +
            "1. Reserva\n" +
            "2. Cadastrar Hóspedes\n" +
            "3. \n" +
            "4. Sair")
    var op = readLine()!!.toInt()

    when (op) {
        1 -> cadastrarQuarto(hospede)
        2 -> cadastrarHospedes(hospede)
        //3 -> c()
        //4 -> d()
    }
}

fun cadastrarQuarto (hospede: CadastrarHospedes) {

    println("Digite o nome do hóspede:")
    hospede.nomeHospede = readLine()!!.uppercase()

    println("Para quando você deseja reservar? (Formato: DD/MM/AAAA)")
    hospede.data = readLine()!!
    val date = LocalDate.parse(hospede.data, DateTimeFormatter.ofPattern("dd/MM/yyyy"))

    println("Qual o valor padrão da diária?")
    hospede.valor = readLine()!!.toDouble()

    println("Quantas diárias serão necessárias?")
    hospede.diaria = readLine()!!.toInt()

    hospede.calcDiaria()

    println("Qual o quarto para reservar? (1 - 20)")
    hospede.quartoReserva = readLine()!!.toInt()

    hospede.quartos()
    hospede.mostrarQuartos()

    if (hospede.nome.equals(hospede.nomeHospede)) {
        println("Sua reserva foi efetuada para o dia ${date}.")
    } else {
        println("${hospede.nome}, reserva efetuada para ${hospede.nomeHospede} para o dia ${date}")
    }

    caso(hospede)

}

fun cadastrarHospedes (hospede: CadastrarHospedes) {

    hospede.nomeHospede = ""
    hospede.idadeHospedes = 0
    var stop : String = ""

    while (stop != "PARE") {
        println("Informe o nome do hóspede:")
        val addNome = readLine()!!.uppercase()
        println("Informe a idade do hóspede:")
        val addIdade = readLine()!!.toInt()

        if (addNome == "PARE") {
            stop == "PARE"
        } else {
            hospede.nomeHospede += addNome + "\n"
            //hospede.idadeHospedes += addIdade + "\n"
        }

    }

}