package org.springframework.social.office365.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.office365.api.Office365;
import org.springframework.social.office365.api.impl.Office365Template;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
public class Office365ServiceProvider extends AbstractOAuth2ServiceProvider<Office365>
{
    public Office365ServiceProvider(String clientId,
                                    String clientSecret)
    {
        super(new Office365OAuth2Template(clientId, clientSecret));
        ((OAuth2Template) getOAuthOperations()).setUseParametersForClientAuthentication(true);
    }

    @Override
    public Office365 getApi(String accessToken)
    {
        return new Office365Template(accessToken);
    }

}
