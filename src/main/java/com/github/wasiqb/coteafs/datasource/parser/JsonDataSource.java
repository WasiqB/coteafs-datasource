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

package com.github.wasiqb.coteafs.datasource.parser;

import static com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

/**
 * Json data source parser.
 *
 * @author Wasiq Bhamla
 * @since 19-08-2020
 */
public class JsonDataSource implements IDataSource {
    private final ObjectMapper mapper;

    public JsonDataSource () {
        this.mapper = new ObjectMapper ();
        this.mapper.setPropertyNamingStrategy (SNAKE_CASE);
    }

    @SneakyThrows
    @Override
    public <T> T parse (final String path, final Class<T> dataClass) {
        return this.mapper.readValue (new File (path), dataClass);
    }
}