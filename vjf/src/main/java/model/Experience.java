package model;

public class Experience {
    private String company;
    private String startYear;
    private String endYear;
    private String jobTitle;
    private String[] comments;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? "" : company;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear == null ? "" : startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear == null ? "" : endYear;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? "" : jobTitle;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments == null ? new String[]{""} : comments;
    }
}