package emlakcepte.model;

public class SearchHistory {
    private String searchName;
    private String province;
    private String district;
    private User user;

    public SearchHistory(){

    }

    public SearchHistory(String searchName, String province, String district, User user) {
        this.searchName = searchName;
        this.province = province;
        this.district = district;
        this.user = user;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
