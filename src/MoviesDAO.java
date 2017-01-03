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

	public static Movies fetchById(Long id) {
		// TODO Auto-generated method stub
		  Session session = sessionFactory.openSession();

		  session.beginTransaction();

		  Movies movie=(Movies) session.get(Movies.class,id);

		  session.getTransaction().commit();
		  session.close();
		return movie;
	}

	public static List<Movies>  findMovieByTitle(String title) {
		 Session session = sessionFactory.openSession();

		  session.beginTransaction();
		 
		  Query query=session.getNamedQuery("findMovieByTitle");
		  query.setString("title",title);  
		  query.setCacheable(true);
		  List<Movies>  allmovies=query.list();
		  session.getTransaction().commit();
		  session.close();
		  return allmovies;
	
	}

	public static void update(Movies movies) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.openSession();

		  session.beginTransaction();

		  session.update(movies);

		  session.getTransaction().commit();
		  session.close();
	}
	
}
