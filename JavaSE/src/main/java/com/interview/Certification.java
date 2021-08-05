package com.interview;

public class Certification {
	private int certificationId;
	private String techPlatform;

	public Certification(int certificationId, String techPlatform) {
		this.certificationId = certificationId;
		this.techPlatform = techPlatform;
	}

	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

	public String getTechPlatform() {
		return techPlatform;
	}

	public void setTechPlatform(String techPlatform) {
		this.techPlatform = techPlatform;
	}

}
