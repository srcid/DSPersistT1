package view;

import dao.FuncionarioDAO;
import models.Funcionario;

public class CLI {

	public static void main(String[] args) {
		
		FuncionarioDAO fdao = new FuncionarioDAO();
		Funcionario f = new Funcionario();
		f.setCpf("00000000000");
		f.setNome("Cicrano");
		f.setTelefone("88981245550");
		fdao.beginTransaction();
		fdao.insert(f);
		fdao.commit();
		fdao.close();
		
	}

}
