package dao;

import models.Dependente;
import models.Funcionario;
import org.hibernate.Criteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class FuncionarioDAO extends GenDAOJPA<Funcionario> {
	
	public FuncionarioDAO() {
		this.entityClass = Funcionario.class;
	}

	public List fromFuncionariosNative() {
		String sql = "SELECT * FROM funcionarios";
		return getEm().createNamedQuery(sql).getResultList();
	}

	public List fromFuncionariosNamed() {
		return getEm().createNamedQuery("Funcionario.Tudo", Funcionario.class).getResultList();
	}

	public List fromFuncionariosJPQL() {
		return getEm().createQuery(
				"SELECT f FROM Funcionario f").getResultList();
	}

	public List fromFuncionariosCriteria() {
		return null;
	}
}
