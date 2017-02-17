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
package eu.elixir.ega.ebi.downloader.service.internal;

import eu.elixir.ega.ebi.downloader.domain.entity.DownloadTicket;
import eu.elixir.ega.ebi.downloader.domain.repository.DownloadTicketRepository;
import eu.elixir.ega.ebi.downloader.service.RequestService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asenf
 */
@Service
@Transactional
public class RequestServiceImpl implements RequestService {
    
    @Autowired
    private DownloadTicketRepository ticketRepository;

    @Override
    public void requestFiles(List<DownloadTicket> downloadTickets) {
        ticketRepository.save(downloadTickets);
    }

    @Override
    public List<DownloadTicket> listRequestTickets(String user_email, String label) {
        return ticketRepository.findByUserEmailAndLabel(user_email, label);
    }

    @Override
    public List<String> listRequests(String user_email) {
        return ticketRepository.listRequests(user_email);
    }

    @Override
    public void deleteRequestTickets(List<DownloadTicket> deleteTickets) {
        ticketRepository.delete(deleteTickets);
    }

    @Override
    public void deleteRequest(String user_email, String label) {
        ticketRepository.deleteByUserEmailAndLabel(user_email, label);
    }

    @Override
    public void deleteOneTicket(String user_email, String ticket) {
        ticketRepository.deleteByUserEmailAndDownloadTicket(user_email, ticket);
    }

    @Override
    public DownloadTicket listOneTicket(String ticket) {
        return ticketRepository.findBydownloadTicket(ticket);
    }

}
