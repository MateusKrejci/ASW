package br.edu.ifsp.taskfacil.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class CadastroTarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 255)
	private String nomeTarefa;
	@Column(length = 255)
	private String descriTarefa;
	@OneToMany(mappedBy = "usuario")
	private List<Usuario> listaColaboradores;
	
	// Todos os meus getters
	public int getId() {
		return id;
	}
	public String getNomeTarefa() {
		return nomeTarefa;
	}
	public String getDescriTarefa() {
		return descriTarefa;
	}
	public List<Usuario> getListaColaboradores() {
		return listaColaboradores;
	}

	// Todos os meus setters
	public void setId(int id) {
		this.id = id;
	}
	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}
	public void setDescriTarefa(String descriTarefa) {
		this.descriTarefa = descriTarefa;
	}
	public void setListaColaboradores(List<Usuario> listaColaboradores) {
		this.listaColaboradores = listaColaboradores;
	}
	
	@Override
	public String toString() {
		return "CadastroTarefa [id=" + id + ", nomeTarefa=" + nomeTarefa + ", descriTarefa=" + descriTarefa
				+ ", listaColaboradores=" + listaColaboradores + "]";
	}
	
}
