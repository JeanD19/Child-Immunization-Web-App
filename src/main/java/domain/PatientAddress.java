package domain;

public class PatientAddress {
    private String location;
    private String community;
    private int houseNo;

    /**
     * Parameterized Constructor for a patients address
     * @param location
     * @param community
     * @param houseNo
     */
    public PatientAddress(String location, String community, int houseNo) {
        this.community = community;
        this.location = location;
        this.houseNo = houseNo;
    }

    /**
     * Getter for patient address location
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setter for patient address location
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Getter for patient address community
     * @return community
     */
    public String getCommunity() {
        return community;
    }

    /**
     * Setter for patient address community
     * @param community
     */
    public void setCommunity(String community) {
        this.community = community;
    }

    /**
     * Getter for patient address house number
     * @return houseNo
     */
    public int getHouseNumber() {
        return houseNo;
    }

    /**
     * Setter for patient address house number
     * @param houseNo
     */
    public void setHouseNumber(int houseNo) {
        this.houseNo = houseNo;
    }


}
