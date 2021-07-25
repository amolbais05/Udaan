Create two databases for running and testing the service locally:

    create database covid;
    create user springusr;
    alter user springusr with encrypted password 'springpass';
    grant all privileges on database spring to springusr;

    create database covidtest;
    create user springtest;
    alter user springtest with encrypted password 'springpass';
    grant all privileges on database springtest to springtest;