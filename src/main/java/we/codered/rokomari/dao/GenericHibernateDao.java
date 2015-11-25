package we.codered.rokomari.dao;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
@Scope("protoType")
public class GenericHibernateDao <T extends Serializable> extends AbstractHibernateDao<T> {
	
	
	

}
=======
@Scope("prototype")
public class GenericHibernateDao<T extends Serializable> 
						extends AbstractHibernateDao<T> {
	
}
>>>>>>> origin/master
