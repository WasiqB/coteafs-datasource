/*
 * Copyright (c) 2020 {name of copyright owner}
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.wasiqb.coteafs.datasource.utils;

import static com.github.wasiqb.coteafs.error.util.ErrorUtil.fail;
import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.LOWER_HYPHEN;
import static java.lang.System.getProperty;
import static java.text.MessageFormat.format;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.io.File;

import com.github.wasiqb.coteafs.datasource.annotation.DataFile;
import com.github.wasiqb.coteafs.error.OperationNotSupportedError;

public class DataFileUtil<T> {
    private final Class<T> dataClass;
    private final DataFile dataFile;

    public DataFileUtil (final Class<T> dataClass) {
        this.dataClass = dataClass;
        validateDataClass ();
        this.dataFile = dataClass.getAnnotation (DataFile.class);
    }

    public String getFileName () {
        if (isNotEmpty (this.dataFile.fileName ())) {
            return this.dataFile.fileName ();
        }
        final String fileName = LOWER_CAMEL.to (LOWER_HYPHEN, this.dataClass.getSimpleName ());
        final File folder = new File (getFolder ());
        final File[] files = folder.listFiles ((d, f) -> f.startsWith (fileName));
        if (files.length == 0) {
            fail (OperationNotSupportedError.class, format ("File [{0}] not found.", fileName));
        }
        return files[0].getName ();
    }

    public String getFolder () {
        String folder = format ("{0}/src/test/resources", getProperty ("user.dir"));
        if (isNotEmpty (this.dataFile.folderPath ())) {
            folder = this.dataFile.folderPath ();
        }
        final File dir = new File (folder);
        if (!dir.isDirectory ()) {
            fail (OperationNotSupportedError.class, format ("[{0}] is not a directory.", folder));
        }
        return folder;
    }

    public String getPath () {
        return format ("{0}/{1}", getFolder (), getFileName ());
    }

    private void validateDataClass () {
        if (!this.dataClass.isAnnotationPresent (DataFile.class)) {
            fail (OperationNotSupportedError.class, "Data Class must have @DataFile annotation.");
        }
    }
}