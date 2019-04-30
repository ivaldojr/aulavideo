package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_link")
@SequenceGenerator(name = "SEQ_LINK", sequenceName = "SEQ_LINK", initialValue=1, allocationSize=1)
public class Link implements Serializable{

	
	@Id
	@GeneratedValue(generator = "SEQ_LINK", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="titulo")
	private String tituloVideo;
	
	@Column(name="url")
	private String url;
	
	
	
	public Link() {
		
	}
	
	public Link(Long id, String tituloVideo, String url) {
		super();
		this.id = id;
		this.tituloVideo = tituloVideo;
		this.url = url;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTituloVideo() {
		return tituloVideo;
	}
	public void setTituloVideo(String tituloVideo) {
		this.tituloVideo = tituloVideo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tituloVideo == null) ? 0 : tituloVideo.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Link other = (Link) obj;
		if (tituloVideo == null) {
			if (other.tituloVideo != null)
				return false;
		} else if (!tituloVideo.equals(other.tituloVideo))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	
	
	
	
}
