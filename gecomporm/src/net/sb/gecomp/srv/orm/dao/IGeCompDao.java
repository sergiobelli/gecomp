package net.sb.gecomp.srv.orm.dao;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.GecompModelObject;

public interface IGeCompDao<T extends GecompModelObject> {

	void delete (Long id) throws GeCompOrmException;
	
	T get (Long id) throws GeCompOrmException;
	
	T insert (T object) throws GeCompOrmException;
	
	List<T> list () throws GeCompOrmException;
	
	void update (T object) throws GeCompOrmException;

	String GET_ATLETA = "Atleta.selectAtleta";
	String LIST_ATLETA = "Atleta.listAtleta";
	String INSERT_ATLETA = "Atleta.insertAtleta";
	String UPDATE_ATLETA = "Atleta.updateAtleta";
	String DELETE_ATLETA = "Atleta.deleteAtleta";

	String GET_CATEGORIA = "Categoria.selectCategoria";
	String LIST_CATEGORIA = "Categoria.listCategoria";
	String INSERT_CATEGORIA = "Categoria.insertCategoria";
	String UPDATE_CATEGORIA = "Categoria.updateCategoria";
	String DELETE_CATEGORIA = "Categoria.deleteCategoria";
	
	String GET_CATEGORIA_GARA 		= "CategoriaGara.selectCategoriaGara";
	String LIST_CATEGORIA_GARA 		= "CategoriaGara.listCategoriaGara";
	String LIST_CATEGORIA_GARA_4_GARA = "CategoriaGara.listCategoriaGara4Gara";
	String INSERT_CATEGORIA_GARA 		= "CategoriaGara.insertCategoriaGara";
	String UPDATE_CATEGORIA_GARA 		= "CategoriaGara.updateCategoriaGara";
	String DELETE_CATEGORIA_GARA 		= "CategoriaGara.deleteCategoriaGara";
	
	String GET_COMPETIZIONE = "Competizione.selectCompetizione";
	String LIST_COMPETIZIONE = "Competizione.listCompetizione";
	String INSERT_COMPETIZIONE = "Competizione.insertCompetizione";
	String UPDATE_COMPETIZIONE = "Competizione.updateCompetizione";
	String DELETE_COMPETIZIONE = "Competizione.deleteCompetizione";
	
	String GET_GARA = "Gara.selectGara";
	String LIST_GARA = "Gara.listGara";
	String LIST_GARA_COMPETIZIONE = "Gara.listGaraCompetizione";
	String INSERT_GARA = "Gara.insertGara";
	String UPDATE_GARA = "Gara.updateGara";
	String DELETE_GARA = "Gara.deleteGara";
	
	String GET_ISCRIZIONE = "Iscrizione.selectIscrizione";
	String LIST_ISCRIZIONE = "Iscrizione.listIscrizione";
	String LIST_ISCRIZIONE_GARA = "Iscrizione.listIscrizioneGara";
	String LIST_ISCRIZIONE_COMPETIZIONE = "Iscrizione.listIscrizioneCompetizione";
	String INSERT_ISCRIZIONE = "Iscrizione.insertIscrizione";
	String UPDATE_ISCRIZIONE = "Iscrizione.updateIscrizione";
	String DELETE_ISCRIZIONE = "Iscrizione.deleteIscrizione";
	
	String GET_PRESTAZIONE = "Prestazione.selectPrestazione";
	String LIST_PRESTAZIONE = "Prestazione.listPrestazione";
	String LIST_PRESTAZIONE_GARA = "Prestazione.listPrestazioneGara";
	String INSERT_PRESTAZIONE = "Prestazione.insertPrestazione";
	String UPDATE_PRESTAZIONE = "Prestazione.updatePrestazione";
	String DELETE_PRESTAZIONE = "Prestazione.deletePrestazione";
	
	
	String GET_PROPERTIES = "Properties.selectProperties";
	String LIST_PROPERTIES = "Properties.listProperties";
	String INSERT_PROPERTIES = "Properties.insertProperties";
	String UPDATE_PROPERTIES = "Properties.updateProperties";
	String DELETE_PROPERTIES = "Properties.deleteProperties";
	
	String GET_SOCIETA = "Societa.selectSocieta";
	String LIST_SOCIETA = "Societa.listSocieta";
	String INSERT_SOCIETA = "Societa.insertSocieta";
	String UPDATE_SOCIETA = "Societa.updateSocieta";
	String DELETE_SOCIETA = "Societa.deleteSocieta";

	String GET_TIPO_MISURA = "TipoMisura.select";
	String LIST_TIPO_MISURA = "TipoMisura.list";
	String INSERT_TIPO_MISURA = "TipoMisura.insert";
	String UPDATE_TIPO_MISURA = "TipoMisura.update";
	String DELETE_TIPO_MISURA = "TipoMisura.delete";
	
	String GET_TIPO_PRESTAZIONE = "TipoPrestazione.select";
	String LIST_TIPO_PRESTAZIONE = "TipoPrestazione.list";
	String INSERT_TIPO_PRESTAZIONE = "TipoPrestazione.insert";
	String UPDATE_TIPO_PRESTAZIONE = "TipoPrestazione.update";
	String DELETE_TIPO_PRESTAZIONE = "TipoPrestazione.delete";
	
	String GET_USER = "User.selectUser";
	String LIST_USER = "User.listUser";
	String INSERT_USER = "User.insertUser";
	String UPDATE_USER = "User.updateUser";
	String DELETE_USER = "User.deleteUser";

}
