/*
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.portal.events.tincan.json;

import java.io.IOException;
import java.util.Locale;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.jasig.portal.events.tincan.om.LocalizedString;
import org.jasig.portal.events.tincan.om.LrsVerb;

public class LrsVerbSerializer extends JsonSerializer<LrsVerb> {

    @Override
    public void serialize(LrsVerb value, JsonGenerator jgen,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeStringField("id", value.getUri());
        
        //TODO need to make this localizable
//        jgen.writeObjectFieldStart("display");
//        jgen.writeStringField("en-US", value.name().toLowerCase());
//        jgen.writeEndObject();
        jgen.writeObjectField("display", new LocalizedString(new Locale("en-US"), value.name().toLowerCase()));
        
        jgen.writeEndObject();
    }

}