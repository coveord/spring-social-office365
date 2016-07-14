package org.springframework.social.office365.rest.errorhandling;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
public class Office365RestTemplateErrorHandler extends DefaultResponseErrorHandler implements ResponseErrorHandler
{
    private static final Logger log = Logger.getLogger(Office365RestTemplateErrorHandler.class.getName());

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException
    {
        if (super.hasError(response)) {
            log.log(Level.SEVERE, IOUtils.toString(response.getBody()));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException
    {
        super.handleError(response);
    }

}
