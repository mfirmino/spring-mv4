package br.com.caelum.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	@RequestMapping("/form")
	public ModelAndView formulario() {
		ModelAndView mv = new ModelAndView("conta/formulario");
		return mv;
	}
	
	@RequestMapping("/adicionaConta")
	public ModelAndView adicionaConta(@Valid Conta conta, BindingResult result) {
		
		if(result.hasErrors()) {
			return formulario();
		}
		
		System.out.println("conta adiciona: " + conta.getDescricao());
		ContaDAO contaDao = new ContaDAO();
		contaDao.adiciona(conta);

		return lista();
	}
	
	@RequestMapping("/removeConta")
	public ModelAndView removeConta(Conta conta) {
		
		System.out.println("conta a ser removida: " + conta.getId());
		ContaDAO contaDao = new ContaDAO();
		contaDao.remove(conta);

		return lista();
	}
	
	@RequestMapping("/pagaConta")
	public void pagaConta(Conta conta, HttpServletResponse response){
		
		System.out.println("conta a ser paga: " + conta.getId());
		ContaDAO contaDao = new ContaDAO();
		contaDao.paga(conta.getId());
		
		response.setStatus(200);
	}
	
	@RequestMapping("/listaContas")
	public ModelAndView lista(){
		ContaDAO dao = new ContaDAO();
		List<Conta> contas = dao.lista();
		
		ModelAndView mv = new ModelAndView("conta/lista");
		mv.addObject("contas", contas);
		
		return mv;
	}
}
