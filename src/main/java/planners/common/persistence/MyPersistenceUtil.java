package planners.common.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyPersistenceUtil {
	private MyPersistenceUtil() {
		super();
	}

	public static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("jpabook");
	
	
	public static EntityManager createEntityManager() {
		return ENTITY_MANAGER_FACTORY.createEntityManager();
	}
}
