package net.ibxnjadev.kruby.abstraction.storage.local;

import net.ibxnjadev.kruby.abstraction.util.Storage;

import java.io.File;

/**
 * Local storage
 * @param <String>
 * @param <V>
 */

public interface LocalStorage<String,V> extends Storage<String,V> {

    /**
     * The directory for search the files
     * @return the directory
     */
    File getDirectory();

}
