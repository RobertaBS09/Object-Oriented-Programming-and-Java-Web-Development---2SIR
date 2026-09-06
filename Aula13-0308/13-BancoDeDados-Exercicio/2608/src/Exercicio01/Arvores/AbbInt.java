package Exercicio01.Arvores;

public class AbbInt {

    private class No {
        int dado;
        No esq, dir;
    }

    public No root = null;

    public No inserir(No p, int info) {
        if (p == null) {//é pq a arvore/subarvore esta vazia
            p = new No();
            p.dado = info;
            p.esq = null; //folhas vazias
            p.dir = null; // folhas vazias
        } else if (info < p.dado) { //se a info for menor
            p.esq = inserir(p.esq, info); //vai para a direita
        } else { //se for maior
            p.dir = inserir(p.dir, info); //vai para a esquerda
        }

        return p;
    }

    public void mostrarEmOrdem(No p){
        if (p != null){ //é pq existe no
            mostrarEmOrdem(p.esq);
            System.out.print("\t"+p.dado);
            mostrarEmOrdem(p.dir);
        }
    }
}
