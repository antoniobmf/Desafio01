package DesafioKotlin

abstract class Professor(
    val nome: String? = null,
    val sobrenome: String? = null,
    val tempoDeCasa: Int,
    val codigo: Int
) {

    override fun equals(other: Any?): Boolean {
        return (other is Professor) && (codigo == other.codigo)
    }
}