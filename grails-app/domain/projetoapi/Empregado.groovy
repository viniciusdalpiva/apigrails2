package projetoapi

import grails.converters.JSON
import groovy.json.JsonBuilder
import java.time.format.DateTimeFormatter
import java.time.LocalDate

class Empregado {
    Long id
    String nome
    LocalDate dataNascimento
    Integer matricula
    Departamento departamento


    static belongsTo = [departamento: Departamento]
    static {
        JSON.registerObjectMarshaller(LocalDate) { LocalDate date ->
            date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        }
    }

//    static mapping = {
//        id generator: 'identity'
//    }

    static constraints = {
        nome blank: false
        dataNascimento nullable: false
        matricula nullable: false
        departamento nullable: false
    }

    String toJson() {
        def dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        def dataNascimentoFormatada = dataNascimento.format(dateFormatter)

        def json = new JsonBuilder(this)
        json.dataNascimento = dataNascimentoFormatada
        json.toString()
    }
}
