import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MoviesTest {

	public static void main(String[] args) {
		System.out.println("Wlecome to 'wish list' movie:-");
		MoviesTest movieTest = new MoviesTest();

		movieTest.showMenu();

		Scanner scan = new Scanner(System.in);
		try {
			int i = scan.nextInt();
			System.out.println(i);
			while (i > 0 && i < 7) {
				switch (i) {
				case 1:
					movieTest.insertMovie();
					movieTest.showMenu();
					break;
				case 2:
					movieTest.deleteMovie();
					
					movieTest.showMenu();
					break;
				case 3:
					movieTest.updateMovie();
					movieTest.showMenu();
					break;
				case 4:
					movieTest.showallMovie();
					movieTest.showMenu();
					break;
				case 5:
					movieTest.findMovieByTitle();
					movieTest.showMenu();
					break;
				case 6:
					movieTest.showMenu();
					break;
				}
				scan = new Scanner(System.in);
				i = scan.nextInt();
				System.out.println(i);

			}
		} catch (Exception c) {
			System.out.println("Error:-");
			System.out.println(c);
		}
		HibernateUtil.shutdown();
		System.out.println("Thanks for Using Wish list ");
	

	}

	private void findMovieByTitle() {
		System.out.println("Enter the moivie title which u want to find details \t");
		Scanner findInput = new Scanner(System.in);
		String title=findInput.next();
		 List<Movies>  allmovies=MoviesDAO.findMovieByTitle(title);
		if(allmovies==null||allmovies.size()<1){
			 System.out.println("No movies are found on this title"+title);
		}else{
			 for (Movies movies : allmovies) {
				 System.out.print("Id:- "+movies.getId()+"\t");
				System.out.print("Title:- "+movies.getTitle()+"\t");
				System.out.print("getDirector:- "+movies.getDirector()+"\t");
				System.out.print("Sysnopsis:- "+movies.getSysnopsis()+"\t"+"\n");
				
			}
		}
		System.out.println();
	}

	private void showallMovie() {
		 List<Movies>  allmovies=MoviesDAO.fetachall();
		 for (Movies movies : allmovies) {
			 System.out.print("Id:- "+movies.getId()+"\t");
			System.out.print("Title:- "+movies.getTitle()+"\t");
			System.out.print("getDirector:- "+movies.getDirector()+"\t");
			System.out.print("Sysnopsis:- "+movies.getSysnopsis()+"\t"+"\n");
			
		}

	}
	
	private Movies findMovieById(Long id) {
		// TODO Auto-generated method stub
		return MoviesDAO.fetchById(id);
	}

	private void updateMovie() {
		 System.out.println("Enter the moivie Id which u want to movie detail \t");
			Scanner updateInput = new Scanner(System.in);
			Long id=updateInput.nextLong();
			Movies movies=findMovieById(id);
			if(movies==null){
				 System.out.println("No movies are found on this id"+id);
			}else{
				System.out.println(" Enter the new movie title:-");
				movies.setTitle(updateInput.next());
				System.out.println(" Enter the new movie Director name :-");
				movies.setDirector(updateInput.next());
				System.out.println(" Enter the new movie Sysnopsis :-");
				movies.setSysnopsis(updateInput.next());
				MoviesDAO.update(movies);
				System.out.println("Movie is updated successfully to wish list ");
				
			}
	}

	private void deleteMovie() {
		 System.out.println("Enter the moivie Id which u want to delete \t");
			Scanner deleteInput = new Scanner(System.in);
			Long id=deleteInput.nextLong();
			Movies movie=findMovieById(id);
			if(movie==null){
				 System.out.println("No movies are found on this id"+id);
			}else{
			System.out.println("Are you sure want to delete the movie of title-"+movie.getTitle()+" If yes ;Press Y or to Cancel Press N");
			String confirm=deleteInput.next();
			 if(confirm!=null && confirm.equalsIgnoreCase("Y")){
				 MoviesDAO.delete(movie); 
				 System.out.println("Movie deleted successfully");
			 }
			}
			
	}

	private void insertMovie() {
		Scanner insertInput = new Scanner(System.in);
		Movies movies = new Movies();
		System.out.println(" Enter the movie title:-");
		movies.setTitle(insertInput.next());
		System.out.println(" Enter the movie Director name :-");
		movies.setDirector(insertInput.next());
		System.out.println(" Enter the movie Sysnopsis :-");
		movies.setSysnopsis(insertInput.next());
		MoviesDAO.save(movies);
		System.out.println("Movie is added successfully to wish list ");
	}

	public void showMenu() {
		System.out.println(" Choose your option");
		System.out.println(" 1 for Insert new movie:-");
		System.out.println(" 2 for Delete movie:-");
		System.out.println(" 3 for update movie:-");
		System.out.println(" 4 for List all movie:-");
		System.out.println(" 5 for find the movie by title");
		System.out.println(" 6 for see menu");
		System.out.println(" press 0 or any key other than choice to  Exit app");
	}

}
