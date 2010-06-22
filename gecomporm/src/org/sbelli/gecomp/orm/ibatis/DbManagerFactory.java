package org.sbelli.gecomp.orm.ibatis;

import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.orm.dao.AtletaDao;
import org.sbelli.gecomp.orm.dao.CategoriaDao;
import org.sbelli.gecomp.orm.dao.CategoriaGaraDao;
import org.sbelli.gecomp.orm.dao.CompetizioneDao;
import org.sbelli.gecomp.orm.dao.GaraDao;
import org.sbelli.gecomp.orm.dao.IscrizioneDao;
import org.sbelli.gecomp.orm.dao.PrestazioneDao;
import org.sbelli.gecomp.orm.dao.PropertiesDao;
import org.sbelli.gecomp.orm.dao.SocietaDao;
import org.sbelli.gecomp.orm.dao.TipoMisuraDao;
import org.sbelli.gecomp.orm.dao.TipoPrestazioneDao;
import org.sbelli.gecomp.orm.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DbManagerFactory {

	protected static GeCompLogger logger = GeCompLogger.getGeCompLogger(DbManagerFactory.class);
	
	private static ApplicationContext applicationContext = null;
	
	private static DbManagerFactory instance = null;
	protected DbManagerFactory() {
		logger.info("Start DbManagerFactory Spring System Initialization...");
		
		String[] files = {"classpath:org/sbelli/gecomp/orm/ibatis/gecomp_orm_context.xml"};
		logger.debug("files="+files);
		
		applicationContext = new ClassPathXmlApplicationContext(files);
		logger.debug("applicationContext="+applicationContext);
		
		logger.info("End DbManagerFactory Spring System Initialization...");		
	}
	public static synchronized DbManagerFactory getInstance() {
		try {
			if (Eval.isNull(instance)) {
				instance = new DbManagerFactory();
			}
			return instance;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex,ex);
			return null;
		}
	}
	
	public final DbManager getDbManager () {return (DbManager) applicationContext.getBean("DbManager");}
	
	
	/*
	 * Tabelle
	 */	
	public final AtletaDao 					getAtletaDao() 					{return (AtletaDao) 				applicationContext.getBean("AtletaDao");				} 	
	public final CategoriaGaraDao 			getCategoriaGaraDao() 			{return (CategoriaGaraDao) 			applicationContext.getBean("CategoriaGaraDao");			}
	public final CategoriaDao 				getCategoriaDao() 				{return (CategoriaDao) 				applicationContext.getBean("CategoriaDao");				}
	public final CompetizioneDao 			getCompetizioneDao() 			{return (CompetizioneDao) 			applicationContext.getBean("CompetizioneDao");			}
	public final GaraDao 					getGaraDao() 					{return (GaraDao) 					applicationContext.getBean("GaraDao");					}
	public final IscrizioneDao 				getIscrizioneDao() 				{return (IscrizioneDao) 			applicationContext.getBean("IscrizioneDao");			}
	public final PrestazioneDao 			getPrestazioneDao() 			{return (PrestazioneDao) 			applicationContext.getBean("PrestazioneDao");			}
	public final TipoPrestazioneDao 		getTipoPrestazioneDao() 		{return (TipoPrestazioneDao) 		applicationContext.getBean("TipoPrestazioneDao");		}
	public final TipoMisuraDao 				getTipoMisuraDao() 				{return (TipoMisuraDao) 			applicationContext.getBean("TipoMisuraDao");			}
	public final PropertiesDao 				getPropertiesDao() 				{return (PropertiesDao) 			applicationContext.getBean("PropertiesDao");			}	
	public final SocietaDao 				getSocietaDao() 				{return (SocietaDao) 				applicationContext.getBean("SocietaDao");				}
	public final UserDao 					getUserDao() 					{return (UserDao) 					applicationContext.getBean("UserDao");					}
}
