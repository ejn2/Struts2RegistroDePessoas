package com.pessoa.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.pessoa.dao.EnderecoDAO;
import com.pessoa.dao.PessoaDAO;
import com.pessoa.models.Contato;
import com.pessoa.models.Endereco;
import com.pessoa.models.Pessoa;

@Namespace("/")
@Results({
	@Result(name = "input", location = "register.jsp")
})
@Validations(requiredFields = {
	@RequiredFieldValidator(fieldName = "pessoa.nome", message = "Preencha este campo"),
	@RequiredFieldValidator(fieldName = "contato.telefone", message = "Preencha este campo"),
	@RequiredFieldValidator(fieldName = "contato.email", message = "Preencha este campo"),
	@RequiredFieldValidator(fieldName = "endereco.rua", message = "Preencha este campo")
},
requiredStrings = {
		@RequiredStringValidator(fieldName = "pessoa.nome", message = "Não pode esta vazio", trim = true),
		@RequiredStringValidator(fieldName = "contato.telefone", message = "Não pode esta vazio", trim = true),
		@RequiredStringValidator(fieldName = "contato.email", message = "Não pode esta vazio", trim = true),
		@RequiredStringValidator(fieldName = "endereco.rua", message = "Não pode esta vazio", trim = true)
})
public class PessoaAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private List<Pessoa> listPessoa;
	private Endereco endereco = new Endereco();
	private Contato contato  = new Contato();
	private Pessoa pessoa = new Pessoa();
	
	@SkipValidation @Action(value = "lista", results = {
			@Result(name = "success", location = "listagem.jsp")
	})
	public String home() {
		this.listPessoa = PessoaDAO.findAll();
		return SUCCESS;
	}
	
	@Action(value="register", results = {
			@Result(name = "success", location = "register.jsp")
	})
	public String register() {
		return SUCCESS;
	}
	
	@Action(value="save", results = {
			@Result(name = "success", location = "lista", type="redirect")
	})
	public String save() {
		this.pessoa.setContato(this.contato);
		Pessoa novaPessoa = PessoaDAO.save(pessoa);
		
		List<Pessoa> pessoaList = new ArrayList<>();
		pessoaList.add(novaPessoa);
		
		this.endereco.setPessoas(pessoaList);
		Endereco novoEndereco = EnderecoDAO.save(this.endereco);
		
		return SUCCESS;
	}
	
	
	@SkipValidation @Action(value="delete", results = {
			@Result(name = "success", location = "lista", type="redirect")
	})
	public String delete() {
		PessoaDAO.deleteByPk(this.id);
		System.out.println("ID: "+this.id);
		return SUCCESS;
	}
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Pessoa> getListPessoa() {
		return listPessoa;
	}

	public void setListPessoa(List<Pessoa> listPessoa) {
		this.listPessoa = listPessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
