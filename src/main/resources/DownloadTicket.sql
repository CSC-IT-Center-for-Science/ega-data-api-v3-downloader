/* 
 * Copyright 2017 ELIXIR EBI
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
/**
 * Author:  asenf
 * Created: 17-Feb-2017
 */

CREATE TABLE dev_ega_downloader.download_ticket (
	download_ticket_id int8 NOT NULL DEFAULT nextval('dev_ega_downloader.download_ticket_download_ticket_id_seq'::regclass),
	user_email varchar(256) NOT NULL,
	download_ticket varchar(256) NOT NULL,
	client_ip varchar(45) NOT NULL,
	file_stable_id varchar(15) NOT NULL,
	encryption_key text NOT NULL,
	encryption_type varchar(28) NOT NULL,
	ticket_status varchar(28) NOT NULL,
	label varchar(256) NOT NULL,
	created timestamp NOT NULL DEFAULT now(),
	start_coordinate int8 NOT NULL DEFAULT 0,
	end_coordinate int8 NOT NULL DEFAULT 0,
	CONSTRAINT download_ticket_pkey PRIMARY KEY (download_ticket_id),
	CONSTRAINT download_ticket_ticket_status_fkey FOREIGN KEY (ticket_status) REFERENCES dev_ega_downloader.download_ticket_status_cv(ticket_status)
)
WITH (
	OIDS=FALSE
);