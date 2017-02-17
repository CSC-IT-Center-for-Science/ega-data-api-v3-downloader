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
package eu.elixir.ega.ebi.downloader.domain.repository;

import eu.elixir.ega.ebi.downloader.domain.entity.DownloadTicket;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author asenf
 */
public interface DownloadTicketRepository extends CrudRepository<DownloadTicket, Long> {

    public List<DownloadTicket> findByUserEmailAndLabel(String userEmail, String label);

    public DownloadTicket findBydownloadTicket(String downloadTicketId);
    
    //public List<String> findLabelsByUserEmail(String userEmail);

    @Modifying
    @Transactional
    public void deleteByUserEmailAndLabel(String userEmail, String label);

    @Modifying
    @Transactional
    public void deleteByUserEmailAndDownloadTicket(String userEmail, String downloadTicket);
    
    //@Query("SELECT p FROM DownloadTicket p WHERE p.userEmail = :userEmail AND p.label = :label")
    //public List<DownloadTicket> findByRequest(@Param("userEmail") String userEmail, @Param("label") String label);
    
    @Query("SELECT DISTINCT p.label FROM DownloadTicket p WHERE p.userEmail = :userEmail")
    public List<String> listRequests(@Param("userEmail") String userEmail);
 
    //@Modifying
    //@Query("DELETE FROM DownloadTicket p WHERE p.userEmail = :userEmail and p.label = :label")
    //public void deleteRequest(@Param("userEmail") String userEmail, @Param("label") String label);
    
    //@Modifying
    //@Query("DELETE FROM DownloadTicket p WHERE p.userEmail = :userEmail and p.downloadTicket = :downloadTicket")
    //public void deleteTicket(@Param("userEmail") String userEmail, @Param("downloadTicket") String downloadTicket);
}
