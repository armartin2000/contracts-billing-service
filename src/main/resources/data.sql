insert into user (username, password, firstname, lastname) values ('tony', 'password', 'Tony', 'Martinez');
insert into user (username, password, firstname, lastname) values ('admin', 'password', 'Addy', 'Admin');

insert into contract_parent_account(name) values ('Tony Corp 2016 Contracts');

insert into site (name) values ('site1');
insert into site (name) values ('site2');
insert into site (name) values ('site3');
insert into site (name) values ('site4');
insert into site (name) values ('site5');

-- Service Order for User #1 with related parent account #1
insert into contract (contract_number, contract_parent_account_id, effective_date, termination_date, sum_total_services_rate, recurring_billing_cycle, term, term_type, termlimit, user_id) values ('WT-239', 1,'2015-11-24T01:14:33.228Z', '2018-11-24T01:14:33.228Z', 275.00, 0, 3, 1, 'none', 1);
insert into service_order (id) values (1);
insert into service_item (billing_cycle_enum, description, rate, rate_type) values (0, 'Configuration and testing of equipment', 3485.00, 1);
insert into service_item (billing_cycle_enum, description, rate, rate_type) values (0, 'Remote site VPN', 275.00, 0);
insert into service_order_service_items (service_order_id, service_items_id) values (1, 1);
insert into service_order_service_items (service_order_id, service_items_id) values (1, 2);

-- Service Agreement for User #1 with related parent account #1
insert into contract (contract_number, contract_parent_account_id, effective_date, termination_date, sum_total_services_rate, term, term_type, termlimit, user_id) values ('SA-434', 1, '2014-02-18T01:14:33.228Z', '2016-06-18T01:14:33.228Z', 125.00, 3, 1, 'up to 160 hours', 1);
insert into service_agreement (id, project_summary, sow_description, billing_rate_type ) values (2, 'This SOW covers the dicovery and documentation...', 'Document and evaluate IP Address..', 2);

-- Line Item Contract for User #1 with related parent account #1
insert into contract (contract_number, contract_parent_account_id, effective_date, termination_date, sum_total_services_rate, recurring_billing_cycle, term, term_type, termlimit, user_id) values ('HB-134', 1,'2014-02-01T01:14:33.228Z', '2016-02-29T01:14:33.228Z', 52470.00, 0, 2, 1, 'none', 1);
insert into line_item_contract (id) values (3);
insert into service_item (billing_cycle_enum, description, rate, rate_type, site_id) values (0, '100 Mbps MPLS', 7422.00, 1, 1);
insert into service_item (billing_cycle_enum, description, rate, rate_type, site_id) values (0, '100 Mbps MPLS', 245.00, 0, 2);
insert into service_item (billing_cycle_enum, description, rate, rate_type, site_id) values (0, '100 Mbps MPLS', 3325.00, 0, 3);
insert into service_item (billing_cycle_enum, description, rate, rate_type, site_id) values (0, '100 Mbps MPLS', 3618.00, 0, 4);
insert into service_item (billing_cycle_enum, description, rate, rate_type, site_id) values (0, '100 Mbps MPLS', 4093.00, 0, 5);
insert into line_item_contract_service_items (line_item_contract_id, service_items_id) values (3, 3);
insert into line_item_contract_service_items (line_item_contract_id, service_items_id) values (3, 4);
insert into line_item_contract_service_items (line_item_contract_id, service_items_id) values (3, 5);
insert into line_item_contract_service_items (line_item_contract_id, service_items_id) values (3, 6);
insert into line_item_contract_service_items (line_item_contract_id, service_items_id) values (3, 7);

insert into invoice(invoice_number, contract_parent_account_id, contract_id, status, due_date) values ('335783', 1, 3, 0, '2016-01-28T01:14:33.228Z')
