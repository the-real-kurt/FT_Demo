#!/bin/bash
printf "Getting 11\n";
curl --location 'http://localhost:8080/invoice/11111111-1111-1111-1111-111111111111'

printf "\nGetting 12\n";
curl --location 'http://localhost:8080/invoice/11111111-1111-1111-1111-111111111112'

printf "\nGetting non-existent invoice\n";
curl --location 'http://localhost:8080/invoice/11111111-4321-1111-1111-111111111112'


printf "\nGetting Invoices for user 1\n";
curl --location 'http://localhost:8080/invoices/1'


printf "\nGetting Billing Records for user 2\n";
curl --location 'http://localhost:8080/billingRecords/2'


printf "\ndone\n\n";

