package dao;

import models.Dependente;

public class DependenteDAO extends GenDAOJPA<Dependente> {
	
	public DependenteDAO() {
		this.entityClass = Dependente.class;
	}

}
