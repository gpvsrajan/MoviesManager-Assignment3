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
			while (i > 0 && i < 6) {
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
					movieTest.showMenu();
					break;
				}
				scan = new Scanner(System.in);
				i = scan.nextInt();
				System.out.println(i);

			}
		} catch (Exception c) {

		}

		System.out.println("Thanks for Using Wish list ");
		/*
		 * Movies movies = new Movies(); movies.setDirectory("Tony Scott 2");
		 * movies.setSysnopsis("When Maverick encounters a pair of MiGs");
		 * movies.setTitle("Top Gun 2"); MoviesDAO.save(movies);
		 */

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

	private void updateMovie() {
		

	}

	private void deleteMovie() {
		

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
		System.out.println(" 5 for see menu");
		System.out.println(" press 0 or any key other than choice to  Exit app");
	}

}
