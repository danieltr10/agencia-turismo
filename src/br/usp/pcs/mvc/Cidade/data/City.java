package br.usp.pcs.mvc.Cidade.data;

public class City {

	private int id;
	private String name;
	private String description;
	private String province;
	private String country;
    private String imageURL;
	private double distanciaOrigem;
	private double latitude;
	private double longitude;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) { 
		this.id = id;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public double getDistanciaOrigem() {
		return distanciaOrigem;
	}

	public void setDistanciaOrigem(double distanciaOrigem) {
		this.distanciaOrigem = distanciaOrigem;
	}
}
