package net.sb.gecomp.srv.orm.ibatis;

import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.AtletaDao;
import net.sb.gecomp.srv.orm.dao.CategoriaDao;
import net.sb.gecomp.srv.orm.dao.CategoriaGaraDao;
import net.sb.gecomp.srv.orm.dao.CompetizioneDao;
import net.sb.gecomp.srv.orm.dao.GaraDao;
import net.sb.gecomp.srv.orm.dao.IscrizioneDao;
import net.sb.gecomp.srv.orm.dao.PrestazioneDao;
import net.sb.gecomp.srv.orm.dao.PropertiesDao;
import net.sb.gecomp.srv.orm.dao.SocietaDao;
import net.sb.gecomp.srv.orm.dao.TipoMisuraDao;
import net.sb.gecomp.srv.orm.dao.TipoPrestazioneDao;
import net.sb.gecomp.srv.orm.dao.UserDao;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DbManagerFactory {

	protected static Logger logger = Logger.getLogger(DbManagerFactory.class.getName());
	
	private static ApplicationContext applicationContext = null;
	
	private static DbManagerFactory instance = null;
	protected DbManagerFactory() {
		logger.info("Start DbManagerFactory Spring System Initialization...");
		
		String[] files = {"classpath:net/sb/gecomp/srv/orm/ibatis/gecomp_orm_context.xml"};
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
