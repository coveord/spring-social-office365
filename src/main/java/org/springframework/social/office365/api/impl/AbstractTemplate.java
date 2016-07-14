package org.springframework.social.office365.api.impl;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.office365.api.Office365;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
public abstract class AbstractTemplate
{
    public void checkAuthorization(boolean isAuthorized)
    {
        if (!isAuthorized) {
            throw new MissingAuthorizationException(Office365.PROVIDER_NAME);
        }
    }
}
