package com.schutele.model;

public class Usuario {
   private int id;
   private String matricula;
   private String TipoUsuario;
   private String nome;
   private String bloco;
   private String ap;
   private String email;
   private String senha;
   private boolean Bloqueado;

   public Usuario(String matricula, String nome, String bloco, String ap, String senha, String email, String TipoUsuario) {
      this.matricula = matricula;
      this.nome = nome;
      this.bloco = bloco;
      this.ap = ap;
      this.senha = senha;
      this.email = email;
      this.TipoUsuario = TipoUsuario;
   }

   public Usuario(int id, String email, String TipoUsuario) {
      this.id = id;
      this.email = email;
      this.TipoUsuario = TipoUsuario;
   } 
   
   public boolean isBloqueado() {
	return Bloqueado;
   }

   public void setBloqueado(boolean Bloqueado) {
	this.Bloqueado = Bloqueado;
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getMatricula() {
      return this.matricula;
   }

   public void setMatricula(String matricula) {
      this.matricula = matricula;
   }

   public String getTipoUsuario() {
      return this.TipoUsuario;
   }

   public void setTipoUsuario(String tipoUsuario) {
      this.TipoUsuario = tipoUsuario;
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getBloco() {
      return this.bloco;
   }

   public void setBloco(String bloco) {
      this.bloco = bloco;
   }

   public String getAp() {
      return this.ap;
   }

   public void setAp(String ap) {
      this.ap = ap;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getSenha() {
      return this.senha;
   }

   public void setSenha(String senha) {
      this.senha = senha;
   }
}