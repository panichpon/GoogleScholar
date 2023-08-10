package google.model;

public class GoogleScholarPubModel {
	private String title;
	private String authors;
	private String venue;
	private int citations;
	private String year;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getCitations() {
		return citations;
	}

	public void setCitations(int citations) {
		this.citations = citations;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "GoogleScholarPubModel [title=" + title + ", authors=" + authors + ", venue=" + venue + ", citations="
				+ citations + ", year=" + year + ", getTitle()=" + getTitle() + ", getAuthors()=" + getAuthors()
				+ ", getVenue()=" + getVenue() + ", getCitations()=" + getCitations() + ", getYear()=" + getYear()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
