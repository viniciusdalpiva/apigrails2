package projetoapi

import java.time.LocalDate

class BootStrap {

    def init = { servletContext ->
        def dep1 = new Departamento(nome: "Suporte").save()
        def dep2 = new Departamento(nome: "Juridico").save()
        def dep3 = new Departamento(nome: "Comercial").save()

        new Empregado(nome: "Cleito Rasta", dataNascimento: LocalDate.parse("1978-03-18"), matricula: 12345, departamento: dep3).save()
        new Empregado(nome: "Deyverson", dataNascimento: LocalDate.parse("1981-04-15"), matricula: 67890, departamento: dep2).save()
        new Empregado(nome: "Manuel Gomes", dataNascimento: LocalDate.parse("1975-02-14"), matricula: 54321, departamento: dep1).save()
        new Empregado(nome: "Vanderlei Luxemburgo", dataNascimento: LocalDate.parse("1985-06-17"), matricula: 98765, departamento: dep3).save()
        new Empregado(nome: "Ronaldo", dataNascimento: LocalDate.parse("1953-10-16"), matricula: 13579, departamento: dep2).save()
    }

    def destroy = {
    }
}
