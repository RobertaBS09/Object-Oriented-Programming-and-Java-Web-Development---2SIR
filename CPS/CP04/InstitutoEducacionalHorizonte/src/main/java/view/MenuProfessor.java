package view;

import DAO.ProfessorDAO;
import model.Professor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static javax.swing.JOptionPane.*;

public class MenuProfessor {
    public void menu(){

    String[] item = new String[]{"Cadastrar", "Listar", "Pesquisar", "Resumo folha","Finalizar"};

    String opcao;

    do {
        opcao= (String) showInputDialog((Component)null,"Selecione uma opção","Menu Principal",1,(Icon) null,item,item[0]);
        switch (opcao.toLowerCase()){
            case "cadastrar":
                this.cadastrar();
                break;
            case "listar":
                this.listar();
                break;
            case "pesquisar":
                this.pesquisar();
                break;
            case "resumo folha":
                this.resumoFolha();
                break;
        }
    }while(!opcao.toLowerCase().equals("finalizar"));

    }

    private void resumoFolha() {
        List<Professor> lista = new ProfessorDAO().listar();

        int quantidade = lista.size();
        double totalFolha = 0.0;

        for (Professor p : lista) {
            // garante cálculo mesmo se listar vier sem salário carregado
            if (p.getAulas_semanais() != null && p.getValor_hora() != null) {
                p.calcularSalario();
            }
            totalFolha += (p.getSalario() != null ? p.getSalario() : 0.0);
        }

        double media = (quantidade > 0) ? (totalFolha / quantidade) : 0.0;

        String msg =
                "Quantidade de professores: " + quantidade + "\n" +
                        "Total da folha: " + String.format("%.2f", totalFolha) + "\n" +
                        "Média salarial: " + String.format("%.2f", media);

        showMessageDialog(null, msg);
    }

    private void pesquisar() {
        String entrada = showInputDialog("Digite o ID do professor:");
        if (entrada == null || entrada.trim().isEmpty()) {
            return;
        }

        int id = Integer.parseInt(entrada);
        Professor p = new ProfessorDAO().buscarPorId(id);

        if (p == null) {
            showMessageDialog(null, "Professor com ID " + id + " não encontrado.");
            return;
        }

        String detalhe =
                "ID: " + p.getId_professor() + "\n" +
                        "Nome: " + p.getNome() + "\n" +
                        "Regime: " + p.RegimeTrabalho() + "\n" +
                        "Aulas semanais: " + p.getAulas_semanais() + "\n" +
                        "Valor hora-aula: " + String.format("%.2f", p.getValor_hora()) + "\n" +
                        "Salário base: " + String.format("%.2f", p.getSalario_base()) + "\n" +
                        "DSR: " + String.format("%.2f", p.getDSR()) + "\n" +
                        "Hora-atividade: " + String.format("%.2f", p.getHora_atividade()) + "\n" +
                        "Salário total: " + String.format("%.2f", p.getSalario());

        showMessageDialog(null, detalhe);
    }

    private void listar() {
        List<Professor> lista = new ProfessorDAO().listar();

        if (lista.isEmpty()) {
            showMessageDialog(null, "Nenhum professor cadastrado.");
            return;
        }

        String aux = "";

        for (Professor p : lista) {
            aux += p.getId_professor() + " | "
                    + p.getNome() + " | "
                    + p.RegimeTrabalho() + " | "
                    + String.format("%.2f", p.getSalario()) + "\n";
        }

        showMessageDialog(null, aux);
    }

    private void cadastrar() {
        Professor professor= new Professor();
        String nome = showInputDialog("Digite o nome do professor: ");
        professor.setNome(nome);
        Integer qtd_aulas = Integer.valueOf((JOptionPane.showInputDialog("Digie a quantidade de aulas por semana: ")));
        professor.setAulas_semanais(qtd_aulas);
        Double valor_aula = Double.valueOf(showInputDialog("Digite o valor da hora por aula: "));
        professor.setValor_hora(valor_aula);

        professor.calcularSalario();

        ProfessorDAO professorDAO = new ProfessorDAO();

        professorDAO.inserir(professor);



    }

}
