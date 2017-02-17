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

CREATE TABLE dev_ega_downloader.download_ticket_status_cv (
	ticket_status varchar(28) NOT NULL,
	CONSTRAINT download_ticket_status_cv_pkey PRIMARY KEY (ticket_status)
)
WITH (
	OIDS=FALSE
);

insert into dev_ega_downloader.download_ticket_status_cv (ticket_status) values ('ready');