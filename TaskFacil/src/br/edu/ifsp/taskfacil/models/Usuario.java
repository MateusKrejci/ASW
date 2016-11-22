package br.edu.ifsp.taskfacil.models;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Isso define que a classe será mapeada!
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 64)
	private String nome;
	@Column(length = 120)
	private String email;
	@Column(length = 120)
	private String senha;

	public Usuario() {
		this.id = -1L;
	}

	public Usuario(String nome, String email, String senha) {
		this.id = -1L;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	// Todos os meus getters
	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	// Todos os meus setters
	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String md5(String senha) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("MD5");
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		String senhaCripto = hash.toString(16);
		return senhaCripto;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
}
