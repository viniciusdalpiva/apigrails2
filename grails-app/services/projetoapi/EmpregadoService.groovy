package projetoapi

class EmpregadoService {

    def listarEmpregadosFormatted() {
        Empregado.list().collect { empregado ->
            formatEmpregado(empregado)
        }
    }

    def buscarEmpregadoFormatadoPorId(Long id) {
        def empregado = Empregado.get(id)
        formatEmpregado(empregado)
    }

    def criarEmpregado(Map empregadoData) {
        validarDadosObrigatorios(empregadoData)
        def empregado = new Empregado(empregadoData)

        empregado.save()
        formatEmpregado(empregado)
    }

    def atualizarEmpregado(Long id, Map empregadoData) {
        validarDadosObrigatorios(empregadoData)
        def empregado = Empregado.get(id)
        empregado.properties = empregadoData
        empregado.save()
        formatEmpregado(empregado)
    }

    def excluirEmpregado(Long id) {
        def empregado = Empregado.get(id)
        empregado.delete()
        formatEmpregado(empregado)
    }

    private formatEmpregado(empregado) {
        [
                id: empregado.id,
                matricula: empregado.matricula,
                nome: empregado.nome,
                dataNascimento: empregado.dataNascimento,
                departamento: empregado.departamento.id
        ]
    }

    private validarDadosObrigatorios(Map empregadoData) {
        def requiredFields = ['nome', 'matricula', 'dataNascimento', 'departamento']
        def missingFields = requiredFields.findAll { !empregadoData.containsKey(it) }

        if (missingFields) {
            def missingFieldsStr = missingFields.join(', ')
            throw new IllegalArgumentException("Não foi possível incluir o empregado, campo(s) '${missingFieldsStr}' não foi(foram) preenchido(s).")
        }
    }
}