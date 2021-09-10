package DesafioKotlin

import java.util.*

open class Matricula(
    var aluno: Aluno,
    var curso: Curso,
) {

    val dtMatricula: Date = Date()
}