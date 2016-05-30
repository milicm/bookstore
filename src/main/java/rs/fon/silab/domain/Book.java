package rs.fon.silab.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Milos Milic
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {

	private static final long serialVersionUID = -2811661443439950990L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Size(max = 100)
	@Column
	private String title;
	@Column
	private Integer year;
	@Size(max = 50)
	@Column
	private String isbn;
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	@ManyToOne
	private Author author;

	public Book() {
	}

	public Book(String title, Integer year, String isbn, Author author) {
		this.title = title;
		this.year = year;
		this.isbn = isbn;
		this.author = author;
	}

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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthorId(Author author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Book)) {
			return false;
		}
		Book other = (Book) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", year=" + year + ", isbn=" + isbn + ", author=" + author + "]";
	}

}
