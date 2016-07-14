package org.springframework.social.office365.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.office365.api.Office365;
import org.springframework.social.office365.api.domain.User;
import org.springframework.util.StringUtils;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
public class Office365Adapter implements ApiAdapter<Office365>
{
    @Override
    public boolean test(Office365 api)
    {
        try {
            api.userOperations().getUserProfile();
            return true;
        } catch (ApiException e) {
            return false;
        }
    }

    @Override
    public void setConnectionValues(Office365 api,
                                    ConnectionValues connectionValues)
    {
        User userProfile = api.userOperations().getUserProfile();

        connectionValues.setProviderUserId(userProfile.getId());
        connectionValues.setDisplayName(userProfile.getDisplayName());
    }

    @Override
    public UserProfile fetchUserProfile(Office365 api)
    {
        User userProfile = api.userOperations().getUserProfile();
        return new UserProfileBuilder().setFirstName(userProfile.getGivenName())
                                       .setLastName(userProfile.getSurname())
                                       .setName(userProfile.getDisplayName())
                                       .setEmail(StringUtils.isEmpty(userProfile.getEmail()) ? userProfile.getUserPrincipalName()
                                                                                            : userProfile.getEmail())
                                       .setUsername(userProfile.getUserPrincipalName())
                                       .build();
    }

    @Override
    public void updateStatus(Office365 api,
                             String message)
    {
        // Do nothing.
    }
}
