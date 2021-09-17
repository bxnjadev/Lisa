package net.ibxnjadev.kruby.core.storage.local;

import java.io.File;

/**
 * Local storage
 * @param <V>
 */

public interface LocalStorage<V> extends Storage<V> {

    /**
     * The directory for search the files
     * @return the directory
     */
    File getDirectory();

}
