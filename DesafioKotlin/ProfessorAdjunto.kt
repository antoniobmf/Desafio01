package DesafioKotlin

class ProfessorAdjunto(
    nome: String,
    sobrenome: String,
    tempoDeCasa: Int,
    codigo: Int,
    var qtdHorasMonitoria: Int
) : Professor(nome, sobrenome, tempoDeCasa, codigo)