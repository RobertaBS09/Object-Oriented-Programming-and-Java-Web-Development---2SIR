package br.fiap.calculadora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
// precisa disso para ser um controller, ser um controller significa que a classe esta hbailitada para recever e devolver requisições
@RequestMapping("/calculadora") //pq no navegador vamos requisar o navegador
public class CalculadoraController {

    @GetMapping("/somar") // para enviar do navegador
    public int somar(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) { //colocando um valor defalut para caso o usuario não digite um valor na soma
        return a + b;
    }

    @GetMapping("/subtrair")
    public int subtrair(int a, int b) {
        return a - b;
    }

    @GetMapping("/dividir")
    public double dividir(int a, int b) {
        if (b == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Não existe divisão por zero!");//foi uma requisição ruim

        }
        return (double) a / b;
    }

    @GetMapping("/dividirMap")
    public Map<String, Double> dividirMap(int a, int b) {
        if (b == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Não existe divisão por zero!");//foi uma requisição ruim

        }
        return Map.of("resultado", (double) a / b);//inserir o dado de maneira rapida no map, passar a chave, valor (nesse caso o valor da divião, logo colocar a divisão)
    }

    @GetMapping("/multiplicar")
    public int multiplicar(int a, int b) {
        return a * b;
    }
}
