package model;

public class Education {
    private String school;
    private String year;
    private String degree;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? "" : school;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? "" : year;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree == null ? "" : degree;
    }
}