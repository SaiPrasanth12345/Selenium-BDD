package general;

public class searchTextPojo {
	
	private String searchWord1;
	private String searchWord2;
	
	public searchTextPojo(String searchWord1, String searchWord2) {
		this.setSearchWord1(searchWord1);
		this.setSearchWord2(searchWord2);
	}

	public String getSearchWord1() {
		return searchWord1;
	}

	public void setSearchWord1(String searchWord1) {
		this.searchWord1 = searchWord1;
	}

	public String getSearchWord2() {
		return searchWord2;
	}

	public void setSearchWord2(String searchWord2) {
		this.searchWord2 = searchWord2;
	}

}
