/*
 * Copyright (c) 2011 - 2016, Coveo Solutions Inc.
 */
package org.springframework.social.office365.connect;

import org.springframework.social.connect.ConnectionData;

public class O365ConnectionData extends ConnectionData
{
    private static final long serialVersionUID = 3410346679545383346L;

    private byte[] photo;

    public O365ConnectionData(String providerId,
                              String providerUserId,
                              String displayName,
                              String profileUrl,
                              String imageUrl,
                              String accessToken,
                              String secret,
                              String refreshToken,
                              Long expireTime,
                              byte[] photo)
    {
        super(providerId,
              providerUserId,
              displayName,
              profileUrl,
              imageUrl,
              accessToken,
              secret,
              refreshToken,
              expireTime);
        this.photo = photo;
    }

    public O365ConnectionData(ConnectionData connectionData,
                              byte[] photo)
    {
        super(connectionData.getProviderId(),
              connectionData.getProviderUserId(),
              connectionData.getDisplayName(),
              connectionData.getProfileUrl(),
              connectionData.getImageUrl(),
              connectionData.getAccessToken(),
              connectionData.getSecret(),
              connectionData.getRefreshToken(),
              connectionData.getExpireTime());
        this.photo = photo;
    }

    public byte[] getPhoto()
    {
        return photo;
    }
}
