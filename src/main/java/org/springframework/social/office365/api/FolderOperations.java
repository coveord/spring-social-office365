package org.springframework.social.office365.api;

import java.util.List;

import org.springframework.social.office365.api.domain.FileSystemItem;
import org.springframework.social.office365.api.domain.Folder;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
public interface FolderOperations
{
    Folder getFolder(String folderPath);

    Folder getRootFolder();

    List<FileSystemItem> getFolderItems(String folderPath);

    List<FileSystemItem> getRootFolderItems();

}
