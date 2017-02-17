/*
 * Copyright 2016 ELIXIR EBI
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.elixir.ega.ebi.downloader.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author asenf
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "file")
public class File implements Serializable {
    
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "file_id")
        private int fileId;
        
        @Size(max=128)
        @Column(name = "dataset_stable_id", insertable = false, updatable = false, length=128)
        private String datasetStableId;
        
        @Size(max=128)
        @Column(name = "packet_stable_id", insertable = false, updatable = false, length=128)
        private String packetStableId;
        
        @Size(max=256)
        @Column(name = "file_name", insertable = false, updatable = false, length=256)
        private String fileName;
        
        @Size(max=256)
        @Column(name = "index_name", insertable = false, updatable = false, length=256)
        private String indexName;
        
        @Column(insertable = false, updatable = false)
        private long size;
        
        @Size(max=128)
        @Column(name = "stable_id", insertable = false, updatable = false, length=128)
        private String stableId;
        
        @Size(max=13)
        @Column(insertable = false, updatable = false, length=13)
        private String status;
        
        /*
         *
         */
        
        public String toString() {
                String line = "";
                
                line += "File ID: " + fileId + "\n" +
                    "Datset Stable ID: " + datasetStableId + "\n" +
                    "Packet StableID: " + packetStableId + "\n" +
                    "File Name: " + fileName + "\n" +
                    "Index Name: " + indexName + "\n" +
                    "File Size: " + size + "\n" +
                    "Stable ID: " + stableId + "\n" +
                    "Status: " + status;
                
                return line;
        }
}
