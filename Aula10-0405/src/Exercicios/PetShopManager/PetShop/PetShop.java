package Exercicios.PetShopManager.PetShop;

import Exercicios.PetShopManager.Animal.Animal;
import Exercicios.PetShopManager.Interface.Calculavel;
import Exercicios.PetShopManager.Interface.Relatorio;
import Exercicios.PetShopManager.Servico.Atendimento;
import Exercicios.PetShopManager.Servico.Servico;

import java.util.ArrayList;

public class PetShop implements  Relatorio, Calculavel{
    private ArrayList<Animal> listaAnimal;
    private ArrayList<Servico> listaServico;
    private ArrayList<Atendimento> listaAtendimento;

    public PetShop() {
        listaAnimal = new ArrayList<>();
        listaServico = new ArrayList<>();
        listaAtendimento = new ArrayList<>();
            }




}
