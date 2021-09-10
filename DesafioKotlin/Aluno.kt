package DesafioKotlin

data class Aluno(
    val nome: String? = null,
    val sobrenome: String? = null,
    var codigo: Int
) {

    override fun equals(other: Any?): Boolean {
        return (other is Aluno) && (codigo == other.codigo)
    }
}

