package DesafioKotlin

class ProfessorTitular(
    nome: String,
    sobreNome: String,
    tempoDeCasa: Int,
    codigo: Int,
    var especialidade: String
) : Professor(nome, sobreNome, tempoDeCasa, codigo)