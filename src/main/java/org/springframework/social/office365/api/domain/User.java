package org.springframework.social.office365.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("objectId")
    private String id;

    @JsonProperty("givenName")
    private String givenName;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("userPrincipalName")
    private String userPrincipalName;
    
    @JsonProperty("mail")
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUserPrincipalName() {
        return userPrincipalName;
    }
    
    public void setUserPrincipalName(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
