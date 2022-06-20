package com.example.tdd;

public class testeERRO {
    public class Telefone {
        public String nome = "Oliver";
        public String id = "0321";

        public Telefone(String nome, String id) {
            this.nome = nome;
            this.id = id;
        }

        public Telefone() {

        }
    }

    static Telefone telefone;

    public static void main(String[] args){
        try{
            System.out.println(telefone.nome);
        } catch (Exception e){
            System.out.println("Não é possível prosseguir. O objeto telefone é nulo");
        }
    }


}
