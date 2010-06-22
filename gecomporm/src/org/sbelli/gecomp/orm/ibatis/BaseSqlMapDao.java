package org.sbelli.gecomp.orm.ibatis;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 * 
 * @author sbelli
 *
 */
public class BaseSqlMapDao extends SqlMapClientTemplate {
	protected static final int PAGE_SIZE = 4;
}
