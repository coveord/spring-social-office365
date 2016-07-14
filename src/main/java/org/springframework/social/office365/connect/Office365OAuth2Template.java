package org.springframework.social.office365.connect;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
public class Office365OAuth2Template extends OAuth2Template
{
    public static final String AUTHORIZE_URI = "https://login.windows.net/common/oauth2/authorize";
    public static final String ACCESS_TOKEN_URI = "https://login.windows.net/common/oauth2/token";

    public static final String RESOURCE_TO_ACCESS_URI = "https://graph.windows.net";
    public static final String RESOURCE_KEY = "resource";

    public Office365OAuth2Template(String clientId,
                                   String clientSecret)
    {
        super(clientId, clientSecret, AUTHORIZE_URI, ACCESS_TOKEN_URI);
    }

    public Office365OAuth2Template(String clientId,
                                   String clientSecret,
                                   String authenticateUrl)
    {
        super(clientId, clientSecret, AUTHORIZE_URI, authenticateUrl, ACCESS_TOKEN_URI);
    }

    @Override
    public AccessGrant exchangeForAccess(String authorizationCode,
                                         String redirectUri,
                                         MultiValueMap<String, String> additionalParameters)
    {
        if (additionalParameters == null) {
            additionalParameters = new LinkedMultiValueMap<String, String>();
        }

        if (!additionalParameters.containsKey(RESOURCE_KEY)) {
            additionalParameters.add(RESOURCE_KEY, RESOURCE_TO_ACCESS_URI);
        }

        return super.exchangeForAccess(authorizationCode, redirectUri, additionalParameters);
    }
}
