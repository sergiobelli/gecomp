package org.sbelli.gecomp.orm.model;

public class CategoriaGara extends GecompModelObject {

	public CategoriaGara() {}
	public CategoriaGara(Categoria categoria, Gara gara) {
		setCategoria(categoria);
		setGara(gara);
	}
	private Long idCategoriaGara;
	public Long getIdCategoriaGara() {return idCategoriaGara;}
	public void setIdCategoriaGara(Long idCategoriaCompetizione) {this.idCategoriaGara = idCategoriaCompetizione;}
	
	private Categoria categoria;
	public Categoria getCategoria() {return categoria;}
	public void setCategoria(Categoria categoria) {this.categoria = categoria;}
	
	private Gara gara;
	public Gara getGara() {return gara;}
	public void setGara(Gara gara) {this.gara = gara;}
	
	private CategoriaGaraAssoluta categoriaGaraAssoluta;
	public CategoriaGaraAssoluta getCategoriaGaraAssoluta() {return categoriaGaraAssoluta;}
	public void setCategoriaGaraAssoluta(CategoriaGaraAssoluta categoriaGaraAssoluta) {this.categoriaGaraAssoluta = categoriaGaraAssoluta;}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaGara other = (CategoriaGara) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (categoriaGaraAssoluta == null) {
			if (other.categoriaGaraAssoluta != null)
				return false;
		} else if (!categoriaGaraAssoluta.equals(other.categoriaGaraAssoluta))
			return false;
		if (gara == null) {
			if (other.gara != null)
				return false;
		} else if (!gara.equals(other.gara))
			return false;
		if (idCategoriaGara == null) {
			if (other.idCategoriaGara != null)
				return false;
		} else if (!idCategoriaGara.equals(other.idCategoriaGara))
			return false;
		return true;
	}
	
	
		
}
