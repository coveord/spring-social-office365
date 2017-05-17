package org.springframework.social.office365.connect;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.support.FormMapHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Edited by : Frederic Boutin (fredboutin)
 * Date: 16/05/2017
 */
public class Office365OAuth2Template extends OAuth2Template
{
    public static final String AUTHORIZE_URI = "https://login.windows.net/common/oauth2/authorize";
    public static final String ACCESS_TOKEN_URI = "https://login.windows.net/common/oauth2/token";

    public static final String RESOURCE_TO_ACCESS_URI = "https://graph.windows.net";
    public static final String RESOURCE_KEY = "resource";

    private ClientHttpRequestFactory clientHttpRequestFactory;

    public Office365OAuth2Template(String clientId,
                                   String clientSecret,
                                   ClientHttpRequestFactory clientHttpRequestFactory)
    {
        super(clientId, clientSecret, AUTHORIZE_URI, ACCESS_TOKEN_URI);
        this.clientHttpRequestFactory = clientHttpRequestFactory;
        setUseParametersForClientAuthentication(true);
    }

    public Office365OAuth2Template(String clientId,
                                   String clientSecret,
                                   String authenticateUrl,
                                   ClientHttpRequestFactory clientHttpRequestFactory)
    {
        super(clientId, clientSecret, AUTHORIZE_URI, authenticateUrl, ACCESS_TOKEN_URI);
        this.clientHttpRequestFactory = clientHttpRequestFactory;
        setUseParametersForClientAuthentication(true);
    }

    @Override
    public AccessGrant exchangeForAccess(String authorizationCode,
                                         String redirectUri,
                                         MultiValueMap<String, String> additionalParameters)
    {
        if (additionalParameters == null) {
            additionalParameters = new LinkedMultiValueMap<>();
        }

        if (!additionalParameters.containsKey(RESOURCE_KEY)) {
            additionalParameters.add(RESOURCE_KEY, RESOURCE_TO_ACCESS_URI);
        }

        return super.exchangeForAccess(authorizationCode, redirectUri, additionalParameters);
    }

    @Override
    protected RestTemplate createRestTemplate()
    {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        List<HttpMessageConverter<?>> converters = new ArrayList<>(2);
        converters.add(new FormHttpMessageConverter());
        converters.add(new FormMapHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(converters);
        return restTemplate;
    }
}
