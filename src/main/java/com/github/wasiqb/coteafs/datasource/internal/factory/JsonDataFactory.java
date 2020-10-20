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
package com.github.wasiqb.coteafs.datasource.internal.factory;

import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.github.wasiqb.coteafs.datasource.internal.parser.JsonDataParser;

/**
 * @author Wasiq Bhamla
 * @since 03-Oct-2019
 */
public class JsonDataFactory extends MappingJsonFactory {
    private static final long serialVersionUID = 7623910291405568916L;

    /**
     * @author Wasiq Bhamla
     * @since 03-Oct-2019
     */
    public JsonDataFactory () {
        super ();
    }

    /*
     * (non-Javadoc)
     * @see @see com.fasterxml.jackson.core.JsonFactory#_createParser(byte[], int,
     * int, com.fasterxml.jackson.core.io.IOContext)
     */
    @Override
    protected JsonParser _createParser (final byte[] data, final int offset, final int len, final IOContext ctxt)
        throws IOException {
        return new JsonDataParser (super._createParser (data, offset, len, ctxt));
    }

    /*
     * (non-Javadoc)
     * @see @see com.fasterxml.jackson.core.JsonFactory#_createParser(char[], int,
     * int, com.fasterxml.jackson.core.io.IOContext, boolean)
     */
    @Override
    protected JsonParser _createParser (final char[] data, final int offset, final int len, final IOContext ctxt,
        final boolean recyclable) throws IOException {
        return new JsonDataParser (super._createParser (data, offset, len, ctxt, recyclable));
    }

    /*
     * (non-Javadoc)
     * @see @see
     * com.fasterxml.jackson.core.JsonFactory#_createParser(java.io.DataInput,
     * com.fasterxml.jackson.core.io.IOContext)
     */
    @Override
    protected JsonParser _createParser (final DataInput input, final IOContext ctxt) throws IOException {
        return new JsonDataParser (super._createParser (input, ctxt));
    }

    /*
     * (non-Javadoc)
     * @see @see
     * com.fasterxml.jackson.core.JsonFactory#_createParser(java.io.InputStream,
     * com.fasterxml.jackson.core.io.IOContext)
     */
    @Override
    protected JsonParser _createParser (final InputStream in, final IOContext ctxt) throws IOException {
        return new JsonDataParser (super._createParser (in, ctxt));
    }

    /*
     * (non-Javadoc)
     * @see @see
     * com.fasterxml.jackson.core.JsonFactory#_createParser(java.io.Reader,
     * com.fasterxml.jackson.core.io.IOContext)
     */
    @Override
    protected JsonParser _createParser (final Reader r, final IOContext ctxt) throws IOException {
        return new JsonDataParser (super._createParser (r, ctxt));
    }
}