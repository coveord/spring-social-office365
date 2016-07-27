package org.springframework.social.office365.api.impl;

import java.net.URI;

import org.springframework.social.office365.api.UserOperations;
import org.springframework.social.office365.api.domain.User;
import org.springframework.web.client.RestTemplate;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
public class UserTemplate extends AbstractTemplate implements UserOperations
{
    private final RestTemplate restTemplate;
    private boolean isAuthorized;
    private String url;

    public UserTemplate(RestTemplate restTemplate,
                        boolean isAuthorized,
                        String baseUrl)
    {
        this.restTemplate = restTemplate;
        this.isAuthorized = isAuthorized;
        this.url = baseUrl;
    }

    @Override
    public User getUserProfile()
    {
        checkAuthorization(isAuthorized);

        return restTemplate.getForObject(URI.create(url + "/me?api-version=2013-11-08"), User.class);
    }

    @Override
    public byte[] getUserThumbnailPhoto(String userId)
    {
        checkAuthorization(isAuthorized);

        return restTemplate.getForObject(URI.create(url + "/myorganization/users/" + userId
                                                 + "/thumbnailPhoto?api-version=2013-11-08"),
                                         byte[].class);
    }
}
