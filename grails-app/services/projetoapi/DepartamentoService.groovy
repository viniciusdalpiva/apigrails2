//package projetoapi
//
//import org.springframework.validation.BindingResult
//
//class DepartamentoService {
//
//    def listarDepartamentos() {
//        Departamento.list()
//    }
//
//    def buscarDepartamentoPorId(Long id) {
//        Departamento.get(id)
//    }
//
//    def criarDepartamento(Map departamentoData) {
//        def departamento = new Departamento(departamentoData)
//        departamento.save()
//        departamento
//    }
//
//    def atualizarDepartamento(Long id, Map departamentoData) {
//        def departamento = Departamento.get(id)
//        departamento.properties = departamentoData// as BindingResult
//        departamento.save()
//        departamento
//    }
//
//    def excluirDepartamento(Long id) {
//        def departamento = Departamento.get(id)
//        departamento.delete()
//        departamento
//    }
//}

package projetoapi

import org.springframework.validation.BindingResult

class DepartamentoService {

    def listarDepartamentos() {
        Departamento.list()
    }

    def buscarDepartamentoPorId(Long id) {
        def departamento = Departamento.get(id)
        if (!departamento) {
            throw new IllegalArgumentException("Departamento com ID ${id} não encontrado.")
        }
        departamento
    }

    def criarDepartamento(Map departamentoData) {
        def departamento = new Departamento(departamentoData)
        departamento.validate()

        if (departamento.hasErrors()) {
            throw new IllegalArgumentException(departamento.errors.toString())
        }

        departamento.save()
        departamento
    }

    def atualizarDepartamento(Long id, Map departamentoData) {
        def departamento = Departamento.get(id)
        if (!departamento) {
            throw new IllegalArgumentException("Departamento com ID ${id} não encontrado.")
        }

        departamento.properties = departamentoData
        departamento.validate()

        if (departamento.hasErrors()) {
            throw new IllegalArgumentException(departamento.errors.toString())
        }

        departamento.save()
        departamento
    }

    def excluirDepartamento(Long id) {
        def departamento = Departamento.get(id)
        if (!departamento) {
            throw new IllegalArgumentException("Departamento com ID ${id} não encontrado.")
        }
        departamento.delete()
        departamento
    }
}
