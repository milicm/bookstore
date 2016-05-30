package rs.fon.silab.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Milos Milic
 */
@Entity
@Table(name = "author")
public class Author implements Serializable {

	private static final long serialVersionUID = 5439021203188544398L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Size(max = 100)
	@Column
	private String name;
	@Size(max = 100)
	@Column
	private String lastname;
	@OneToMany(mappedBy = "author")
	private List<Book> bookList;

	public Author() {
		bookList = new LinkedList<>();
	}

	public Author(String name, String lastname, List<Book> bookList) {
		this.name = name;
		this.lastname = lastname;
		this.bookList = bookList;
	}

	public Author(String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
		this.bookList = new LinkedList<>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Author)) {
			return false;
		}
		Author other = (Author) obj;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", lastname=" + lastname + "]";
	}

}
