package planner.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import planner.entity.Task;
import planner.enums.ProgressType;
import planners.common.persistence.MyPersistenceUtil;

@Service
public class TaskServiceImpl implements TaskService {
	
	private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

	@Override
	public void addNewTask(String name, ProgressType progressType) {
		EntityManager em = MyPersistenceUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		try {
			tx.begin(); //트랜잭션 시작
			Task task = new Task();
			em.persist(task);
			
			task.setName(name);
			task.setPercentage(0);
			task.setProgressType(progressType);
			
			tx.commit();//트랜잭션 커밋
		} catch (Exception e) {
//			e.printStackTrace();
			tx.rollback(); //트랜잭션 롤백
			throw e;
		} finally {
			em.close(); //엔티티 매니저 종료
		}
	}

	@Override
	public void editTask(int taskId, String name, ProgressType progressType) {
		EntityManager em = MyPersistenceUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		try {
			tx.begin(); //트랜잭션 시작
			
			
			Task task = em.find(Task.class, taskId);
			
			task.setName(name);
			task.setPercentage(0);
			task.setProgressType(progressType);
			
			tx.commit();//트랜잭션 커밋
		} catch (Exception e) {
//			e.printStackTrace();
			tx.rollback(); //트랜잭션 롤백
			throw e;
		} finally {
			em.close(); //엔티티 매니저 종료
		}

	}

	@Override
	public List<Task> getTaskList() {
		EntityManager em = MyPersistenceUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
		try {
			List<Task> result = em.createQuery("select t from planner.entity.Task t").getResultList();
			
			return result;
		} catch (Exception e) {
			logger.error("failed", e);
			throw e;
		} finally {
			em.close(); //엔티티 매니저 종료
		}
	}


}
