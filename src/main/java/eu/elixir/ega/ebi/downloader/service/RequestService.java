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
package eu.elixir.ega.ebi.downloader.service;

import eu.elixir.ega.ebi.downloader.domain.entity.DownloadTicket;
import java.util.List;

/**
 *
 * @author asenf
 */
public interface RequestService {
    
        public void requestFiles(List<DownloadTicket> downloadTickets);
        
        public List<DownloadTicket> listRequestTickets(String user_email, String label);
        
        public List<String> listRequests(String user_email);
        
        public void deleteRequestTickets(List<DownloadTicket> deleteTickets);
        
        public void deleteRequest(String user_email, String label);
        
        public void deleteOneTicket(String user_email, String ticket);
    
        public DownloadTicket listOneTicket(String ticket);

}
