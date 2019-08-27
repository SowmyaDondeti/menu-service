create table menu (
      id serial primary key,
      name varchar not null,
      description varchar not null,
      price numeric not null,
      picture_url varchar not null,
      category varchar not null,
      type varchar not null,
      spice_level varchar not null
    );