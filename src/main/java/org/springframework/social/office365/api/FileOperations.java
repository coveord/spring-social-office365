package org.springframework.social.office365.api;

import org.springframework.social.office365.api.domain.File;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
public interface FileOperations
{
    File getFile(String filePath);

    byte[] getFileData(String filePath);
}
