#!/bin/bash -e
printf "\nCopy database connection resource file...\n"
mkdir --parents --verbose ~/.geotools
cp --verbose --force ./build/ci/mssql/sqlserver.properties ~/.geotools/

printf "\nCreate GEOTOOLS database...\n"
docker exec -i geotools /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P "Password12!" -Q 'CREATE DATABASE geotools' -d "master"
