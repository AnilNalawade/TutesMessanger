package com.app.pojo;
// Generated 18 Sep, 2017 4:17:49 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Division generated by hbm2java
 */
@Entity
@Table(name = "division", catalog = "tutesmessanger")
public class Division implements java.io.Serializable {

	private Integer id;
	private Classes classes;
	private String name;
	private Set<Schedule> schedules = new HashSet<Schedule>(0);

	public Division() {
	}


	public Division(Classes classes, String name, Set<Schedule> schedules) {
		this.classes = classes;
		this.name = name;
		this.schedules = schedules;
	}

	public Division(Integer id, Classes classes, String name) {
		super();
		this.id = id;
		this.classes = classes;
		this.name = name;
	}

	public Division(Classes classes, String name) {
		super();
		this.classes = classes;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classid")
	public Classes getClasses() {
		return this.classes;
	}

	@Override
	public String toString() {
		return "Division [id=" + id + ", classes=" + classes + ", name=" + name + "]";
	}


	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "division")
	public Set<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(Set<Schedule> schedules) {
		this.schedules = schedules;
	}
	

}
