package br.edu.insper.model;

import java.util.Calendar;

public class Jogos {
	private Integer id;
	private String nome;
	private Calendar data;
	private Integer tamanho;
	
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public Calendar getData() {return data;}
	public void setData(Calendar data) {this.data = data;}
	
	public Integer getTamanho( ) {return tamanho;}
	public void setTamanho(Integer tamanho) {this.tamanho = tamanho;}
}
