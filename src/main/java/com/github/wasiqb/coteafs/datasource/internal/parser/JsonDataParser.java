/*
 * Copyright (c) 2020 Wasiq Bhamla
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
package com.github.wasiqb.coteafs.datasource.internal.parser;

import static com.github.wasiqb.coteafs.datasource.utils.StringUtils.interpolate;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.JsonParserDelegate;

/**
 * @author Wasiq Bhamla
 * @since 03-Oct-2019
 */
public class JsonDataParser extends JsonParserDelegate {
    /**
     * @param d
     *
     * @author Wasiq Bhamla
     * @since 03-Oct-2019
     */
    public JsonDataParser (final JsonParser d) {
        super (d);
    }

    /*
     * (non-Javadoc)
     * @see @see com.fasterxml.jackson.core.util.JsonParserDelegate#getText()
     */
    @Override
    public String getText () throws IOException {
        return interpolate (super.getText ());
    }

    /*
     * (non-Javadoc)
     * @see @see
     * com.fasterxml.jackson.core.util.JsonParserDelegate#getValueAsString()
     */
    @Override
    public String getValueAsString () throws IOException {
        return interpolate (super.getValueAsString ());
    }

    /*
     * (non-Javadoc)
     * @see @see
     * com.fasterxml.jackson.core.util.JsonParserDelegate#getValueAsString(java.lang
     * .String)
     */
    @Override
    public String getValueAsString (final String defaultValue) throws IOException {
        return interpolate (super.getValueAsString (defaultValue));
    }
}