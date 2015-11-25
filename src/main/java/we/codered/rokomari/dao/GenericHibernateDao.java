package we.codered.rokomari.dao;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("protoType")
public class GenericHibernateDao <T extends Serializable> extends AbstractHibernateDao<T> {
	
	
	

}



