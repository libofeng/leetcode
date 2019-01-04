package com.oo.facebook;

import java.util.List;

public class Profile {
    private byte[] profilePicture;
    private byte[] coverPhotos;
    private String gender;

    private List<Work> workExperiences;
    private List<Education> educations;
    private List<Place> places;
    private List<State> stats;

    public boolean addWordExperience(Work work) {
        return true;
    }

    public boolean addEducation(Education education) {
        return true;
    }

    public boolean addState(State state) {
        return true;
    }
}
