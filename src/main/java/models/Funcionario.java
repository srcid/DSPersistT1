package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table ( name = "funcionarios" )
public class Funcionario implements Serializable {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column ( nullable=false, unique=true )
	@GeneratedValue ( strategy = GenerationType.SEQUENCE, generator = "funcionario_matricula_seq")
	@SequenceGenerator ( name = "funcionario_matricula_seq", sequenceName = "fm_seq")
	private Long matricula;
	
	@Column ( nullable=false, unique=true, length=11 )
	@Size (min = 11, max = 11)
	private String cpf;
	
	@Column ( nullable=false )
	private String nome;
	
	@Column ( nullable=false, length = 11 )
	@Size ( min = 10, max = 11 )
	private String telefone;
	
	@OneToMany ( mappedBy = "funcionario" )
	private List<Dependente> dependentes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", matricula=" + matricula + ", cpf=" + cpf + ", nome=" + nome + ", telefone="
				+ telefone + "]";
	}
}
