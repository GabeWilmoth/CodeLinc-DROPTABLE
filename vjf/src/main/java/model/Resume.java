package model;

public class Resume {
    private PersonalInformation personalInformation;
    private Experience[] experiences;
    private Education[] educations;
    private String[] skills;

    public PersonalInformation getPersonalInfo() {
        return personalInformation;
    }

    public void setPersonalInfo(PersonalInformation personalInfo) {
        this.personalInformation = personalInfo;
    }

    public Experience[] getExperiences() {
        return experiences;
    }

    public void setExperiences(Experience[] experiences) {
        this.experiences = experiences;
    }

    public Education[] getEducations() {
        return educations;
    }

    public void setEducations(Education[] educations) {
        this.educations = educations;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }
}