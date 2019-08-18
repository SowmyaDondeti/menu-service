create table menu (
      id serial primary key,
      name varchar not null,
      description varchar not null,
      price numeric not null
    );