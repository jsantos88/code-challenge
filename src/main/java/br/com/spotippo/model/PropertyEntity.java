package br.com.spotippo.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/*
   Um imóvel em Spotippos tem as seguintes características:
		No máximo 5 quartos (beds), e no mínimo 1
		No máximo 4 banheiros (baths), e no mínimo 1
		No máximo 240 metros quadrados, e no mínimo 20 
*/
@Entity
public class PropertyEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotNull
	private String title;
	
	@Column
	@NotNull
	private BigDecimal price;
	
	@Column
	@NotNull
	private String description;
	
	@Column
	@NotNull
	@Min(0)
	@Max(1400)
	private Integer x;
	
	@Column
	@NotNull
	@Min(0)
	@Max(1000)
	private Integer y;
	
	@Column
	@NotNull
	@Min(1)
	@Max(5)
	private Integer beds;
	
	@Column
	@NotNull
	@Min(1)
	@Max(4)
	private Integer baths;
	
	@Column
	@NotNull
	@Min(20)
	@Max(240)
	private Integer squareMeters;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="properties_provinces", joinColumns={@JoinColumn(name="id_property", referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(name="id_province", referencedColumnName="id")})
	private List<ProvinceEntity> provinces;
	
	public List<ProvinceEntity> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<ProvinceEntity> provinces) {
		this.provinces = provinces;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getBeds() {
		return beds;
	}

	public void setBeds(Integer beds) {
		this.beds = beds;
	}

	public Integer getBaths() {
		return baths;
	}

	public void setBaths(Integer baths) {
		this.baths = baths;
	}

	public Integer getSquareMeters() {
		return squareMeters;
	}

	public void setSquareMeters(Integer squareMeters) {
		this.squareMeters = squareMeters;
	}

}
