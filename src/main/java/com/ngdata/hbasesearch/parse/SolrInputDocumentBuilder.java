/*
 * Copyright 2013 NGDATA nv
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
package com.ngdata.hbasesearch.parse;

import java.util.Map.Entry;

import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.SolrInputField;

/**
 * Builds a SolrInputDocument based on the merged contents of multiple other SolrInputDocuments.
 */
public class SolrInputDocumentBuilder {
    
    private SolrInputDocument document = new SolrInputDocument();

    /**
     * Merge a {@code SolrInputDocument} into the master document being built.
     * 
     * @param inputDocument document to be merged
     */
    public void add(SolrInputDocument inputDocument) {
        for (Entry<String, SolrInputField> entry : inputDocument.entrySet()) {
            SolrInputField inputField = entry.getValue();
            document.addField(entry.getKey(), inputField.getValues(), inputField.getBoost());
        }
    }

    /**
     * Returns the merged {@code SolrInputDocument}.
     * 
     * @return the merged input document
     */
    public SolrInputDocument getDocument() {
        return document;
    }
}
