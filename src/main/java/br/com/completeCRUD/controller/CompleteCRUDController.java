package br.com.completeCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.completeCRUD.beans.CompleteCRUD;
import br.com.completeCRUD.dao.CompleteCRUDDAO;

@CrossOrigin("*")
@Controller
public class CompleteCRUDController {
	
	@Autowired // objeto gerenciavel, não precisa de new
	private CompleteCRUDDAO dao;
	
	
	@GetMapping("/create")
	public String create(){
		return "novoproduto";
	}
	@GetMapping("/read")
	public String read(){
		return "lerproduto";
	}
	@GetMapping("/update")
	public String update(){
		return "atualizarproduto";
	}
	@GetMapping("/delete")
	public String delete(){
		return "deletarproduto";
	}
	@GetMapping("/index")
	public String index(){
		return null;
	}
	
	
	@PostMapping("/novoproduto")
	public ResponseEntity<CompleteCRUD> CreatProduto(@RequestBody CompleteCRUD objeto){
		try {
			dao.save(objeto);
			return ResponseEntity.ok(objeto);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}
	@PostMapping("/lerproduto")
	public ResponseEntity<CompleteCRUD> ReadProduto(@RequestBody CompleteCRUD objeto){
		
		CompleteCRUD resposta = dao.findByNomeAndSetor(objeto.getNome(), objeto.getSetor());
		
		if(resposta == null) {
			return ResponseEntity.status(404).build();
		}
		System.out.println(resposta.getId());
		return ResponseEntity.ok(resposta);
		
	}
	@PutMapping("/deletarproduto")
	public ResponseEntity<CompleteCRUD> DeletarProduto(@RequestBody CompleteCRUD objeto){
		
		CompleteCRUD resposta = dao.findById(objeto.getId());
		if(resposta == null) {
			return ResponseEntity.status(404).build();
		}
		dao.delete(objeto);
		
		return ResponseEntity.ok(resposta);
		
		
	}
	
	
	@PutMapping("/atualizarproduto")
	public ResponseEntity<CompleteCRUD> AtualizarProduto(@RequestBody CompleteCRUD objeto){
		
		CompleteCRUD resposta = dao.findAllById(objeto.getId());
		if(resposta == null) {
			return ResponseEntity.status(404).build();
		}
		
		System.out.println("valores antigos");
		String nome_ant = resposta.getNome();
		System.out.println(nome_ant);
		
		String setor_ant = resposta.getSetor();
		System.out.println(setor_ant);

		int valor_ant = resposta.getValor();
		System.out.println(valor_ant);
		
		System.out.println("valores novos");
		System.out.println(objeto.getNome());
		System.out.println(objeto.getSetor());
		System.out.println(objeto.getValor());
			
		resposta.setNome(objeto.getNome());
		resposta.setSetor(objeto.getSetor());
		resposta.setValor(objeto.getValor());
		dao.save(resposta);
		
		return ResponseEntity.ok(resposta);
		
		
	}
	
	
	
}

