package view;

import dao.DependenteDAO;
import dao.FuncionarioDAO;
import models.Dependente;
import models.Funcionario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Povoador {

    public void fgen() {
        File f = new File("/home/alcides/IdeaProjects/dados_func.csv");
        FuncionarioDAO fdao = new FuncionarioDAO();
        FileInputStream fis = null;
        Scanner scanner = null;

        try {
            fis = new FileInputStream(f);
            scanner = new Scanner(fis);
            List<String> dados;

            scanner.nextLine(); // Eliminadno cabeçario
            fdao.beginTransaction();
            while (scanner.hasNext()) {
                dados = Arrays.asList(scanner.nextLine().split(","));
                Funcionario func = new Funcionario();
                func.setCpf(dados.get(0));
                func.setMatricula(Long.parseLong(dados.get(1)));
                func.setNome(dados.get(2));
                func.setTelefone(dados.get(3));

                fdao.insert(func);
            }
            fdao.commit();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (scanner != null)
                scanner.close();
        }
        fdao.close();
    }

    public void dgen() {
        File f = new File("/home/alcides/IdeaProjects/dados_dep.csv");
        DependenteDAO ddao = new DependenteDAO();
        FuncionarioDAO fdao = new FuncionarioDAO();
        FileInputStream fis = null;
        Scanner scanner = null;

        try {
            fis = new FileInputStream(f);
            scanner = new Scanner(fis);

            scanner.nextLine(); // Eliminadno cabeçario

            fdao.beginTransaction();
            while (scanner.hasNext()) {
                String[] dados = scanner.nextLine().split(",");
                Dependente d = new Dependente();
                d.setCpf(dados[0]);
                d.setNome(dados[1]);
                d.setFuncionario(
                        fdao.getById(
                                Long.parseLong(dados[2])
                        )
                );
                ddao.insert(d);
            }
            fdao.commit();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ddao.close();
        scanner.close();
    }
}
