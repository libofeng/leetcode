package com.company.indeed;

import java.util.*;

public class ProfileSystem {
    class Profile {
        String id;
        int version;
        Map<Integer, Map<String, String>> versionToMap;

        public Profile(String id) {
            this.id = id;
            this.version = 1;
            versionToMap = new HashMap<>();
            versionToMap.put(1, new HashMap<>());
        }
    }

    Map<String, Profile> profiles;

    public ProfileSystem() {
        profiles = new HashMap<>();
    }

    public void update(String profileId, String field, String value) {
        if (!profiles.containsKey(profileId)) {
            Profile profile = new Profile(profileId);
            profile.versionToMap.get(profile.version).put(field, value);
            profiles.put(profileId, profile);
        } else {
            Profile profile = profiles.get(profileId);
            Map<String, String> fields = profile.versionToMap.get(profile.version);
            if (fields.containsKey(field)) {
                profile.versionToMap.put(profile.version + 1, new HashMap<>(fields));
                profile.version++;
                profile.versionToMap.get(profile.version).put(field, fields.get(field) + ", " + value);
            } else {
                fields.put(field, value);
            }
        }
    }

    public String get(String profileId, int version) {
        if (!profiles.containsKey(profileId)) return null;

        Profile profile = profiles.get(profileId);
        Map<String, String> fields = profile.versionToMap.get(version);
        return buildFieldsString(profileId, fields);
    }

    private String buildFieldsString(String profileId, Map<String, String> fields) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"" + profileId + "\": ");
        for (String field : fields.keySet()) {
            sb.append("\"" + field + "\": " + "\"" + fields.get(field) + "\",");
        }
        sb.append("}");
        return sb.toString();
    }

    public String getField(String profileId, int version, String field) {
        Profile profile = profiles.get(profileId);
        if (profile == null) return null;

        if (profile.versionToMap.containsKey(version)) return null;
        return profile.versionToMap.get(version).get(field);
    }
}
