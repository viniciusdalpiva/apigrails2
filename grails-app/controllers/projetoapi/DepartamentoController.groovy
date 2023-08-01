package projetoapi

import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class DepartamentoController {

    def departamentoService


    def index() {
        def departamentos = departamentoService.listarDepartamentos()
        render departamentos as JSON
    }

    def show(Long id) {
        def departamento = departamentoService.buscarDepartamentoPorId(id)
        render departamento as JSON
    }

    def save() {
        def departamentoData = request.JSON
        def departamento = departamentoService.criarDepartamento(departamentoData)
        render departamento as JSON
    }

    def update(Long id) {
        def departamentoData = request.JSON
        def departamento = departamentoService.atualizarDepartamento(id, departamentoData)
        render departamento as JSON
    }

    def delete(Long id) {
        def departamento = departamentoService.excluirDepartamento(id)
        render departamento as JSON
    }
}

