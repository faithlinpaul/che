/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.api.resources;

import com.google.common.annotations.Beta;

import org.eclipse.che.api.promises.client.Promise;
import org.eclipse.che.ide.resource.Path;

/**
 * Files are leaf resources which contain data. The contents of a file resource is stored as a file in the local file system.
 * <p/>
 * File extends also {@link VirtualFile}, so this resource can be easily opened in editor.
 * <p/>
 * File instance can be obtained by calling {@link Container#getFile(Path)} or by {@link Container#getChildren(boolean)}.
 * <p/>
 * Note. This interface is not intended to be implemented by clients.
 *
 * @author Vlad Zhukovskyi
 * @see VirtualFile
 * @see Container#getFile(Path)
 * @since 4.0.0-RC14
 */
@Beta
public interface File extends Resource, VirtualFile {

    /** @see VirtualFile#getPath() */
    String getPath();

    /** @see VirtualFile#getDisplayName() */
    String getDisplayName();

    /** @see VirtualFile#getMediaType() */
    String getMediaType();

    /** @see VirtualFile#isReadOnly() */
    boolean isReadOnly();

    /** @see VirtualFile#getContentUrl() */
    String getContentUrl();

    /** @see VirtualFile#getContent() */
    Promise<String> getContent();

    /** @see VirtualFile#updateContent(String) */
    Promise<Void> updateContent(String content);

    /**
     * Returns the file extension portion of this resource's name or {@code null} if it does not have one.
     *
     * @return a string file extension or {@code null}
     * @see #getName()
     * @since 4.0.0-RC14
     */
    String getFileExtension();
}
