package kr.ac.kopo.boardHerbal.vo;

public class HerbalVO {

	private int medicineID;
	private String name;
	private String description;
	private String seasonalRecommendation;
	
	public HerbalVO(int medicineID, String name, String description, String seasonalRecommendation) {
		this.medicineID = medicineID;
		this.name = name;
		this.description = description;
		this.seasonalRecommendation = seasonalRecommendation;
	}
	
	public HerbalVO() {
	}

	public HerbalVO(String name, String description, String seasonalRecommendation) {
		this.name = name;
		this.description = description;
		this.seasonalRecommendation = seasonalRecommendation;
	}

	public int getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(int medicineID) {
		this.medicineID = medicineID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSeasonalRecommendation() {
		return seasonalRecommendation;
	}

	public void setSeasonalRecommendation(String seasonalRecommendation) {
		this.seasonalRecommendation = seasonalRecommendation;
	}

	@Override
	public String toString() {
		return "HerbalVO [medicineID=" + medicineID + ", name=" + name + ", description=" + description
				+ ", seasonalRecommendation=" + seasonalRecommendation + "]";
	}
	
	
}
