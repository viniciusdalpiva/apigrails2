package projetoapi

import org.springframework.validation.BindingResult

class DepartamentoService {

    def listarDepartamentos() {
        Departamento.list()
    }

    def buscarDepartamentoPorId(Long id) {
        Departamento.get(id)
    }

    def criarDepartamento(Map departamentoData) {
        def departamento = new Departamento(departamentoData)
        departamento.save()
        departamento
    }

    def atualizarDepartamento(Long id, Map departamentoData) {
        def departamento = Departamento.get(id)
        departamento.properties = departamentoData// as BindingResult
        departamento.save()
        departamento
    }

    def excluirDepartamento(Long id) {
        def departamento = Departamento.get(id)
        departamento.delete()
        departamento
    }
}
