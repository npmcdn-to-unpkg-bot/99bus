package org.hopen.core;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;

public class SysHibernateTransactionManager extends HibernateTransactionManager {

	Logger logger = Logger.getLogger(this.getClass());
	private static final long serialVersionUID = 1L;
    @Override
    protected void prepareForCommit(DefaultTransactionStatus status) {
    	// TODO Auto-generated method stub
    	logger.debug("transation:prepareForCommit");
    	super.prepareForCommit(status);
    }
    @Override
    protected void doCommit(DefaultTransactionStatus arg0) {
    	// TODO Auto-generated method stub
    	logger.debug("transation:doCommit");
    	super.doCommit(arg0);
    }
    @Override
    protected void doBegin(Object arg0, TransactionDefinition arg1) {
    	// TODO Auto-generated method stub
    	logger.debug("transation:doBegin");
    	super.doBegin(arg0, arg1);
    }
}
