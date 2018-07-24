package com.kaveinga.interview.professor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.kaveinga.interview.utility.ObjectUtil;

@JsonInclude(value = Include.NON_NULL)
@Entity
@Table(name = "profesor")
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "rank")
	private String rank;
	
	@Column(name = "discipline")
	private String discipline;
	
	@Column(name = "yrs_with_phd")
	private Integer yrsWithPhd;
	
	@Column(name = "yrs_service")
	private Integer yrsService;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "salary")
	private Double salary;
	
	public Professor() {
		this(null,null,null,null,null,null,null,null);
	}

	public Professor(Long id, String name, String rank, String discipline, Integer yrsWithPhd, Integer yrsService,
			String sex, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.rank = rank;
		this.discipline = discipline;
		this.yrsWithPhd = yrsWithPhd;
		this.yrsService = yrsService;
		this.sex = sex;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public Integer getYrsWithPhd() {
		return yrsWithPhd;
	}

	public void setYrsWithPhd(Integer yrsWithPhd) {
		this.yrsWithPhd = yrsWithPhd;
	}

	public Integer getYrsService() {
		return yrsService;
	}

	public void setYrsService(Integer yrsService) {
		this.yrsService = yrsService;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public String toJson() {
		try {
			return ObjectUtil.getObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			System.out.println("JsonProcessingException, msg: " + e.getLocalizedMessage());
			return "{}";
		}
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.id).toHashCode();

		// return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Professor other = (Professor) obj;
		return new EqualsBuilder().append(this.id, other.id).isEquals();

		// return EqualsBuilder.reflectionEquals(this, obj);
	}
}
