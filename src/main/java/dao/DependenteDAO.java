package dao;

import models.Dependente;
import models.Funcionario;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class DependenteDAO extends GenDAOJPA<Dependente> {
	
	public DependenteDAO() {
		this.entityClass = Dependente.class;
	}

	//testei
	public List beganWithNative(String letter) {
		String sql = "SELECT d.nome as col1, f.nome as col2 FROM dependentes d, funcionarios f " +
				"WHERE d.nome LIKE ? AND d.funcionario_id = f.id";
		Query query = getEm().createNativeQuery(sql);
		query.setParameter(1, letter + '%');
		return (List<Object[]>) query.getResultList();

	}

	//testei
	public List beganWithNamedQuery(String letter) {
		return getEm().createNamedQuery("Dependente.NomeResponsavel")
			   .setParameter("letter", letter + "%")
			   .getResultList();
	}

	// não consegui implementar
	public List beganWithCriteria(String letter) {
		return null;
	}

	//testei
	public List beganWithJPQL(String letter) {
		Query q = getEm().createQuery("select d.nome, f.nome from Dependente d, Funcionario f " +
				"where d.nome like :letter and d.funcionario.id = f.id");
		q.setParameter("letter", letter + "%");
		return q.getResultList();
	}

}
