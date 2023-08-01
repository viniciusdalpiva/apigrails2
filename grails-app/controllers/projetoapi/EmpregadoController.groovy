//package projetoapi
//
//import grails.converters.JSON
//import grails.gorm.transactions.Transactional
//
//@Transactional
//class EmpregadoController {
//
//    def empregadoService
//
//    def index() {
//        def empregados = empregadoService.listarEmpregadosFormatted()
//        render empregados as JSON
//    }
//
//    def show(Long id) {
//        def empregado = empregadoService.buscarEmpregadoFormatadoPorId(id)
//        render empregado as JSON
//    }
//
//    def save() {
//        try {
//            def empregadoData = request.JSON
//            def empregado = empregadoService.criarEmpregado(empregadoData)
//            render empregado as JSON
//        } catch (IllegalArgumentException e) {
//            renderError(e.message)
//        }
//    }
//
//    def update(Long id) {
//        try {
//            def empregadoData = request.JSON
//            def empregado = empregadoService.atualizarEmpregado(id, empregadoData)
//            render empregado as JSON
//        } catch (IllegalArgumentException e) {
//            renderError(e.message)
//        }
//    }
//
//    def delete(Long id) {
//        try {
//            def empregado = empregadoService.excluirEmpregado(id)
//            render empregado as JSON
//        } catch (IllegalArgumentException e) {
//            renderError(e.message)
//        }
//    }
//
//    private renderError(String errorMessage) {
//        render(contentType: 'application/json') {
//            message "Bad Request"
//            error 400
//            data errorMessage
//        }
//    }
//}
package projetoapi

import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class EmpregadoController {

    def empregadoService

    def index() {
        def empregados = empregadoService.listarEmpregadosFormatted()
        render empregados as JSON
    }

    def show(Long id) {
        def empregado = empregadoService.buscarEmpregadoFormatadoPorId(id)
        render empregado as JSON
    }

    def save() {
        try {
            def empregadoData = request.JSON
            def empregado = empregadoService.criarEmpregado(empregadoData)
            render empregado as JSON
        } catch (IllegalArgumentException e) {
            renderError(e.message)
        }
    }

    def update(Long id) {
        try {
            def empregadoData = request.JSON
            def empregado = empregadoService.atualizarEmpregado(id, empregadoData)
            render empregado as JSON
        } catch (IllegalArgumentException e) {
            renderError(e.message)
        }
    }

    def delete(Long id) {
        try {
            def empregado = empregadoService.excluirEmpregado(id)
            render empregado as JSON
        } catch (IllegalArgumentException e) {
            renderError(e.message)
        }
    }

    private renderError(String errorMessage) {
        render(contentType: 'application/json') {
            message "Bad Request"
            error 400
            data errorMessage
        }
    }
}
