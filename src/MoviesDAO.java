import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MoviesDAO {

	 private static SessionFactory sessionFactory;
	 static {
	  sessionFactory = HibernateUtil.getSessionFactory();
	 }

	 public static Movies save(Movies movie) {
	  Session session = sessionFactory.openSession();

	  session.beginTransaction();

	  session.save(movie);

	  session.getTransaction().commit();
	  session.close();
	  return movie;
	 }

	 public static void delete(Movies movie) {
	  Session session = sessionFactory.openSession();

	  session.beginTransaction();

	  session.delete(movie);

	  session.getTransaction().commit();
	  session.close();
	 }

	public static List<Movies> fetachall() {
		 Session session = sessionFactory.openSession();

		  session.beginTransaction();

		  Query query=session.createQuery("From Movies");
		  query.setCacheable(true);
		  List<Movies>  allmovies=query.list();
		  session.getTransaction().commit();
		  session.close();
		  return allmovies;
		
	}
	
}
