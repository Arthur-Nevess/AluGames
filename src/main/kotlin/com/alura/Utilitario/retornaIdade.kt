import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformaIdade(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var idade = 0
    val dataDeNascimento = LocalDate.parse(this, formatter)
    val hoje = LocalDate.now()
    idade = Period.between(dataDeNascimento, hoje).years

    return idade
}