package DesafioKotlin

import java.util.*

class DigitalHouseManager() {
    var listaAlunos = mutableListOf<Aluno>()
    var listaProfessores = mutableListOf<Professor>()
    var listaCursos = mutableListOf<Curso>()
    var listaMatriculas = mutableListOf<Matricula>()

    // >>>>>> Registrando Curso
    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {
        var novoCurso = Curso(nome, codigoCurso, quantidadeMaximaDeAlunos)
        listaCursos.add(novoCurso)
        println("Curso ${novoCurso.nome} com codigo: ${codigoCurso} foi registrado com sucesso")
    }

    // >>>>>> Excluindo um Curso
    fun excluirCurso(codigoCurso: Int) {
        for (curso in listaCursos) {
            if (curso.codigo == codigoCurso) {
                listaCursos.remove(curso)
            }
        }
        println("Curso com codigo: ${codigoCurso} foi registrado com sucesso")
    }

    // >>>>>> Registrando Professor Adjunto
    fun registrarprofessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        val novoProfessorAdjunto = ProfessorAdjunto(nome, sobrenome, 0, codigoProfessor, quantidadeDeHoras)
        listaProfessores.add(novoProfessorAdjunto)
        println("Professor adjunto(a) ${novoProfessorAdjunto.nome} ${novoProfessorAdjunto.sobrenome} foi registrado com sucesso")
    }

    // >>>>>> Registrando Professor Titular
    fun registrarprofessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        val novoProfessorTitular = ProfessorTitular(nome, sobrenome, 0, codigoProfessor, especialidade)
        listaProfessores.add(novoProfessorTitular)
        println("Professor titular(a) ${novoProfessorTitular.nome} ${novoProfessorTitular.sobrenome} foi registrado com sucesso")
    }

    // >>>>>> Excluindo um professor
    fun excluirProfessor(codigoProfessor: Int) {
        for (professor in listaProfessores) {
            if (professor.codigo == codigoProfessor) {
                listaProfessores.remove(professor)
            }
        }
        println("Professor(a) ${codigoProfessor} foi excluido com sucesso. ")
    }

    // >>>>>> Registrando um aluno
    fun registrarAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        val novoaluno = Aluno(nome, sobrenome, codigoAluno)
        listaAlunos.add(novoaluno)
        println("Aluno(a) ${novoaluno.nome} ${novoaluno.sobrenome} foi registrado com sucesso")
    }

    // >>>>>> Matriculando um aluno
    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {

        // ------ Pesquisa/Valida o codigoCurso
        val curso = listaCursos.find { it.codigo == codigoCurso }

        if (curso !is Curso) {
            println("Nenhum curso com o c??digo $curso foi encontrado")
            return
        }

        // ------  Pesquisa/Valida o codigoAluno
        val aluno = listaAlunos.find { it.codigo == codigoAluno }

        if (aluno !is Aluno) {
            println("Nenhum aluno com o c??digo $aluno foi encontrado")
            return
        }

        // ------ Verifica se h?? vaga no curso
        if (!curso.adicionarUmAluno(aluno)) {
            println("N??o h?? vagas para o curso ${curso.nome}.")
            return
        }

        // ------ Matricula aluno no curso
        val matricula = Matricula(aluno = aluno, curso = curso)
        listaMatriculas.add(matricula)
        println("Matr??cula do aluno(a): ${aluno.nome} realizada com sucesso no curso ${curso.nome}.")
    }

    // >>>>>> Alocando Professores
    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        val professorTitular = listaProfessores.find { it is ProfessorTitular && it.codigo == codigoProfessorTitular }
        val professorAdjunto = listaProfessores.find { it is ProfessorAdjunto && it.codigo == codigoProfessorAdjunto }
        val curso = listaCursos.find { it.codigo == codigoCurso }

        if (professorTitular == null) {
            println("Professor titular $codigoProfessorTitular n??o existe")
            return
        }
        if (professorAdjunto == null) {
            println("Professor adjunto $codigoProfessorAdjunto n??o existe")
            return
        }
        if (curso == null) {
            println("Curso $codigoCurso n??o existe")
            return
        }

        curso.professorTitular = professorTitular as ProfessorTitular
        curso.professorAdjunto = professorAdjunto as ProfessorAdjunto
        println("Professores $codigoProfessorTitular e $codigoProfessorAdjunto alocados ao curso $codigoCurso")
    }


    // >>>>>> Consultando qual curso o aluno est?? matriculado pelo codigo
    fun consultarMatriculasAluno(codigoAluno: Int) {
        if (listaAlunos.find { it.codigo == codigoAluno } == null) {
            println("Aluno $codigoAluno n??o existe")
            return
        }
        val matriculas = listaMatriculas.filter { it.aluno.codigo == codigoAluno }
        if (matriculas.isNullOrEmpty()) {
            println("Aluno $codigoAluno n??o est?? matriculado em nenhum curso")
            return
        }
        println("Aluno $codigoAluno est?? matriculado no(s) seguinte(s) curso(s): ")
        for (elemento in matriculas) {
            println("\tCurso: ${elemento.curso.nome} (matricula realizada em ${elemento.dtMatricula})")
        }
    }

}
