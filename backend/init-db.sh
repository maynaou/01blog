#!/bin/bash
# Supprimer la base si elle existe
psql -U $POSTGRES_USER -c "DROP DATABASE IF EXISTS blogdb;"
# Créer la base de données
psql -U $POSTGRES_USER -c "CREATE DATABASE blogdb;"
