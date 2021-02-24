package view;

import dao.FuncionarioDAO;
import models.Funcionario;

import java.util.List;

public class CLI {

	public static void main(String[] args) {
//		DependenteDAO ddao = new DependenteDAO();
//		List<Object[]> res = ddao.beganWithNamedQuery("A");
//		List<Object[]> res = ddao.beganWithJPQL("A");
//		List<Object[]> res = ddao.beganWithNative("A");
//		for (Object[] oArr : res) {
//			System.out.println("Dep: " + (String) oArr[0] + "\n" +
//						       "Res: " + (String) oArr[1]);
//		}
//		ddao.close();

		FuncionarioDAO fdao = new FuncionarioDAO();
//		List<Funcionario> res = fdao.fromFuncionariosNamed();
//		List<Funcionario> res = fdao.fromFuncionariosCriteria();
//		List<Funcionario> res = fdao.fromFuncionariosJPQL();
//		for (Funcionario f : res) {
//			System.out.println(
//					"id: " + f.getId() + "\n" +
//					"matricula: " + f.getMatricula() + "\n" +
//					"cpf: " + f.getCpf() + "\n" +
//					"nome: " + f.getNome() + "\n" +
//					"telefone: " + f.getTelefone() + "\n" +
//					"Dependenetes: ");
//			f.getDependentes().forEach( dep -> System.out.print(dep.getNome() + "\n")
//			);
//		}

// Operação que falha
		fdao.beginTransaction();
		Funcionario f = new Funcionario();
		f.setCpf("64377264079");
		f.setMatricula((long)44659);
		f.setTelefone("69906079121");
		f.setNome("Bildo Bolseiro");

		try {
			fdao.insert(f);
		} catch (Exception e) {
			fdao.rollback();
		}
	}
}
