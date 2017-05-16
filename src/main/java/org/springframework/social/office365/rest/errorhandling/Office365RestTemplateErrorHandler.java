package org.springframework.social.office365.rest.errorhandling;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Edited by : Frederic Boutin (fredboutin)
 * Date: 16/05/2017
 */
public class Office365RestTemplateErrorHandler extends DefaultResponseErrorHandler
{
    private static final Logger log = Logger.getLogger(Office365RestTemplateErrorHandler.class.getName());

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException
    {
        if (super.hasError(response)) {
            log.log(Level.SEVERE, IOUtils.toString(response.getBody()));
            return true;
        }
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException
    {
        super.handleError(response);
    }

}
