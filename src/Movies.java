import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.GenericGenerator;
@NamedQueries(  
	    {  
	        @NamedQuery(
	name = "findMovieByTitle",
	query = "From Movies s where s.title = :title"
	)
})
@Entity

public class Movies {
	
	@Id
	/*@GenericGenerator(name="kaugen" , strategy="increment")
	@GeneratedValue(generator="kaugen")	*/
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	Long id;
	
	@Column
	String title;
	@Column
	String director;
	@Column(length = 255)
	String sysnopsis;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getSysnopsis() {
		return sysnopsis;
	}
	public void setSysnopsis(String sysnopsis) {
		this.sysnopsis = sysnopsis;
	}
	
	
	
	
}
