package br.com.completeCRUD.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.completeCRUD.beans.CompleteCRUD;


public interface CompleteCRUDDAO extends CrudRepository<CompleteCRUD, Integer>{

	public CompleteCRUD findByNomeAndSetor(String nome, String setor);
	public CompleteCRUD findAllById(int Id);
	public CompleteCRUD findById(int Id);





	
}
