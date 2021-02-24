package models;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table ( name = "dependentes" )
@NamedQuery(
		name = "Dependente.NomeResponsavel",
		query = "SELECT d.nome, f.nome " +
				"FROM Dependente d, Funcionario f " +
				"WHERE d.nome LIKE :letter AND d.funcionario.id = f.id")
public class Dependente implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column ( nullable=false, unique=true, length=11 )
	@Size ( min = 11, max = 11 )
	private String cpf;
	
	@Column ( nullable=false )
	private String nome;
	
	@ManyToOne
	@JoinColumn ( name = "funcionario_id" )
	private Funcionario funcionario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dependente other = (Dependente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dependente [id=" + id + ", cpf=" + cpf + ", nome=" + nome + "]";
	}
}
