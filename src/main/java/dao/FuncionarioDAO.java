package dao;

import models.Funcionario;

public class FuncionarioDAO extends GenDAOJPA<Funcionario> {
	
	public FuncionarioDAO() {
		this.entityClass = Funcionario.class;
	}
}
