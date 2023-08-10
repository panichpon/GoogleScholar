package google.model;

import java.util.List;

public class GoogleScholarModel {
	private String name;
	private String depart;
	private String gooscholarId;
	private int total_citations_all;
	private int total_citations_six_y;
	private int hindex_all;
	private int hindex_six_y;
	private int i10_index_all;
	private int i10_index_six_y;
	private GoogleScholarCiteModel citations_per_year;
	private List<GoogleScholarPubModel> publications;

	public int getTotal_citations_all() {
		return total_citations_all;
	}

	public void setTotal_citations_all(int total_citations_all) {
		this.total_citations_all = total_citations_all;
	}

	public int getTotal_citations_six_y() {
		return total_citations_six_y;
	}

	public void setTotal_citations_six_y(int total_citations_six_y) {
		this.total_citations_six_y = total_citations_six_y;
	}

	public int getHindex_all() {
		return hindex_all;
	}

	public void setHindex_all(int hindex_all) {
		this.hindex_all = hindex_all;
	}

	public int getHindex_six_y() {
		return hindex_six_y;
	}

	public void setHindex_six_y(int hindex_six_y) {
		this.hindex_six_y = hindex_six_y;
	}

	public int getI10_index_all() {
		return i10_index_all;
	}

	public void setI10_index_all(int i10_index_all) {
		this.i10_index_all = i10_index_all;
	}

	public int getI10_index_six_y() {
		return i10_index_six_y;
	}

	public void setI10_index_six_y(int i10_index_six_y) {
		this.i10_index_six_y = i10_index_six_y;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getGooscholarId() {
		return gooscholarId;
	}

	public void setGooscholarId(String gooscholarId) {
		this.gooscholarId = gooscholarId;
	}

	public GoogleScholarCiteModel getCitations_per_year() {
		return citations_per_year;
	}

	public void setCitations_per_year(GoogleScholarCiteModel citations_per_year) {
		this.citations_per_year = citations_per_year;
	}

	public List<GoogleScholarPubModel> getPublications() {
		return publications;
	}

	public void setPublications(List<GoogleScholarPubModel> publications) {
		this.publications = publications;
	}

	@Override
	public String toString() {
		return "GoogleScholarModel [name=" + name + ", depart=" + depart + ", gooscholarId=" + gooscholarId
				+ ", total_citations_all=" + total_citations_all + ", total_citations_six_y=" + total_citations_six_y
				+ ", hindex_all=" + hindex_all + ", hindex_six_y=" + hindex_six_y + ", i10_index_all=" + i10_index_all
				+ ", i10_index_six_y=" + i10_index_six_y + ", citations_per_year=" + citations_per_year
				+ ", publications=" + publications + ", getTotal_citations_all()=" + getTotal_citations_all()
				+ ", getTotal_citations_six_y()=" + getTotal_citations_six_y() + ", getHindex_all()=" + getHindex_all()
				+ ", getHindex_six_y()=" + getHindex_six_y() + ", getI10_index_all()=" + getI10_index_all()
				+ ", getI10_index_six_y()=" + getI10_index_six_y() + ", getName()=" + getName() + ", getDepart()="
				+ getDepart() + ", getGooscholarId()=" + getGooscholarId() + ", getCitations_per_year()="
				+ getCitations_per_year() + ", getPublications()=" + getPublications() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
