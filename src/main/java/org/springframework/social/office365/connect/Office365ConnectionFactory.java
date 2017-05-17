package org.springframework.social.office365.connect;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.office365.api.Office365;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Edited by : Frederic Boutin (fredboutin)
 * Date: 16/05/2017
 */
public class Office365ConnectionFactory extends OAuth2ConnectionFactory<Office365>
{
    public Office365ConnectionFactory(String clientId,
                                      String clientSecret,
                                      ClientHttpRequestFactory clientHttpRequestFactory)
    {
        super(Office365.PROVIDER_NAME,
              new Office365ServiceProvider(clientId, clientSecret, clientHttpRequestFactory),
              new Office365Adapter());
    }
}
