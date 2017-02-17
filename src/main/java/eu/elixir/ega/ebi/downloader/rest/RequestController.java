/*
 * Copyright ELIXIR EBI
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
package eu.elixir.ega.ebi.downloader.rest;

import eu.elixir.ega.ebi.downloader.domain.entity.DownloadTicket;
import eu.elixir.ega.ebi.downloader.service.RequestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author asenf
 */
@RestController
@RequestMapping("/request")
public class RequestController {
    
    @Autowired
    private RequestService requestService;
        
    // Make a Request POST
    // List a Request GET
    // Delete a Request DELETE
    
    // List All Requests
    @RequestMapping(value = "/{user_email}", method = GET)
    @ResponseBody
    public List<String> listRequests(@PathVariable String user_email) {
        return requestService.listRequests(user_email);
    }
    
    // List Request Tickets
    @RequestMapping(value = "/{user_email}/{label}", method = GET)
    @ResponseBody
    public List<DownloadTicket> listRequestTickets(@PathVariable String user_email, @PathVariable String label) {
        return requestService.listRequestTickets(user_email, label);
    }
    
    // Request File(s) [Dataset = AccessService Functionality]
    @RequestMapping(method = POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void newRequest(@RequestBody List<DownloadTicket> input) {
        requestService.requestFiles(input);
    }
    
    // Delete Ticket(s) [Request = AccessService Functionality]
    @RequestMapping(method = DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSpecificTicket(@RequestBody List<DownloadTicket> input) {
        requestService.deleteRequestTickets(input);
    }
    
    // Delete Request by Label: delete multiple tickets at the same time
    @RequestMapping(value = "/{user_email}/{label}", method = DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRequest(@PathVariable String user_email, @PathVariable String label) {
        requestService.deleteRequest(user_email, label);
    }
    
    // Delete a single request ticket
    @RequestMapping(value = "/{user_email}/ticket/{ticket}", method = DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOneTicket(@PathVariable String user_email, @PathVariable String ticket) {
        requestService.deleteOneTicket(user_email, ticket);
    }

    // List All Requests
    @RequestMapping(value = "/ticket/{ticket_uuid}", method = GET)
    @ResponseBody
    public DownloadTicket listOneTicket(@PathVariable String ticket_uuid) {
        return requestService.listOneTicket(ticket_uuid);
    }
    
}
