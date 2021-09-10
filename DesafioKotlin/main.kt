package DesafioKotlin

fun main() {

    val DHM = DigitalHouseManager()

    // >>>>>> Registrando alunos <<<<<<<<
    println(" ###################### Registro de Alunos ###################### ")
    DHM.registrarAluno("Antonio", "Brito", 1)
    DHM.registrarAluno("Pedro", "Moreira", 2)
    DHM.registrarAluno("Silvio", "Alves", 3)
    DHM.registrarAluno("José", "Filho", 4)
    DHM.registrarAluno("Carlos", "Santos", 5)
    println("")

    // >>>>>> Registrando Professores <<<<<<<<
    /// Adjuntos
    println("###################### Registro de Professores ######################")
    DHM.registrarprofessorAdjunto("Mario", "Santos", 1, 10)
    DHM.registrarprofessorAdjunto("Kleber", "Mota", 2, 20)
    // Titulares
    DHM.registrarprofessorTitular("Felipe", "Ishak", 3, "BACKEND")
    DHM.registrarprofessorTitular("Diego", "Alves", 4, "FRONTEND")
    println("")

    // >>>>>> Registrando Cursos <<<<<<<<
    println("###################### Registro de Cursos ######################")
    DHM.registrarCurso("Full Stack", 20001, 3)
    DHM.registrarCurso("Android", 20002, 2)
    println("")

    // >>>>>> Alocando um professor titular e um adjunto para cada curso <<<<<<<<
    println("###################### Alocação de Professores ######################")
    DHM.alocarProfessores(20001, 3, 1)
    DHM.alocarProfessores(20002, 2, 4)
    println("")

    // >>>>>> Matriculando 2 alunos no curso de Full Stack <<<<<<<<
    println("###################### Matricular aluno ######################")
    DHM.matricularAluno(1, 20001)
    DHM.matricularAluno(2, 20001)

    // >>>>>> Matriculando 3 alunos no curso de Android <<<<<<<<
    DHM.matricularAluno(3, 20002)
    DHM.matricularAluno(4, 20002)
    DHM.matricularAluno(5, 20002)
    println("")

    // >>>>>> Realizando a consulta de um aluno pelo codigo <<<<<<<<
    println("###################### Consultar Aluno ######################")
    DHM.consultarMatriculasAluno(3)
    println("")

}