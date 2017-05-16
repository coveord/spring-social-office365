package org.springframework.social.office365.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.office365.api.Office365;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
public class Office365ConnectionFactory extends OAuth2ConnectionFactory<Office365>
{
    public Office365ConnectionFactory(String clientId, String clientSecret)
    {
        super(Office365.PROVIDER_NAME, new Office365ServiceProvider(clientId, clientSecret), new Office365Adapter());
    }
}
