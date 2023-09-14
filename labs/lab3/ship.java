public class ship{
    private String name;
    private String yearBuilt;

    // Constructors for out arguments

    public ship(String name, String yearBuilt) {
        this.name = name;
        this.yearBuilt = yearBuilt;
    }
    // Getters and setters for ship name and year built
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }
}
