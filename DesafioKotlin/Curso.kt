package DesafioKotlin

class Curso(
    val nome: String? = null,
    val codigo: Int? = null,
    val qtdMaximaAlunos: Int,
) {

    var professorTitular: ProfessorTitular? = null
    var professorAdjunto: ProfessorAdjunto? = null
    var listaAlunosMatriculados: MutableList<Aluno> = mutableListOf()

    override fun equals(other: Any?): Boolean {
        return (other is Curso) && (codigo == other.codigo)
    }

    fun adicionarUmAluno(umAluno: Aluno): Boolean {
        return if (listaAlunosMatriculados.size < qtdMaximaAlunos) {
            listaAlunosMatriculados.add(umAluno)
            println("Aluno adicinado no curso ${this.nome}")
            true
        } else {
            println("Não há vagas disponíveis no curso ${this.nome}")
            false
        }
    }

    fun excluirAluno(umAluno: Aluno): Boolean {
        return if (listaAlunosMatriculados.contains(umAluno)) {
            listaAlunosMatriculados.remove(umAluno)
            println("Aluno excluido do curso ${this.nome}")
            true
        } else {
            println("Aluno não matriculado no curso ${this.nome}")
            false

        }
    }

}
