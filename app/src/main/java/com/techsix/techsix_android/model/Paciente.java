package com.techsix.techsix_android.model;

/**
 * Created by android on 27/09/2018.
 */

public class Paciente {
    private String id, nome, senha, endereco, email, nascimento,telefone, sexo;
    private Integer estado_civil;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }



    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String isSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer isEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(Integer estado_civil) {
        this.estado_civil = estado_civil;
    }




//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public int getIdade() {
//        return RG;
//    }
//
//    public void setIdade(int idade) {
//        this.RG = idade;
//    }

    @Override
    public String toString() {
        return nome + "\n" + email + "\n" + senha + "\n" + endereco + "\n" + nascimento + "\n" + telefone + "\n" + sexo + "\n" + estado_civil;

    }
}
