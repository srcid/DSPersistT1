package view;

import dao.DependenteDAO;
import dao.FuncionarioDAO;
import models.Dependente;
import models.Funcionario;

public class CLI {

	public static void main(String[] args) {

		FuncionarioDAO fdao = new FuncionarioDAO();
		Funcionario f = new Funcionario();
		f = fdao.getById(new Long(1));
		System.out.println(f.toString());

		DependenteDAO ddao = new DependenteDAO();
		Dependente d = new Dependente();
		d.setCpf("27547426034");
		d.setNome("Bilbo Bolseiro da Silva");
		d.setFuncionario(f);
		ddao.beginTransaction();
		ddao.insert(d);
		ddao.commit();
		ddao.close();

//		FuncionarioDAO fdao = new FuncionarioDAO();
//		Funcionario f = new Funcionario();
//		f.setMatricula((long)3_154_564);
//		f.setCpf("00000000000");
//		f.setNome("Cicrano");
//		f.setTelefone("11911111111");
//		fdao.beginTransaction();
//		fdao.insert(f);
//		fdao.commit();
//		fdao.close();
//
	}

}
